package com.cyanca.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cyanca.form.customer.CustomerAddReq;
import com.cyanca.model.CustomerResource;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {
	
	@RequestMapping(method = RequestMethod.GET)
    public CustomerResource list() {
		return null;
    }

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
    public CustomerResource add(@RequestBody CustomerAddReq req) {

		CustomerResource customer = getCustomerResource(req);
		customer.add(linkTo(methodOn(CustomerController.class).add(req)).withSelfRel());
		
        return customer;
    }
	
	private CustomerResource getCustomerResource(CustomerAddReq req) {
		return null;
	}
	
	@RequestMapping(value = "{customerId}", method = RequestMethod.PUT)
    public CustomerResource edit(@PathVariable long customerId) {

		CustomerResource customer = new CustomerResource("Andrew", "Chung");
		customer.add(linkTo(methodOn(CustomerController.class).edit(customerId)).withSelfRel());

        return customer;
    }
	
	@RequestMapping(value = "{customerId}", method = RequestMethod.GET)
    public CustomerResource show() {
		return null;
    }
	
	@RequestMapping(value = "{customerId}", method = RequestMethod.DELETE)
    public CustomerResource delete() {
		return null;
    }
}
