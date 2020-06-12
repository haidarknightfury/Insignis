package com.insignis.client.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.insignis.client.model.Client;
import com.insignis.shared.dto.ClientDTO;

public class MapperUtils {

	public static Function<ClientDTO, Client> toEntity = (clientDto) -> {
		Client client = new Client();
		client.setId(clientDto.getId());
		client.setUserId(clientDto.getUserId());
		client.setFirstName(clientDto.getFirstName());
		client.setLastName(clientDto.getLastName());
		client.setEmail(clientDto.getEmail());
		client.setAddress(com.insignis.shared.mapper.MapperUtils.toAddress.apply(clientDto.getAddress()));
		client.setContacts(clientDto.getContacts().stream().map(com.insignis.shared.mapper.MapperUtils.toContact).collect(Collectors.toList()));
		return client;
	};

	public static Function<Client, ClientDTO> toClientDTO = (client) -> {
		ClientDTO clientDto = new ClientDTO();
		clientDto.setId(client.getId());
		clientDto.setUserId(client.getUserId());
		clientDto.setFirstName(client.getFirstName());
		clientDto.setLastName(client.getLastName());
		clientDto.setEmail(client.getEmail());
		clientDto.setContacts(client.getContacts().stream().map(com.insignis.shared.mapper.MapperUtils.toContactDTO).collect(Collectors.toList()));
		clientDto.setAddress(com.insignis.shared.mapper.MapperUtils.toAddressDTO.apply(client.getAddress()));
		return clientDto;
	};
}
