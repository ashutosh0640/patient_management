package com.ashutosh0640.patientService.dto;

import java.time.LocalDate;
import java.util.UUID;

public class PatientResponseDTO {
	
    private UUID id;
    private String name;
    private String email;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate registrationDate;
	public PatientResponseDTO() {
		super();
	}
	public PatientResponseDTO(UUID id, String name, String email, String address, LocalDate dateOfBirth,
			LocalDate registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.registrationDate = registrationDate;
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
	public LocalDate getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public String toString() {
		return "PatientResponseDTO [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", dateOfBirth=" + dateOfBirth + ", registrationDate=" + registrationDate + "]";
	}

}
