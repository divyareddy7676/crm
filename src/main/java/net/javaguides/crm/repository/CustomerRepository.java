package net.javaguides.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.crm.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
}
