package com.ashutosh0640.patientService.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashutosh0640.patientService.dto.ApiResponseDTO;
import com.ashutosh0640.patientService.dto.PatientRequestDTO;
import com.ashutosh0640.patientService.dto.PatientResponseDTO;
import com.ashutosh0640.patientService.exception.InvalidArgumentException;
import com.ashutosh0640.patientService.exception.ResourceNotFoundException;
import com.ashutosh0640.patientService.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

	private PatientService patientService;

	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}

	@GetMapping
	public ResponseEntity<ApiResponseDTO<List<PatientResponseDTO>>> findAll() {
		try {
			List<PatientResponseDTO> patients = patientService.findAll();

			if (patients.isEmpty()) {
//	                log.warn("No patients found");
				return ResponseEntity.status(HttpStatus.NO_CONTENT)
						.body(new ApiResponseDTO<>(true, "No patients available", patients));
			}

//	            log.info("Fetched {} patients", patients.size());
			return ResponseEntity.ok(new ApiResponseDTO<>(true, "Patients fetched successfully", patients));

		} catch (Exception ex) {
//	            log.error("Error occurred while fetching patients", ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(new ApiResponseDTO<>(false, "Failed to fetch patients", null));
		}
	}
	

	@GetMapping("/id")
	public ResponseEntity<ApiResponseDTO<PatientResponseDTO>> findById(@RequestParam UUID id) {
		try {
			if (id == null) throw new InvalidArgumentException("Id can not be null.");
			
			PatientResponseDTO patient = patientService.findById(id);
			
			return new ResponseEntity<>(new ApiResponseDTO<>(true, "Patient found successfully.", patient), HttpStatus.OK);
			 
		} catch (ResourceNotFoundException ex) {
			
			throw new ResourceNotFoundException("Patient not found by id: "+ id);
			
		} catch (Exception ex) {
			
			throw new RuntimeException(ex.getMessage());
			
		}
		
	}

	@PostMapping
	public ResponseEntity<PatientResponseDTO> savePatient(@Valid @RequestBody PatientRequestDTO patientDto) {
		PatientResponseDTO savedPatient = patientService.savePatient(patientDto);
		return ResponseEntity.ok().body(savedPatient);
	}

	@PostMapping("/all")
	public void saveAll(@RequestBody List<PatientRequestDTO> patients) {
		patientService.saveAll(patients);
	}

	@DeleteMapping
	public void deleteById(@RequestParam UUID id) {
		patientService.deleteById(id);
	}

	@PutMapping
	public ResponseEntity<PatientResponseDTO> updatePatient(@Valid @RequestBody PatientRequestDTO patient,
			@RequestParam UUID id) {
		PatientResponseDTO pDto = patientService.updatePatient(patient, id);
		return ResponseEntity.ok().body(pDto);
	}

}
