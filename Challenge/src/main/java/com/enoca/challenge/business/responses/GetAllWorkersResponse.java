package com.enoca.challenge.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllWorkersResponse {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String companyName;
}
