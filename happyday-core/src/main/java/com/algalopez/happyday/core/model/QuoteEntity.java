package com.algalopez.happyday.core.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

@Entity
@Table(name = "quotes")
public class QuoteEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2864774505649351371L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "quote", nullable = false)
	private String quote;
	
	public QuoteEntity() {
		
	}
	
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
