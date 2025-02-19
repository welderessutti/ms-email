package br.com.fiap.ms_email.infrastructure.adapter;

import br.com.fiap.ms_email.core.domain.Patient;
import br.com.fiap.ms_email.core.port.out.PatientPortOut;
import br.com.fiap.ms_email.infrastructure.api.PatientApiClient;
import br.com.fiap.ms_email.infrastructure.mapper.PatientDomainDtoMapper;

public class PatientAdapterImpl implements PatientPortOut {

    private final PatientApiClient patientApiClient;

    public PatientAdapterImpl(PatientApiClient patientApiClient) {
        this.patientApiClient = patientApiClient;
    }

    @Override
    public Patient getPatientById(Long patientId) {
        return PatientDomainDtoMapper.toPatient(patientApiClient.getPatientById(patientId));
    }
}
