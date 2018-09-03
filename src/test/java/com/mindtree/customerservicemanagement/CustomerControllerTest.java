/*package com.mindtree.customerservicemanagement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.web.JsonPath;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.mindtree.customerservicemanagement.api.CustomerController;
import com.mindtree.customerservicemanagement.model.Customer;
import com.mindtree.customerservicemanagement.repository.CustomerRepository;
import com.mindtree.customerservicemanagement.service.CustomerServiceImplemetation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CustomerServiceManagementApplication.class)
@SpringBootTest
public class CustomerControllerTest {

	@Mock
	private CustomerServiceImplemetation csi;

	@InjectMocks
	CustomerController cc;	

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	@Before
	public void setUp() {

		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

	}

	// // @Test
	//
	// @Transactional
	//
	// public void addCustomer() {
	//
	// Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707",
	// "semper.erat.in@sed.edu",
	//
	// "KL", "Ap #106-7980 Luctus Street", "Palakkad", 657261);
	//
	// when(csi.createCustomer(cust)).thenReturn(cust);
	//
	// Customer result = csi.createCustomer(cust);
	//
	// assertEquals(1, result.getCustomer_id());
	//
	// assertEquals("Paul Jacobson", result.getCustomer_name());
	//
	// assertEquals("1-483-920-2707", result.getCustomer_contact_number());
	//
	// assertEquals("semper.erat.in@sed.edu", result.getEmail_id());
	//
	// assertEquals("KL", result.getArea());
	//
	// assertEquals("Ap #106-7980 Luctus Street", result.getAddress1());
	//
	// assertEquals("Palakkad", result.getAddress2());
	//
	// assertEquals(657261, result.getCustomer_pincode());
	//
	//
	//
	// }
	//
	//
	//
	// @Test
	//
	// @Transactional
	//
	// public void deleteCustomer() {
	//
	// Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707",
	// "semper.erat.in@sed.edu",
	//
	// "KL", "Ap #106-7980 Luctus Street", "Palakkad", 657261);
	//
	// csi.deleteCustomer(cust.getCustomer_id());
	//
	// verify(csi, times(1)).deleteCustomer(cust.getCustomer_id());
	//
	// }
	//
	//
	//
	// @Test
	//
	// public void testGetCustomerDetailsNegative() throws Exception {
	//
	//
	//
	// Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707",
	// "semper.erat.in@sed.edu",
	//
	// "KL", "Ap #106-7980 Luctus Street", "Palakkad", 657261);
	//
	// Mockito.doReturn(cust).when(csi).getCustomerDetails(6);
	//
	// mockMvc.perform(get("/customer/100001").accept(MediaType.APPLICATION_JSON))
	//
	// .andExpect(status().isNotFound());
	//
	//
	//
	// }
	//
	//
	//
	// @Test
	//
	// public void testDeleteCustomerDetails() throws Exception {
	//
	//
	//
	// Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707",
	// "semper.erat.in@sed.edu",
	//
	// "KL", "Ap #106-7980 Luctus Street", "Palakkad", 657261);
	//
	// Mockito.doReturn(cust).when(csi).getCustomerDetails(1);
	//
	// mockMvc.perform(get("/customer/1000001").accept(MediaType.APPLICATION_JSON))
	//
	// .andExpect(status().isNotFound());
	//
	// }
	//
	//
	//
	// //@Test
	//
	// public void testGetCustomerDetails() throws Exception {
	//
	//
	//
	// Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707",
	// "semper.erat.in@sed.edu",
	//
	// "KL", "Ap #106-7980 Luctus Street", "Palakkad", 657261);
	//
	// Mockito.doReturn(cust).when(csi).getCustomerDetails(1);
	//
	// mockMvc.perform(get("/customers/1").accept(MediaType.APPLICATION_JSON))
	//
	// .andExpect(status().isOk())
	//
	// .andExpect(
	//
	// content()
	//
	// .json("{\"customer_id\":1,\"customer_name\":\"Paul Jacobson\",\"customer_contact_number\":\"1-483-920-2707\",\"email_id\":\"semper.erat.in@sed.edu\",\"area\":\"KL\",\"address1\":\"Ap #106-7980 Luctus Street\",\"address2\":\"Palakkad\",\"customer_pincode\":657261}"));
	//
	// }
	//
	//
	//
	//

	@Test
	@Transactional
	public void verifyaddEmployee() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders
						.post("/customers/addcustomer")
						.contentType(MediaType.APPLICATION_JSON_VALUE)

						.content(

								"{\"customer_id\":1,\"customer_name\":\"Paul Jacobson\",\"customer_contact_number\":\"1-483-920-2707\",\"email_id\":\"semper.erat.in@sed.edu\",\"area\":\"KL\",\"address1\":\"Ap #106-7980 Luctus Street\",\"address2\":\"Palakkad\",\"customer_pincode\":657261}")

						.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.customer_id").exists())
				.andExpect(jsonPath("$.customer_name").exists())
				.andExpect(jsonPath("$.customer_contact_number").exists())
				.andExpect(jsonPath("$.email_id").exists())
				.andExpect(jsonPath("$.area").exists())
				.andExpect(jsonPath("$.address1").exists())
				.andExpect(jsonPath("$.address2").exists())
				.andExpect(jsonPath("$.customer_pincode").exists())
				.andExpect(jsonPath("$.customer_id").value(1))
				.andExpect(jsonPath("$.customer_name").value("Paul Jacobson"))
				.andExpect(
						jsonPath("$.customer_contact_number").value(
								"1-483-920-2707"))
				.andExpect(
						jsonPath("$.email_id").value("semper.erat.in@sed.edu"))

				.andExpect(jsonPath("$.area").value("KL"))
				.andExpect(
						jsonPath("$.address1").value(
								"Ap #106-7980 Luctus Street"))

				.andExpect(jsonPath("$.address2").value("Palakkad"))
				.andExpect(jsonPath("$.customer_pincode").value("657261"));

	}

	@Test
	public void verifyUpdateEmployee() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders
						.put("/customers/updateCustomer/1")
						.contentType(MediaType.APPLICATION_JSON_VALUE)

						.content(

								"{\"customer_id\":1,\"customer_name\":\"Paul Jacobson\",\"customer_contact_number\":\"1-483-920-2707\",\"email_id\":\"semper.erat.in@sed.edu\",\"area\":\"KL\",\"address1\":\"Ap #106-7980 Luctus Street\",\"address2\":\"Palakkad\",\"customer_pincode\":657261}")

						.accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.customer_id").exists())
				.andExpect(jsonPath("$.customer_name").exists())
				.andExpect(jsonPath("$.customer_contact_number").exists())
				.andExpect(jsonPath("$.email_id").exists())
				.andExpect(jsonPath("$.area").exists())
				.andExpect(jsonPath("$.address1").exists())
				.andExpect(jsonPath("$.address2").exists())
				.andExpect(jsonPath("$.customer_pincode").exists())
				.andExpect(jsonPath("$.customer_id").value(1))
				.andExpect(jsonPath("$.customer_name").value("Paul Jacobson"))
				.andExpect(
						jsonPath("$.customer_contact_number").value(
								"1-483-920-2707"))
				.andExpect(
						jsonPath("$.email_id").value("semper.erat.in@sed.edu"))

				.andExpect(jsonPath("$.area").value("KL"))
				.andExpect(
						jsonPath("$.address1").value(
								"Ap #106-7980 Luctus Street"))

				.andExpect(jsonPath("$.address2").value("Palakkad"))
				.andExpect(jsonPath("$.customer_pincode").value("657261"));

	}

	// @Test
	//
	// public void addCustomers() {
	//
	// Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707",
	//
	// "semper.erat.in@sed.edu", "KL", "Ap #106-7980 Luctus Street",
	//
	// "Palakkad", 657261);
	//
	// csi.getCustomerDetails(cust.getCustomer_id());
	//
	// verify(csi, times(1)).getCustomerDetails(cust.getCustomer_id());
	//
	// }
	//
	//
	//
	// @Test
	//
	// public void updateCustomer() {
	//
	// Customer cust = new Customer(1, "Paul Jacobson", "1-483-920-2707",
	//
	// "semper.erat.in@sed.edu", "KL", "Ap #106-7980 Luctus Street",
	//
	// "Palakkad", 657261);
	//
	// csi.createCustomer(cust);
	//
	// verify(csi, times(1)).createCustomer(cust);
	//
	// }

}*/