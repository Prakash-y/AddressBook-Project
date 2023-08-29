package com.addressbook.addressbook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.addressbook.addressbook.model.AddressBookModel;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookModel, Integer> {

	@Query(value="Select * from address_book_model where email =:email",nativeQuery = true)
	Optional<AddressBookModel> findByEmail(String email);

	

}
