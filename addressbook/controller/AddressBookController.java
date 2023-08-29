package com.addressbook.addressbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.addressbook.addressbook.dto.AddressBookDto;
import com.addressbook.addressbook.dto.ResponseDto;
import com.addressbook.addressbook.model.AddressBookModel;
import com.addressbook.addressbook.service.IAddressBookService;


import jakarta.validation.Valid;

@RestController
public class AddressBookController {

	@Autowired
	 IAddressBookService service;
	
	// This is a post api
	@PostMapping("/post")
	public ResponseEntity<ResponseDto> insertingEmployee(@Valid @RequestBody AddressBookDto model)
	{
		AddressBookModel user = service.adding(model);
		ResponseDto response = new ResponseDto(user,"User added succesfully!");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.CREATED);
	}
	
	//Get all contacts api
	@GetMapping("/get")
	public ResponseEntity<ResponseDto> getAll()
	{
		List<AddressBookModel> user = service.getAllPerson();
		ResponseDto response = new ResponseDto(user,"List of contact!");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	//This is a get by id api
	@GetMapping("/getById/{id}")
	public ResponseEntity<ResponseDto> getById(@PathVariable int id) {
		AddressBookModel user = service.getContactById(id);
		ResponseDto response = new ResponseDto(user,"Contact by ID.");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	//This is a delete by id api
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<ResponseDto> deleteById(@PathVariable int id)
	{
		String delete = service.deleteContactById(id);
		ResponseDto response = new ResponseDto(delete,"deleting contact by id!");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.ACCEPTED);
	}
	
	//This is a update by id api
	@PutMapping("/updateById/{id}")
	public  ResponseEntity<ResponseDto> updateById(@PathVariable int id, @Valid  @RequestBody AddressBookDto model)
	{
		AddressBookModel user = service.updateContactById(id, model);
		ResponseDto response = new ResponseDto(user,"Update contact details by id");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.ACCEPTED);
	}
	
	//This is a get by email api
	@GetMapping("/getByEmail/{email}")
	public ResponseEntity<ResponseDto> getByEmail(@PathVariable String email) {
		AddressBookModel searchByEmail = service.getContactByEmail(email);
		ResponseDto response = new ResponseDto(searchByEmail,"Contact by Email.");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	//This is a get by token api
	@GetMapping("/getByToken/{token}")
	public ResponseEntity<ResponseDto> getByToken(@PathVariable String token, @RequestBody AddressBookDto model) {
		AddressBookModel user = service.getContactByToken(token);
		ResponseDto response = new ResponseDto(user,"Contact by Token.");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	//This is a update by token api
	@PutMapping("/updateByToken/{token}")
	public ResponseEntity<ResponseDto> updateByToken(@PathVariable String token, @RequestBody AddressBookDto model) {
		AddressBookModel searchByEmail = service.updateContactByToken(token, model);
		ResponseDto response = new ResponseDto(searchByEmail,"Contact by Email.");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	@GetMapping("/getByIdToken/{id}")
	public ResponseEntity<ResponseDto> getByToken(String token, @PathVariable int id) {
		AddressBookModel user = service.getContactsByToken(token,id);
		ResponseDto response = new ResponseDto(user,"Contact by Id.");
		return new ResponseEntity<ResponseDto>(response,HttpStatus.OK);
	}
	
	
}
