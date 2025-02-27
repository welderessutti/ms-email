package br.com.fiap.ms_email.core.service;

import br.com.fiap.ms_email.core.domain.Patient;
import br.com.fiap.ms_email.core.domain.Scheduling;
import br.com.fiap.ms_email.core.port.in.SchedulingPortIn;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchedulingServiceImpl implements SchedulingPortIn {

    EmailService emailService;

    PatientService patientService;

    public SchedulingServiceImpl(EmailService emailService, PatientService patientService) {
        this.emailService = emailService;
        this.patientService = patientService;
    }

    @Override
    public void getPatientData(Scheduling scheduling) {
        Patient patient = getPatientById(scheduling.getPatientId());
        log.info("Patient API received: {}", patient);
        emailService.composeEmail(patient, scheduling);
    }

    private Patient getPatientById(Long patientId) {
        return patientService.getPatientById(patientId);
    }
}
