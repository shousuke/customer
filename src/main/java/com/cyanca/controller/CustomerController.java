package com.cyanca.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyanca.model.Customer;


@RestController
@RequestMapping(value = "/customers/{customerId}")
public class CustomerController {

	@RequestMapping(method = RequestMethod.GET)
    public Customer show(@PathVariable String customerId) {

		Customer customer = new Customer("Andrew", "Chung");
		customer.add(linkTo(methodOn(CustomerController.class).show(customerId)).withSelfRel());

        return customer;
    }
}
