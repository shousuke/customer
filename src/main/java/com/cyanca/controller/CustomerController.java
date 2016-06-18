package com.cyanca.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyanca.model.CustomerResource;


@RestController
@RequestMapping(value = "/customers/{customerId}")
public class CustomerController {

	@RequestMapping(method = RequestMethod.GET)
    public CustomerResource add(@PathVariable long customerId) {

		CustomerResource customer = new CustomerResource("Andrew", "Chung");
		customer.add(linkTo(methodOn(CustomerController.class).add(customerId)).withSelfRel());

        return customer;
    }
}
