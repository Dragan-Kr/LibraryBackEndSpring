package com.example.demo.jpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import javax.persistence.ManyToOne;


/**
 * The persistent class for the rent database table.
 * 
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@NamedQuery(name="Rent.findAll", query="SELECT r FROM Rent r")
public class Rent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RENT_ID_GENERATOR", sequenceName="RENT_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RENT_ID_GENERATOR")
	private Integer id;

	@Temporal(TemporalType.DATE)
	private Date rentdate;

	@Temporal(TemporalType.DATE)
	private Date returndate;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookid")
	private Book book;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="empid")
	private Employee employee;

	//bi-directional many-to-one association to MembershipCard
	@ManyToOne
	@JoinColumn(name="memcardid")
	private MembershipCard membershipCard;

	public Rent() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRentdate() {
		return this.rentdate;
	}

	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}

	public Date getReturndate() {
		return this.returndate;
	}

	public void setReturndate(Date returndate) {
		this.returndate = returndate;
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

	public MembershipCard getMembershipCard() {
		return this.membershipCard;
	}

	public void setMembershipCard(MembershipCard membershipCard) {
		this.membershipCard = membershipCard;
	}

}
