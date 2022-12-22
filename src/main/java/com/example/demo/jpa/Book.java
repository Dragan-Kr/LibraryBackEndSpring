package com.example.demo.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BOOK_ID_GENERATOR", sequenceName="BOOK_SEQ",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOOK_ID_GENERATOR")
	private Integer id;

	private String name;

	//bi-directional many-to-one association to Author
	@ManyToOne
	@JoinColumn(name="authorid")
	private Author author;

	//bi-directional many-to-one association to Genre
	@ManyToOne
	@JoinColumn(name="book_type_id")
	private Genre genre;

	//bi-directional many-to-one association to BookOrder
	@JsonIgnore
	@OneToMany(mappedBy="book")
	private List<BookOrder> bookOrders;

	//bi-directional many-to-one association to Rent
	@JsonIgnore
	@OneToMany(mappedBy="book")
	private List<Rent> rents;

	public Book() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Genre getGenre() {
		return this.genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<BookOrder> getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(List<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}

	public BookOrder addBookOrder(BookOrder bookOrder) {
		getBookOrders().add(bookOrder);
		bookOrder.setBook(this);

		return bookOrder;
	}

	public BookOrder removeBookOrder(BookOrder bookOrder) {
		getBookOrders().remove(bookOrder);
		bookOrder.setBook(null);

		return bookOrder;
	}

	public List<Rent> getRents() {
		return this.rents;
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

	public Rent addRent(Rent rent) {
		getRents().add(rent);
		rent.setBook(this);

		return rent;
	}

	public Rent removeRent(Rent rent) {
		getRents().remove(rent);
		rent.setBook(null);

		return rent;
	}

}