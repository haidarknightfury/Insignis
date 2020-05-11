package com.insignis.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insignis.client.model.Client;
import com.insignis.client.repository.ClientRepository;
import com.insignis.shared.exception.NotFoundException;

@Service
public class ClientService {

	private ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	public Client save(Client client) {
		return this.clientRepository.save(client);
	}

	public List<Client> findAll() {
		return this.clientRepository.findAll();
	}

	public Client update(Client client) throws NotFoundException {
		Optional<Client> mongoClient = clientRepository.findById(client.getId());
		try {
			Client cli = mongoClient.get();
			cli.setAddress(client.getAddress());
			cli.setContacts(client.getContacts());
			cli.setName(client.getName());
			cli.setUsername(client.getUsername());
			cli.setPassword(client.getPassword());
			return clientRepository.save(cli);
		} catch (NullPointerException e) {
			throw new NotFoundException("Client could not be found");
		} catch (Exception e) {
			throw e;
		}
	}

	public Optional<Client> findByName(String name) {
		return clientRepository.findByNameIgnoreCase(name);
	}

	public Optional<Client> findByUsername(String username) {
		return clientRepository.findByUsername(username);
	}

	public Optional<Client> findById(String id) {
		return clientRepository.findById(id);
	}

}
