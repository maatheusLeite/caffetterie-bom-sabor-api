package com.echodesign.caffetteriebomsabor.controllers.dtos;

import java.io.Serializable;

import jakarta.persistence.Column;

public class StockEntryDto implements Serializable {
	private static final long serialVersionUID = 1L;
			
	@Column(nullable = false, length = 60)
	private String name;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double price;
	
	public StockEntryDto() {
	}

	public StockEntryDto(String name, Integer quantity, Double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
