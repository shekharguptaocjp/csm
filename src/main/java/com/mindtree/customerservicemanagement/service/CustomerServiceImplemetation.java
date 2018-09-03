package com.mindtree.customerservicemanagement.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.customerservicemanagement.model.Customer;
import com.mindtree.customerservicemanagement.repository.CustomerRepository;


@Service
public class CustomerServiceImplemetation implements CustomerService {

    @Autowired 
    CustomerRepository customerRepository;
	private static final Logger LOGGER = LoggerFactory
			.getLogger(CustomerServiceImplemetation.class);

	/*@Override
	public Customer getCustomerDetails(String  email) {

		LOGGER.info("Inside getCustomerDetails Service method");
        Customer customer = customerRepository.findCustomeremail(email);
		return customer;
		
	}
*/
	@Override
	public Customer createCustomer(Customer customer,String email,String userName) {

		LOGGER.info("Inside createCustomer Service method");
		customer.setEmail_id(email);
		customer.setCustomer_name(userName);
		Customer customerDetails = customerRepository.save(customer);
		return customerDetails;
	}
	
	@Override
	public int updateCustomer(Customer customer,String email) {

		LOGGER.info("Inside updateCustomer Service method");		
		int check = customerRepository.updateCustomerDetails(customer.getCustomer_name(),customer.getCustomer_contact_number()
				,customer.getArea(),customer.getAddress1(),customer.getAddress2(),customer.getCustomer_pincode(), email);
		return check;
	}

	
	@Override
	public void deleteCustomer(String email) {			

		LOGGER.info("Inside deleteCustomer Service method");	
		customerRepository.deleteByMailId(email);
	}

	@Override
	public Customer GetDetailsFromEmail(String email_id) {
        return customerRepository.findCustomeremail(email_id);
	}
	
	@Override
	public Customer getIdFromEmail(String email_id) {
        return customerRepository.getIdFromEmail(email_id);
	}

	@Override
	public String GetDetailsFromEmail1(String email_id) {
		   String customer = customerRepository.findCustomeremail1(email_id);
			return customer;
			
	}

	
	

}
