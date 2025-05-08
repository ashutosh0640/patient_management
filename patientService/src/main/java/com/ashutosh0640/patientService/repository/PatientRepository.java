package com.ashutosh0640.patientService.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashutosh0640.patientService.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    boolean existsByEmail(String email);
    boolean existsById(UUID id);

}

