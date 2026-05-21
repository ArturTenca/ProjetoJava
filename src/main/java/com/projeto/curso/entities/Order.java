package com.projeto.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import com.projeto.curso.entities.enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb-order")
public class Order implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant date;
	
	@ManyToOne
	@JoinColumn(name = "clientId")
	private User client;
	
	private Integer orderStatus;
	
	public Order () {
		
	}

	public Order(Long id, Instant date, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.date = date;
		this.client = client;
		setOrderStatus(orderStatus);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getDate() {
		return date;
	}

	public void setDate(Instant date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus) ;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + "]";
	}

}
