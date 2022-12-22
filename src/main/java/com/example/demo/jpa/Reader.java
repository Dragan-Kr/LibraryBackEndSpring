package com.example.demo.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.OneToMany;


/**
 * The persistent class for the reader database table.
 * 
 */
@Entity
@NamedQuery(name="Reader.findAll", query="SELECT r FROM Reader r")
public class Reader implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="READER_ID_GENERATOR", sequenceName="READER_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="READER_ID_GENERATOR")
	private Integer id;

	private String address;

	private BigDecimal contact;

	private BigDecimal jmbg;

	private String name;

	private String surname;

	//bi-directional many-to-one association to MembershipCard
	@JsonIgnore
	@OneToMany(mappedBy="reader")
	private List<MembershipCard> membershipCards;

	public Reader() {
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

	public BigDecimal getJmbg() {
		return this.jmbg;
	}

	public void setJmbg(BigDecimal jmbg) {
		this.jmbg = jmbg;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<MembershipCard> getMembershipCards() {
		return this.membershipCards;
	}

	public void setMembershipCards(List<MembershipCard> membershipCards) {
		this.membershipCards = membershipCards;
	}

	public MembershipCard addMembershipCard(MembershipCard membershipCard) {
		getMembershipCards().add(membershipCard);
		membershipCard.setReader(this);

		return membershipCard;
	}

	public MembershipCard removeMembershipCard(MembershipCard membershipCard) {
		getMembershipCards().remove(membershipCard);
		membershipCard.setReader(null);

		return membershipCard;
	}

}
