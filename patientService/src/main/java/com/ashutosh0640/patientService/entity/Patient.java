package com.ashutosh0640.patientService.entity;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private UUID id;
	
	@NotBlank
	@Column(nullable=false)
	private String name;
	
	@NotBlank(message = "Email is required.")
	@Email(message = "Invalid email format.")
	@Column(unique = true, nullable = false)
	private String email;

	
	@NotBlank
	@Column(nullable=false)
	private String address;
	
	@NotNull
	@Column(nullable=false)
	private LocalDate dateOfBirth;
	

	@Column(nullable=false, updatable=false)
	@CreationTimestamp
	private LocalDate registationDate;
	

	public Patient() {
		super();
	}

	public Patient(UUID id, @NotNull String name, @NotNull @Email String email, String address, LocalDate dateOfBirth,
			LocalDate registationDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.registationDate = registationDate;
	}



	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}



	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}



	public LocalDate getRegistationDate() {
		return registationDate;
	}



	public void setRegistationDate(LocalDate registationDate) {
		this.registationDate = registationDate;
	}



	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", dateOfBirth="
				+ dateOfBirth + ", registationDate=" + registationDate + "]";
	}
	
	
	
	

}
