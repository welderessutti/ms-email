package br.com.fiap.ms_email.core.service;

import br.com.fiap.ms_email.core.domain.Patient;
import br.com.fiap.ms_email.core.port.out.PatientPortOut;

public class PatientService {

    private final PatientPortOut patientPort;

    public PatientService(PatientPortOut patientPort) {
        this.patientPort = patientPort;
    }

    public Patient getPatientById(Long patientId) {
        return patientPort.getPatientById(patientId);
    }
}
