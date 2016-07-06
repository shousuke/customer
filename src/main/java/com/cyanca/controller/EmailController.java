package com.cyanca.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cyanca.model.CustomerResource;


@RestController
@RequestMapping(value = "/customers/{customerId/emails")
public class EmailController {

	@RequestMapping(method = RequestMethod.POST)
    public CustomerResource add(@PathVariable long customerId) {

		return null;
    }
}
