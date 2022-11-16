package com.hadiuz.crud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id
	private int uid;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please enter firstname")
	private String fname;
	
	@Column(length = 30, nullable = false)
	@NotBlank(message = "please enter lastname")
	private String lname;
	
	@Column(length = 30, nullable = false, unique = true)
	@NotBlank(message = "please enter email id")
	@Email
	private String uname;
	
	@Column(length = 11, nullable = false, unique = true)
	@NotNull(message = "please enter phone number")
	private long uphone;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Bookings> bookinglist;
}
