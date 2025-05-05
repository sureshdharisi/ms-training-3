package com.mphasis.trainings.controller;

import java.util.UUID;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.trainings.commands.CreateProductCommand;
import com.mphasis.trainings.model.Product;

@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private Environment env;
	
	private CommandGateway commandGateway;
	
	@PostMapping
	public String createProduct(@RequestBody Product product) {
		CreateProductCommand createProductCommand=
				CreateProductCommand.builder().title(product.getTitle())
				.price(product.getPrice()).quantity(product.getQuantity())
				.productId(UUID.randomUUID().toString()).build();
		String status = "POST Http Handled :"+product.getTitle();
		try {
			status = commandGateway.sendAndWait(createProductCommand);
		} catch (Exception e) {
			status=e.getLocalizedMessage();
		}
		return status;
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
