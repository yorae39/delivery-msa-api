package com.example.delivery.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/*
 	Entidade que representará o pedido, irei utilizar 
 	as anotações @NotEmpty e @NotNull na classe OrderService 
 	para validar as propriedades do pedido.
 */
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "`order`")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty(message = "Product required")
	private String product;

	@NotNull(message = "Price required")
	private Double price;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
