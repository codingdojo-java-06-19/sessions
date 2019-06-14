package com.codingdojo.books.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=2, max=20)
	private String title;
	
	@Min(0)
	private Integer pages;
	private String publisher;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author_id")
	private Author author;
	
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	public Book() {}

	public Author getAuthor() {
		return author;
	}
	
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	@PrePersist
	protected void onCreate() {
		createdAt = new Date();
	}
	
	@PostPersist
	protected void onUpdate() {
		updatedAt = new Date();
	}
	
}
