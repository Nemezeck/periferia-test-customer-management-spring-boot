package com.test.myservice1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerData {
	private List<Customer> customers;
	public CustomerData()
	{
		customers = new ArrayList<Customer>();
		customers.add(new Customer("C","23445322","Nombre1","Nombre2","Apellido1","Apellido2", "3006005967", "Calle 85", "Bogota" ));
	}
	public Customer getCustomerInfo(String id, String idType){
		Customer customer = customers.stream()
				.filter((Customer e) -> e.getIdType().equals(idType) && e.getIdNumber().equals(id))
				.findFirst()
				.orElse(null);
	
		return customer;
	}
	
}
