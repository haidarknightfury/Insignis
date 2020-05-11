package com.insignis.shared.mapper;

import java.util.function.Function;

import com.insignis.shared.domain.Address;
import com.insignis.shared.domain.Contact;
import com.insignis.shared.dto.AddressDTO;
import com.insignis.shared.dto.ContactDTO;
import com.insignis.shared.enums.ContactType;

public class MapperUtils {

	public static Function<AddressDTO, Address> toAddress = (addressDto) -> {
		Address address = new Address(addressDto.getStreet(), addressDto.getRegion(), addressDto.getCountry(), addressDto.getPostalCode());
		return address;
	};

	public static Function<Address, AddressDTO> toAddressDTO = (address) -> {
		AddressDTO addressDTO = new AddressDTO(address.getStreet(), address.getRegion(), address.getCountry(), address.getPostalCode());
		return addressDTO;
	};

	public static Function<ContactDTO, Contact> toContact = (contactDto) -> {
		Contact contact = new Contact();
		contact.setContactType(ContactType.valueOf(contactDto.getContactType()));
		contact.setMobileNumber(contactDto.getMobileNumber());
		return contact;
	};

	public static Function<Contact, ContactDTO> toContactDTO = (contact) -> {
		ContactDTO contactDTO = new ContactDTO(contact.getId(), contact.getMobileNumber(), contact.getContactType().toString());
		return contactDTO;
	};

}
