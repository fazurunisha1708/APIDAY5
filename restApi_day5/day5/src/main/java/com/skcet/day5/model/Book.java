package com.skcet.day5.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "bookDetails")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;
     private String bookName;
     private float prive;
     private int quantity;
     private String authorName;
     
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn
     private Author a;
     
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public float getPrive() {
		return prive;
	}
	public void setPrive(float prive) {
		this.prive = prive;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Book(int id, String bookName, float prive, int quantity, String authorName) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.prive = prive;
		this.quantity = quantity;
		this.authorName = authorName;
	}
	public Book() {
		super();
	}
	public Author getA() {
		return a;
	}
	public void setA(Author a) {
		this.a = a;
	}
     
}
