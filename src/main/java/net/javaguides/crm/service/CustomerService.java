package net.javaguides.crm.service;

import java.util.List;

import net.javaguides.crm.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer addCustomer(Customer customer);

	Customer getCustomerById(Long id);

	Customer updateCustomer(Customer customer);
	
	void deleteCustomerById (Long id);
}
