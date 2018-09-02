package com.algalopez.happyday.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

/**
 * Provides ORM to quotes table
 */
@Entity
@Table(name = "quotes", uniqueConstraints = @UniqueConstraint(columnNames = { "quote" }))
public class QuoteEntity implements Serializable {

	private static final long serialVersionUID = -2864774505649351371L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false, length = 11)
	private Long id;
	
	@Column(name = "quote", unique = true, nullable = false, length = 600)
	private String quote;
	
	public QuoteEntity() { }
	
	public QuoteEntity(String quote) {
		this.quote = quote;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	@Override
	public String toString() {
		return "QuoteEntity [id=" + id + ", quote=" + quote + "]";
	}
	

}
