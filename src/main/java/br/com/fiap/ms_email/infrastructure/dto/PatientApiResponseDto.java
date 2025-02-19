package br.com.fiap.ms_email.infrastructure.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientApiResponseDto {

    private Long id;
    private String fullName;
    private String email;
}
