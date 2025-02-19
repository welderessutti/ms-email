package br.com.fiap.ms_email.core.port.out;

import br.com.fiap.ms_email.core.domain.Patient;

public interface PatientPortOut {

    Patient getPatientById(Long id);
}
