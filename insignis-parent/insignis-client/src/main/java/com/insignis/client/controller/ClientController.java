package com.insignis.client.controller;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.insignis.client.mapper.MapperUtils;
import com.insignis.client.model.Client;
import com.insignis.client.service.ClientService;
import com.insignis.shared.dto.ClientDTO;
import com.insignis.shared.exception.NotFoundException;
import com.insignis.shared.operations.BaseResources;

@RestController
@RequestMapping(value = "/client")
public class ClientController implements BaseResources {

	private ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		this.clientService = clientService;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO create(@RequestBody ClientDTO clientDTO) {
		Client created = clientService.save(MapperUtils.toEntity.apply(clientDTO));
		return MapperUtils.toClientDTO.apply(created);
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClientDTO> getAllClients() {
		List<ClientDTO> clients = clientService.findAll().stream().map(MapperUtils.toClientDTO).collect(Collectors.toList());
		return clients;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = FIND_BY_ID, method = RequestMethod.GET, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO findById(@Param("id") String id) throws NotFoundException {
		ClientDTO clientDTO = clientService.findById(id).map(MapperUtils.toClientDTO).orElseThrow(() -> new NotFoundException(MessageFormat.format("client with id {0} not found", id)));
		return clientDTO;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientDTO deleteClient(@RequestParam String id) {
		return MapperUtils.toClientDTO.apply(clientService.deleteClient(id));
	}

}
