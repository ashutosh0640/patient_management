package com.ashutosh0640.patientService.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
    @NotNull
    @Size(max=100, message="Name can't be empty.")
    private String name;

    @NotNull
    @Email(message="Email is not valid.")
    private String email;

    @NotNull
    @Size(max=200, message="Address can't be empty.")
    private String address;
    
    @NotNull
    private LocalDate dateOfBirth;
//    
//    @NotNull
//    private LocalDate registrationDate;
    
	public PatientRequestDTO() {
		super();
	}
	public PatientRequestDTO(@NotNull String name, @NotNull @Email String email, String address, LocalDate dateOfBirth) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
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

	@Override
	public String toString() {
		return "PatientRequestDTO [name=" + name + ", email=" + email + ", address=" + address + ", dateOfBirth="
				+ dateOfBirth + "]";
	}
    
}
