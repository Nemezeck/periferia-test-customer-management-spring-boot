package com.test.myservice1;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	
	private final CustomerData customerData;
	public CustomerController(CustomerData _customerData)
	{
		customerData= _customerData;
	}
	
	@GetMapping("/customer")
	public ResponseEntity<?> getCustomerInfoById(@RequestParam(name = "id") String id, 
			@RequestParam(name = "idtype") String idType) {
		try {

			
			if (id.trim().isEmpty() || id == null || idType.trim().isEmpty() || idType == null) 
				return new ResponseEntity<Object>(ErrorContent(HttpStatus.BAD_REQUEST ), HttpStatus.BAD_REQUEST );
			
			
			Customer customer = customerData.getCustomerInfo(id,idType);
			
			if (customer != null)
				return new ResponseEntity<>(customer, HttpStatus.OK);
			
			
			return new ResponseEntity<>(ErrorContent(HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND );
		}
		catch(Exception ex) {
			LinkedHashMap<String, Object> errorContent = ErrorContent(HttpStatus.INTERNAL_SERVER_ERROR);
			errorContent.put("error", "Internal Server Error: " + ex.getMessage());
			return new ResponseEntity<>(errorContent, HttpStatus.INTERNAL_SERVER_ERROR );
		}
		
	
	}
	
	private LinkedHashMap<String, Object> ErrorContent(HttpStatus httpStatus) {
		
		LinkedHashMap<String, Object> errorResponse = new LinkedHashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now().toString());
		errorResponse.put("path", "/customer"); 
		switch (httpStatus){
			case NOT_FOUND:
				errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		        errorResponse.put("error", "Not Found");
				break;
			case BAD_REQUEST:
				errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		        errorResponse.put("error", "Bad Request");
		        errorResponse.put("path", "/customer");
		        break;
			default:
				errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		        errorResponse.put("path", "/customer");
		        
		}
		
		return errorResponse;
		
	}
}
