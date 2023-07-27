package com.echodesign.caffetteriebomsabor.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CASH_FLOW_ENTRY")
public class CashFlowEntry implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(nullable = false, length = 60)
	private String name;
	@Column(nullable = false)
	private Integer quantity;
	@Column(nullable = false)
	private Double price;
	@Column(nullable = false)
	private Date sellDate;
	
	public CashFlowEntry() {
	}

	public CashFlowEntry(Integer id, String name, Integer quantity, Double price, Date sellDate) {
		this.id = id;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.sellDate = sellDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CashFlowEntry other = (CashFlowEntry) obj;
		return Objects.equals(id, other.id);
	}
}
