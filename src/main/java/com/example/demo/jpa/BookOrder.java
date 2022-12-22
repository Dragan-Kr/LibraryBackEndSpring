package com.example.demo.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the book_order database table.
 * 
 */
@Entity
@Table(name="book_order")
@NamedQuery(name="BookOrder.findAll", query="SELECT b FROM BookOrder b")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
public class BookOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BOOK_ORDER_ID_GENERATOR", sequenceName="BOOK_ORDER_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOOK_ORDER_ID_GENERATOR")
	private Integer id;

	private Integer booknum;

	@Temporal(TemporalType.DATE)
	private Date orderdat;

	private String paymenttype;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookid")
	private Book book;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="employeeid")
	private Employee employee;

	//bi-directional many-to-one association to Publisher
	@ManyToOne
	@JoinColumn(name="publisherid")
	private Publisher publisher;

	public BookOrder() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBooknum() {
		return this.booknum;
	}

	public void setBooknum(Integer booknum) {
		this.booknum = booknum;
	}

	public Date getOrderdat() {
		return this.orderdat;
	}

	public void setOrderdat(Date orderdat) {
		this.orderdat = orderdat;
	}

	public String getPaymenttype() {
		return this.paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Publisher getPublisher() {
		return this.publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

}