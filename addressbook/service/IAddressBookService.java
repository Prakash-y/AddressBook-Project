package com.addressbook.addressbook.service;

import java.util.List;

import com.addressbook.addressbook.dto.AddressBookDto;
import com.addressbook.addressbook.model.AddressBookModel;

import jakarta.validation.Valid;

public interface IAddressBookService {

	AddressBookModel adding(@Valid AddressBookDto model);

	List<AddressBookModel> getAllPerson();

	AddressBookModel getContactById(int id);

	String deleteContactById(int id);

	AddressBookModel updateContactById(int id, @Valid AddressBookDto model);

	AddressBookModel getContactByEmail(String email);

	AddressBookModel getContactByToken(String token);

	AddressBookModel updateContactByToken(String token,@Valid AddressBookDto model);

	AddressBookModel getContactsByToken(String token,int id);

}
