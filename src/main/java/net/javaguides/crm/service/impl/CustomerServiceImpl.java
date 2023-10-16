package net.javaguides.crm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.crm.entity.Customer;
import net.javaguides.crm.repository.CustomerRepository;
import net.javaguides.crm.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	private CustomerRepository customerRepository;

	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}


	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}


	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public Customer getCustomerById(Long id) {
		return customerRepository.findById(id).get();
	}


	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}


	@Override
	public void deleteCustomerById(Long id) {
		customerRepository.deleteById(id);
	}


}
