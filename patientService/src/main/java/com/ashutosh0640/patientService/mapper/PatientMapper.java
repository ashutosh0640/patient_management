package com.ashutosh0640.patientService.mapper;

import com.ashutosh0640.patientService.dto.PatientRequestDTO;
import com.ashutosh0640.patientService.dto.PatientResponseDTO;
import com.ashutosh0640.patientService.entity.Patient;

public class PatientMapper {

	// Convert PatientRequestDTO to Patient Entity
	public static Patient toEntity(PatientRequestDTO dto) {
		Patient patient = new Patient();
		patient.setName(dto.getName());
		patient.setEmail(dto.getEmail());
		patient.setAddress(dto.getAddress());
		patient.setDateOfBirth(dto.getDateOfBirth());
		return patient;
	}

	// Convert Patient Entity to PatientResponseDTO
	public static PatientResponseDTO toDTO(Patient patient) {
		return new PatientResponseDTO(patient.getId(), patient.getName(), patient.getEmail(), patient.getAddress(),
				patient.getDateOfBirth(), patient.getRegistationDate());

	}
}
