package br.com.fiap.ms_email.infrastructure.api;

import br.com.fiap.ms_email.infrastructure.dto.PatientApiResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "patientApiClient", url = "http://localhost:8080/api/patient")
public interface PatientApiClient {

    @GetMapping("/{patientId}")
    PatientApiResponseDto getPatientById(@PathVariable Long patientId);
}
