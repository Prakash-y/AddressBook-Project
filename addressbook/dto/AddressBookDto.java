package com.addressbook.addressbook.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressBookDto {

    @Pattern(regexp="^[A-Z]{1}[a-zA-Z]{3,}$", message="Name should be as per standard")
	private String name;
    @NotEmpty
	private String city;
    @NotEmpty
	private String state;
    @NotNull
	private int zip;
    @Pattern(regexp="^[A-Za-z0-9+_.-]+@(.+)$", message="Email id should be as per standard")
	private String email;
	@NotNull
	private long phoneNumber;
}
