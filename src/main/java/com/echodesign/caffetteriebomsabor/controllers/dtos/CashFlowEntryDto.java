package com.echodesign.caffetteriebomsabor.controllers.dtos;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;

public class CashFlowEntryDto implements Serializable {
	private static final long serialVersionUID = 1L;
			
	@Column(nullable = false, length = 60)
	private String name;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private Date sellDate;
	
	public CashFlowEntryDto() {
	}

	public CashFlowEntryDto(String name, Integer quantity, Double price) {
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

	public Date getSellDate() {
		return sellDate;
	}

	public void setSellDate(Date sellDate) {
		this.sellDate = sellDate;
	}
}
