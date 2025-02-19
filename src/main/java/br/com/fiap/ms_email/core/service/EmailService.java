package br.com.fiap.ms_email.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(SimpleMailMessage message) {
        mailSender.send(message);
        log.info("Email SENT!: {}", message.getSubject());
    }
}
