package br.com.fiap.ms_email.infrastructure.mapper;

import br.com.fiap.ms_email.core.domain.Patient;
import br.com.fiap.ms_email.infrastructure.dto.PatientApiResponseDto;

public class PatientDomainDtoMapper {

    public static Patient toPatient(PatientApiResponseDto patientApiResponseDto) {
        Patient patient = new Patient();
        patient.setId(patientApiResponseDto.getId());
        patient.setFullName(patientApiResponseDto.getFullName());
        patient.setEmail(patientApiResponseDto.getEmail());
        return patient;
    }
}
