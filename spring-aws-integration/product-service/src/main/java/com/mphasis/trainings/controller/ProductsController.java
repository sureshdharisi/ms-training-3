package com.mphasis.trainings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private Environment env;
	
	@PostMapping
	public String createProduct() {
		return "POST Http Handled";
	}

	@PutMapping
	public String updateProduct() {
		return "PUT Http Handled: "+env.getProperty("local.server.port");
	}

	@GetMapping
	public String getProduct() {
		return "GET Http Handled: "+env.getProperty("local.server.port");
	}

	@DeleteMapping
	public String deleteProduct() {
		return "DELETE Http Handled";
	}

	
}
