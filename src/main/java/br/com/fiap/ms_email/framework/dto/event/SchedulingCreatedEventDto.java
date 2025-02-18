package br.com.fiap.ms_email.framework.dto.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingCreatedEventDto {

    private Long id;
    private Long patientId;
    private LocalDateTime schedulingTime;
}
