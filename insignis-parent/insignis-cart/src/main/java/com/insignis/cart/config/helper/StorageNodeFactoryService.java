package com.insignis.cart.config.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Service
public class StorageNodeFactoryService {

	private Config config;
	List<HazelcastInstance> instances = Collections.synchronizedList(new ArrayList<>());
	private ExecutorService executorService = Executors.newCachedThreadPool();

	@Autowired
	public StorageNodeFactoryService(@Qualifier("StorageNodeConfig") Config config) {
		this.config = config;
	}

	public void ensureClusterSize(int size) throws InterruptedException {
		if (this.instances.size() < size) {
			int diff = size - this.instances.size();
			CountDownLatch latch = new CountDownLatch(diff);
			for (int i = 0; i < diff; i++) {
				this.executorService.submit(new CreateHazelcastInstance(this.config, latch));
			}

			latch.await(10, TimeUnit.SECONDS);
		} else if (this.instances.size() > size) {
			for (int x = this.instances.size() - 1; x >= size; x--) {
				HazelcastInstance instance = this.instances.remove(x);
				instance.shutdown();
			}
		}
	}

	public final class CreateHazelcastInstance implements Callable<HazelcastInstance> {

		private Config config;
		private CountDownLatch latch;

		public CreateHazelcastInstance(Config config, CountDownLatch latch) {
			super();
			this.config = config;
			this.latch = latch;
		}

		@Override
		public HazelcastInstance call() throws Exception {
			HazelcastInstance instance = Hazelcast.newHazelcastInstance(this.config);
			StorageNodeFactoryService.this.instances.add(instance);
			if (this.latch != null) {
				this.latch.countDown();
			}
			return instance;
		}

	}

}
