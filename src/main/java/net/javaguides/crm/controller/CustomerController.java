package net.javaguides.crm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import net.javaguides.crm.entity.Customer;
import net.javaguides.crm.service.CustomerService;

@Controller
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@GetMapping("/customers")
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers";
	}

	@GetMapping("/customers/add")
	public String addCustomersForm(Model model) {

		// create student object to hold student form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add_customer";

	}

	@PostMapping("/customers")
	public String addCustomer(@ModelAttribute("customer") Customer customer, RedirectAttributes redirectAttributes) {
		customerService.addCustomer(customer);
		redirectAttributes.addFlashAttribute("message", "Customer Succesfully added!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/customers";
	}

	@GetMapping("/customers/update/{id}")
	public String updateCustomerForm(@PathVariable long id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "update_customer";
	}

	@PostMapping("customers/{id}")
	public String updateCustomer(@PathVariable long id, @ModelAttribute("customer") Customer customer, Model model, RedirectAttributes redirectAttributes) {
		Customer existingCustomer = customerService.getCustomerById(id);
		existingCustomer.setId(id);
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setMobileNumber(customer.getMobileNumber());
		customerService.updateCustomer(existingCustomer);
		redirectAttributes.addFlashAttribute("message", "Customer Succesfully updated!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/customers";	
	}
	
	@GetMapping("/customers/delete/{id}")
	public String deleteCustomer(@PathVariable long id, RedirectAttributes redirectAttributes) {
		customerService.deleteCustomerById(id);
		redirectAttributes.addFlashAttribute("message", "Customer Succesfully deleted!");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/customers";
	}
	

}
