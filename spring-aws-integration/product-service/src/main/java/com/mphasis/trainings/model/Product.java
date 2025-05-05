package com.mphasis.trainings.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class Product {
	
	private String title;
	
	private BigDecimal price;
	
	private Integer quantity;

}
