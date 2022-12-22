package com.example.demo.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.OneToMany;


/**
 * The persistent class for the employee database table.
 * 
 */

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLOYEE_ID_GENERATOR", sequenceName="EMPLOYEE_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLOYEE_ID_GENERATOR")
	private Integer id;

	private String address;

	private BigDecimal contact;

	private BigDecimal jbmg;

	private String name;

	private String password;

	private String surname;

	private String username;

	private String verificationCode;


	private boolean enabled;


	private String email;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



//
//	public String getRole() {
//		return role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

	//bi-directional many-to-one association to BookOrder
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<BookOrder> bookOrders;

	//bi-directional many-to-one association to MembershipCard
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<MembershipCard> membershipCards;

	//bi-directional many-to-one association to Payment
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<Payment> payments;

	//bi-directional many-to-one association to Rent
	@JsonIgnore
	@OneToMany(mappedBy="employee")
	private List<Rent> rents;

	public Employee() {
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

	public BigDecimal getContact() {
		return this.contact;
	}

	public void setContact(BigDecimal contact) {
		this.contact = contact;
	}

	public BigDecimal getJbmg() {
		return this.jbmg;
	}

	public void setJbmg(BigDecimal jbmg) {
		this.jbmg = jbmg;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<BookOrder> getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(List<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}



	public BookOrder addBookOrder(BookOrder bookOrder) {
		getBookOrders().add(bookOrder);
		bookOrder.setEmployee(this);

		return bookOrder;
	}

	public BookOrder removeBookOrder(BookOrder bookOrder) {
		getBookOrders().remove(bookOrder);
		bookOrder.setEmployee(null);

		return bookOrder;
	}

	public List<MembershipCard> getMembershipCards() {
		return this.membershipCards;
	}

	public void setMembershipCards(List<MembershipCard> membershipCards) {
		this.membershipCards = membershipCards;
	}

	public MembershipCard addMembershipCard(MembershipCard membershipCard) {
		getMembershipCards().add(membershipCard);
		membershipCard.setEmployee(this);

		return membershipCard;
	}

	public MembershipCard removeMembershipCard(MembershipCard membershipCard) {
		getMembershipCards().remove(membershipCard);
		membershipCard.setEmployee(null);

		return membershipCard;
	}

	public List<Payment> getPayments() {
		return this.payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	public Payment addPayment(Payment payment) {
		getPayments().add(payment);
		payment.setEmployee(this);

		return payment;
	}

	public Payment removePayment(Payment payment) {
		getPayments().remove(payment);
		payment.setEmployee(null);

		return payment;
	}

	public List<Rent> getRents() {
		return this.rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public Rent addRent(Rent rent) {
		getRents().add(rent);
		rent.setEmployee(this);

		return rent;
	}

	public Rent removeRent(Rent rent) {
		getRents().remove(rent);
		rent.setEmployee(null);

		return rent;
	}


	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "UsersRole",
			joinColumns = @JoinColumn(name = "user_id"),
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private Set<Role> roles = new HashSet<>();

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}


	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
}