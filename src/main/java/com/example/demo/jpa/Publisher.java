package com.example.demo.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.OneToMany;


/**
 * The persistent class for the publisher database table.
 * 
 */
@Entity
@NamedQuery(name="Publisher.findAll", query="SELECT p FROM Publisher p")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })

public class Publisher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PUBLISHER_ID_GENERATOR", sequenceName="PUBLISHER_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PUBLISHER_ID_GENERATOR")
	private Integer id;

	private String address;


	private Integer contact;

	private String name;

	//bi-directional many-to-one association to BookOrder
	@JsonIgnore
	@OneToMany(mappedBy="publisher")
	private List<BookOrder> bookOrders;

	public Publisher() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getContact() {
		return this.contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BookOrder> getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(List<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}

	public BookOrder addBookOrder(BookOrder bookOrder) {
		getBookOrders().add(bookOrder);
		bookOrder.setPublisher(this);

		return bookOrder;
	}

	public BookOrder removeBookOrder(BookOrder bookOrder) {
		getBookOrders().remove(bookOrder);
		bookOrder.setPublisher(null);

		return bookOrder;
	}

}
