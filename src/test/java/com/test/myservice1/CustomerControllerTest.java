package com.test.myservice1;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

class CustomerControllerTest {

	 private CustomerData customerData;
	    private CustomerController controller;

	    @BeforeEach
	    public void setUp() {
	        customerData = mock(CustomerData.class);
	        controller = new CustomerController(customerData);
	    }

	    @Test
	    public void testGetCustomerInfoByIdWithValidData() {
	        
	        String id = "23445322";
	        String idType = "C";
	        Customer customer = new Customer(id, idType, "FirstName", "LastName", "SecondName", "SecondLastName", "PhoneNumber", "Address", "City");
	        when(customerData.getCustomerInfo(id, idType)).thenReturn(customer);

	       
	        ResponseEntity<?> response = controller.getCustomerInfoById(id, idType);

	       
	        assertThat(response.getStatusCode()).isEqualTo(OK);
	        assertThat(response.getBody()).isEqualTo(customer);
	    }

	    @Test
	    public void testGetCustomerInfoByIdWithMissingId() {
	        
	        String id = "";
	        String idType = "C";

	       
	        ResponseEntity<?> response = controller.getCustomerInfoById(id, idType);

	       
	        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
	        assertThat(response.getBody()).isInstanceOf(Map.class);
	    }

	    @Test
	    public void testGetCustomerInfoByIdWithMissingIdType() {
	        
	        String id = "23445322";
	        String idType = "";

	        ResponseEntity<?> response = controller.getCustomerInfoById(id, idType);

	        
	        assertThat(response.getStatusCode()).isEqualTo(BAD_REQUEST);
	        assertThat(response.getBody()).isInstanceOf(Map.class);
	    }

	    @Test
	    public void testGetCustomerInfoByIdWithNonExistingCustomer() {
	        
	        String id = "nonExistingId";
	        String idType = "nonExistingIdType";
	        when(customerData.getCustomerInfo(id, idType)).thenReturn(null);

	        
	        ResponseEntity<?> response = controller.getCustomerInfoById(id, idType);
	        
	        assertThat(response.getStatusCode()).isEqualTo(NOT_FOUND);
	        assertThat(response.getBody()).isNull();
	    }

}
