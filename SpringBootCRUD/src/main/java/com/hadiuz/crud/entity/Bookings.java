package com.hadiuz.crud.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Data
@Table(name="booking_details")
@Entity
public class Bookings {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "Movie name cannot be blank")
	private String movieName;

	@Column(length = 10, nullable = false)
	@NotBlank(message = "Movie date cannot be blank")
	private String movieDate;
	
	@Column(length = 3, nullable = false)
	@NotNull(message = "Movie time cannot be blank")
	private int movieTime;
	
	@Column(length = 5, nullable = false)
	@NotNull(message = " cannot be blank")
	private int noOfPerson;
	
	@Column(length = 10, nullable = false)
	@NotNull(message = "Price cannot be blank")
	private double price;
	
	@Column(length = 10, nullable = false)
	@NotNull(message = "Price cannot be blank")
	private double totalPrice = noOfPerson * price;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="customerid", referencedColumnName = "uid")
	@JsonBackReference
	private Customer customer;
}
