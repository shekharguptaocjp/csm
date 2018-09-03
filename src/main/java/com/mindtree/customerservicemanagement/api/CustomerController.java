package com.mindtree.customerservicemanagement.api;

import java.util.HashMap;
import java.util.Map;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.mindtree.customerservicemanagement.FireBaseAuthHelper;
import com.mindtree.customerservicemanagement.model.Customer;
import com.mindtree.customerservicemanagement.service.CustomerService;
import com.mindtree.customerservicemanagment.exception.CustomerNotFoundException;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

	Map<String, String> map = new HashMap<String, String>();	  
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer,@RequestHeader("AUTH-TOKEN") String token) throws CustomerNotFoundException, InterruptedException,CustomerNotFoundException {
		LOGGER.info("Inside addCustomer Controller method");		
		map = getDetailsFromToken(token);		
		if (customer == null){
			throw new CustomerNotFoundException("Please provide all the details ");
		}				
			
		map = getDetailsFromToken(token); 					
		Customer cust = customerService.createCustomer(customer, map.get("email"), map.get("name"));
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);			 
	}	
	

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> updateCustomer(@RequestBody Customer customer,@RequestHeader("AUTH-TOKEN") String token) throws CustomerNotFoundException, InterruptedException {
		
		LOGGER.info("Inside updateCustomer Controller method");		
		if (customer == null) {
			throw new CustomerNotFoundException("Not able to update the details");
		}
		map = getDetailsFromToken(token); 		
        customerService.updateCustomer(customer, map.get("email")); 		
 		return new ResponseEntity<Integer>(HttpStatus.OK);
	}

	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomer(@RequestHeader("AUTH-TOKEN") String token) throws CustomerNotFoundException, InterruptedException {
		LOGGER.info("Inside deleteCustomer Controller method");
		
		map = getDetailsFromToken(token);		
		if (customerService.getIdFromEmail(map.get("email")) == null)	
				throw new CustomerNotFoundException("user registered with this mail id doesn't exist");
		customerService.deleteCustomer(map.get("email"));		
		return new ResponseEntity<String>("Customer is deleted Successfully",HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/customerDetails", method = RequestMethod.GET)
	public ResponseEntity<Customer> getCustomerdetails(
			@RequestHeader("AUTH-TOKEN") String token) throws InterruptedException {
		
		LOGGER.info("Inside getCustomer Controller method");		
		map = getDetailsFromToken(token);		
		return new ResponseEntity<Customer>(customerService.GetDetailsFromEmail(map.get("email")), HttpStatus.OK);
		
	}
	
	Map<String,String> getDetailsFromToken(String token) throws InterruptedException{		
		Map<String,String> map = new HashMap<String,String>();
		
		LOGGER.info("Inside getDetailsFromToken Controller method");	
		return FireBaseAuthHelper.getUserInfo(token);
	}
	
}
