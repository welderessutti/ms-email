package br.com.fiap.ms_email.core.service;

import br.com.fiap.ms_email.core.domain.Patient;
import br.com.fiap.ms_email.core.domain.Scheduling;
import br.com.fiap.ms_email.core.port.in.SchedulingPortIn;
import org.springframework.mail.SimpleMailMessage;

public class SchedulingServiceImpl implements SchedulingPortIn {

    EmailService emailService;

    PatientService patientService;

    public SchedulingServiceImpl(EmailService emailService, PatientService patientService) {
        this.emailService = emailService;
        this.patientService = patientService;
    }

    @Override
    public void composeEmail(Scheduling scheduling) {
        SimpleMailMessage message = new SimpleMailMessage();
        Patient patient = getPatientById(scheduling.getPatientId());
        message.setTo(patient.getEmail());
        setEmailSubjectAndText(scheduling, message, patient);
        emailService.sendEmail(message);
    }

    private Patient getPatientById(Long patientId) {
        return patientService.getPatientById(patientId);
    }

    private void setEmailSubjectAndText(Scheduling scheduling, SimpleMailMessage message, Patient patient) {
        if (scheduling.isAppointment()) {
            message.setSubject(
                    "Olá "
                            + patient.getFullName() +
                            ", sua consulta foi agendada com sucesso!"
            );
            message.setText(
                    "Olá "
                            + patient.getFullName() +
                            ", sua consulta foi agendada para "
                            + scheduling.getSchedulingTime() +
                            "."
            );
        } else {
            message.setSubject(
                    "Olá "
                            + patient.getFullName() +
                            ", seu exame foi agendado com sucesso!"
            );
            message.setText(
                    "Olá "
                            + patient.getFullName() +
                            ", seu exame foi agendado para "
                            + scheduling.getSchedulingTime() +
                            "."
            );
        }
    }
}
