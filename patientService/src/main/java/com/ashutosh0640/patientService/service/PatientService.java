package com.ashutosh0640.patientService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ashutosh0640.patientService.dto.PatientRequestDTO;
import com.ashutosh0640.patientService.dto.PatientResponseDTO;
import com.ashutosh0640.patientService.entity.Patient;
import com.ashutosh0640.patientService.exception.InvalidArgumentException;
import com.ashutosh0640.patientService.mapper.PatientMapper;
import com.ashutosh0640.patientService.repository.PatientRepository;

@Service
public class PatientService {
	
	private PatientRepository patientRepository;
	 private static final int BATCH_SIZE = 1000;

	public PatientService(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}
	
	public List<PatientResponseDTO> findAll() {
		List<Patient> patients = patientRepository.findAll();
		return patients.stream().map( PatientMapper :: toDTO ).toList();
	}
	
	public PatientResponseDTO findById(UUID id) {
		Patient patient = patientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Patient not found by id: "+id));
		return PatientMapper.toDTO(patient);
	}
	
	public PatientResponseDTO savePatient(PatientRequestDTO patientDto) {
		try {
			boolean flag = patientRepository.existsByEmail(patientDto.getEmail());
			System.out.println("flag: "+flag);
			if (flag) {
				throw new InvalidArgumentException("Email already exists by: "+patientDto.getEmail());
			} else {
				Patient savedPatient = patientRepository.save(PatientMapper.toEntity(patientDto));
				return PatientMapper.toDTO(savedPatient);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	
	
	public void saveAll(List<PatientRequestDTO> patients) {
		for (int i = 0; i < patients.size(); i += BATCH_SIZE) {
            int end = Math.min(i + BATCH_SIZE, patients.size());
            List<PatientRequestDTO> batch = patients.subList(i, end);
            List<Patient> p = batch.stream().map(PatientMapper::toEntity).toList();
            patientRepository.saveAll(p);
            patientRepository.flush();
        }
	}
	
	public void deleteById(UUID id) {
		patientRepository.deleteById(id);
	}
	
	public PatientResponseDTO updatePatient(PatientRequestDTO patient, UUID id) {
		Patient p = patientRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Patient not found by id: "+id));
		
		p.setName(patient.getName());
		p.setEmail(patient.getEmail());
		p.setAddress(patient.getAddress());
		p.setDateOfBirth(patient.getDateOfBirth());
		
		Patient savedPatient = patientRepository.save(p);
		return PatientMapper.toDTO(savedPatient);
	}

}
