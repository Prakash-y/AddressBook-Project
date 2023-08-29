package com.addressbook.addressbook.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDto {

	private String message;
	
	private Object data;
	
	public ResponseDto(Object data, String message)
	{
		this.message = message;
		this.data = data;
	}
}
