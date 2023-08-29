package com.addressbook.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.addressbook.addressbook.dto.AddressBookDto;
import com.addressbook.addressbook.exception.AddressBookException;

import com.addressbook.addressbook.model.AddressBookModel;
import com.addressbook.addressbook.repository.AddressBookRepository;
import com.addressbook.addressbook.util.TokenUtil;

import jakarta.validation.Valid;


@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private AddressBookRepository repo;

	@Autowired
	TokenUtil tokenUtil;
	
	//Post logic
	@Override
	public AddressBookModel adding(AddressBookDto model) 
	{
		AddressBookModel user = new AddressBookModel(model);
		repo.save(user);
		String token=tokenUtil.createToken(user.getPId());
		System.out.println(token);
		
		return user;
	}

	//get all contacts logic
	@Override
	public List<AddressBookModel> getAllPerson() 
	{
		return repo.findAll();
		
	}

	//get by id contacts logic
	@Override
	public AddressBookModel getContactById(int id) {
		
		Optional<AddressBookModel> user = repo.findById(id);
		if(user.isPresent())
		{
			return user.get();
		}
		else throw new AddressBookException("Id not found!");
		
		
	}

	//delete by id contacts logic
	@Override
	public String deleteContactById(int id) {
		Optional<AddressBookModel> user = repo.findById(id);
		if(user.isPresent())
		{
			repo.deleteById(id);
			return "Deleted Succefully!";
		}
		else
		{
			throw new AddressBookException("ID Not Found");
		}
		
		
	}

	//update by id contacts logic
	@Override
	public AddressBookModel updateContactById(int id, AddressBookDto model) {
		AddressBookModel AddressModel = repo.findById(id).get();
		if(AddressModel != null)
		{
		AddressModel.setName(model.getName());
		AddressModel.setCity(model.getCity());
		AddressModel.setState(model.getState());
		AddressModel.setZip(model.getZip());
		AddressModel.setEmail(model.getEmail());
		AddressModel.setPhoneNumber(model.getPhoneNumber());
		repo.save(AddressModel);
		return AddressModel;
		}
		else
		{
			 throw new AddressBookException("Contact found exception. ");
		}
		
	}

	//get by email logic
	@Override
	public AddressBookModel getContactByEmail(String email) {
		Optional<AddressBookModel> user = repo.findByEmail(email);
		if(user.isPresent())
		{
			return user.get();
		}
		else
		{
			throw new AddressBookException("Email not found!");
		}
		
	}

	//get by token logic
	@Override
	public AddressBookModel getContactByToken(String token) {
		int userId =tokenUtil.decodeToken(token);
		
		return repo.findById(userId).get();
	}


	//update by token logic
	@Override
	public AddressBookModel updateContactByToken(String token, AddressBookDto model) {
		
		int userId =tokenUtil.decodeToken(token);
		Optional<AddressBookModel> AddressModel = repo.findById(userId);
		
		AddressModel.get().setName(model.getName());
		AddressModel.get().setCity(model.getCity());
		AddressModel.get().setState(model.getState());
		AddressModel.get().setZip(model.getZip());
		AddressModel.get().setEmail(model.getEmail());
		AddressModel.get().setPhoneNumber(model.getPhoneNumber());
		repo.save(AddressModel.get());
		return AddressModel.get();
		
	}

	@Override
	public AddressBookModel getContactsByToken(String token, int id) {
		int userId =tokenUtil.decodeToken(token);
		
		if(userId == id)
		{
			Optional<AddressBookModel> user = repo.findById(userId);
			return user.get();	
		}
		else throw new AddressBookException("Person Not found!");
	}

	}
		
	

