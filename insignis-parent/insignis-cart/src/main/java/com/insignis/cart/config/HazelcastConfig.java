package com.insignis.cart.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.insignis.cart.config.helper.StorageNodeFactoryService;
import com.insignis.cart.service.CartMapStore;

@Configuration
public class HazelcastConfig {

	@Bean(name = "StorageNodeConfig")
	public Config config(CartMapStore cartMapStore) {
		Config config = new Config();

		MapConfig cartMapConfig = new MapConfig();
		MapStoreConfig cartMapStoreConfig = new MapStoreConfig();
		cartMapStoreConfig.setImplementation(cartMapStore);

		cartMapConfig.setMapStoreConfig(cartMapStoreConfig);
		cartMapConfig.setName(cartMapStore.CART_MAP);
		MapIndexConfig idFieldIndex = new MapIndexConfig("id", true);
		cartMapConfig.addMapIndexConfig(idFieldIndex);

		config.addMapConfig(cartMapConfig);
		return config;
	}

	@Bean(destroyMethod = "shutdown")
	public HazelcastInstance createStorageNode(@Qualifier("StorageNodeConfig") Config config) throws Exception {
		return Hazelcast.newHazelcastInstance(config);
	}

	@Bean(name = "ClientInstance", destroyMethod = "shutdown")
	public HazelcastInstance clientInstance(StorageNodeFactoryService storageNodeFactory, ClientConfig config) throws Exception {
		// Ensure there is at least 2 running instance();
		storageNodeFactory.ensureClusterSize(1);
		return HazelcastClient.newHazelcastClient(config);
	}

	@Bean(name = "HazelcastClientConfig")
	public ClientConfig clientConfig() {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.getNetworkConfig().setConnectionAttemptLimit(0);
		return clientConfig;
	}

}
