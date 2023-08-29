package com.addressbook.addressbook.model;

import com.addressbook.addressbook.dto.AddressBookDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AddressBookModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int pId;
	private String name;
	private String city;
	private String state;
	private int zip;
	private String email;
	private long phoneNumber;
	
	public AddressBookModel(AddressBookDto model)
	{
		this.name=model.getName();
		this.city=model.getCity();
		this.state=model.getState();
		this.zip=model.getZip();
		this.email=model.getEmail();
		this.phoneNumber=model.getPhoneNumber();
		
	}
	
}
