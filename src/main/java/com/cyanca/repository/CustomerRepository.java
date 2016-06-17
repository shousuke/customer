package com.cyanca.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cyanca.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    
}