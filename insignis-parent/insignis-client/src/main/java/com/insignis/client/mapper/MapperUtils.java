package com.insignis.client.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.insignis.client.model.Client;
import com.insignis.shared.dto.ClientDTO;

public class MapperUtils {

	public static Function<ClientDTO, Client> toEntity = (clientDto) -> {
		Client client = new Client();
		client.setId(clientDto.getId());
		client.setName(clientDto.getName());
		client.setUsername(clientDto.getUsername());
		client.setPassword(clientDto.getPassword());
		client.setAddress(com.insignis.shared.mapper.MapperUtils.toAddress.apply(clientDto.getAddress()));
		client.setContacts(clientDto.getContacts().stream().map(com.insignis.shared.mapper.MapperUtils.toContact).collect(Collectors.toList()));
		return client;
	};

	public static Function<Client, ClientDTO> toClientDTO = (client) -> {
		ClientDTO clientDTO = new ClientDTO(client.getId(), client.getName(), client.getUsername(), client.getPassword(),
				com.insignis.shared.mapper.MapperUtils.toAddressDTO.apply(client.getAddress()),
				client.getContacts().stream().map(com.insignis.shared.mapper.MapperUtils.toContactDTO).collect(Collectors.toList()));
		return clientDTO;
	};
}
