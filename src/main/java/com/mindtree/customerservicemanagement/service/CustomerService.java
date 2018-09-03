package com.mindtree.customerservicemanagement.service;

import com.mindtree.customerservicemanagement.model.Customer;

public interface CustomerService {

//	Customer getCustomerDetails(String email);

	Customer createCustomer(Customer customer,String email,String userName);	
	
	int updateCustomer(Customer cust,String email);

	void deleteCustomer(String email);
	
	Customer GetDetailsFromEmail(String email_id);
	
	Customer getIdFromEmail(String email);
	
	String GetDetailsFromEmail1(String email_id);


}
