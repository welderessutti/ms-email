package br.com.fiap.ms_email.core.service;

import br.com.fiap.ms_email.core.domain.EmailPattern;
import br.com.fiap.ms_email.core.domain.Patient;
import br.com.fiap.ms_email.core.domain.Scheduling;
import br.com.fiap.ms_email.core.port.out.EmailPortOut;

public class EmailService {

    private final EmailPortOut emailPortOut;

    public EmailService(EmailPortOut emailPortOut) {
        this.emailPortOut = emailPortOut;
    }

    public void composeEmail(Patient patient, Scheduling scheduling) {
        EmailPattern emailPattern = new EmailPattern();
        emailPattern.setRecipient(patient.getEmail());
        emailPattern.setSubjectAndBody(
                patient.getFullName(),
                scheduling.getSchedulingTime(),
                scheduling.isAppointment()
        );
        emailPortOut.sendEmail(emailPattern);
    }
}
