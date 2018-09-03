/*package com.mindtree.customerservicemanagement;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.customerservicemanagement.model.Customer;
import com.mindtree.customerservicemanagement.repository.CustomerRepository;
import com.mindtree.customerservicemanagement.service.CustomerServiceImplemetation;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceTest {

	@Mock
	private CustomerRepository custrepo;

	@InjectMocks
	private CustomerServiceImplemetation csi;

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
//
//	@Test
//	public void addCustomer() {
//		Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707", "semper.erat.in@sed.edu",
//				"KL", "Ap #106-7980 Luctus Street", "Palakkad", 657261);
//		when(custrepo.save(cust)).thenReturn(cust);
//		Customer result = csi.createCustomer(cust);
//		assertEquals(1, result.getCustomer_id());
//		assertEquals("Paul Jacobson", result.getCustomer_name());
//		assertEquals("1-483-920-2707", result.getCustomer_contact_number());
//		assertEquals("semper.erat.in@sed.edu", result.getEmail_id());
//		assertEquals("KL", result.getArea());
//		assertEquals("Ap #106-7980 Luctus Street", result.getAddress1());
//		assertEquals("Palakkad", result.getAddress2());
//		assertEquals(657261, result.getCustomer_pincode());
//
//	}
//	
//	
//	@Test
//	@Transactional
//	public void deleteCustomer() {
//		Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707", "semper.erat.in@sed.edu",
//				"KL", "Ap #106-7980 Luctus Street", "Palakkad", 657261);
//		csi.deleteCustomer(cust.getCustomer_id());
//		verify(custrepo, times(1)).deleteById(cust.getCustomer_id());
//	}
	
	

}*/