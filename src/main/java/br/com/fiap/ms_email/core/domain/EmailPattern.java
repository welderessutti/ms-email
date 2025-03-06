package br.com.fiap.ms_email.core.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class EmailPattern {

    private String recipient;
    private String subject;
    private String body;

    public EmailPattern() {
    }

    public EmailPattern(String recipient, String subject, String body) {
        this.recipient = recipient;
        this.subject = subject;
        this.body = body;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setSubjectAndBody(String patientFullName, LocalDateTime schedulingTime, boolean isAppointment) {
        String date = schedulingTime.toLocalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String time = schedulingTime.toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm"));
        if (isAppointment) {
            this.setSubject(
                    "Olá "
                            + patientFullName +
                            ", sua consulta foi agendada com sucesso!"
            );
            this.setBody(
                    "Olá "
                            + patientFullName +
                            ", sua consulta foi agendada para o dia "
                            + date +
                            " às "
                            + time +
                            "."
            );
        } else {
            this.setSubject(
                    "Olá "
                            + patientFullName +
                            ", seu exame foi agendado com sucesso!"
            );
            this.setBody(
                    "Olá "
                            + patientFullName +
                            ", seu exame foi agendado para o dia "
                            + date +
                            " às "
                            + time +
                            "."
            );
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailPattern that = (EmailPattern) o;
        return Objects.equals(recipient, that.recipient)
                && Objects.equals(subject, that.subject)
                && Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, subject, body);
    }

    @Override
    public String toString() {
        return "EmailPattern{" +
                "recipient='" + recipient + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
