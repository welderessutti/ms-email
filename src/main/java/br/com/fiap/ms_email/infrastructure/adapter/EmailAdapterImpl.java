package br.com.fiap.ms_email.infrastructure.adapter;

import br.com.fiap.ms_email.core.domain.EmailPattern;
import br.com.fiap.ms_email.core.port.out.EmailPortOut;
import br.com.fiap.ms_email.infrastructure.mapper.EmailPatternDomainSimpleMailMessageMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Slf4j
public class EmailAdapterImpl implements EmailPortOut {

    private final JavaMailSender mailSender;

    public EmailAdapterImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public void sendEmail(EmailPattern email) {
        SimpleMailMessage message = EmailPatternDomainSimpleMailMessageMapper.toSimpleMailMessage(email);
        mailSender.send(message);
        log.info("Email SENT!: {}", message.getSubject());
    }
}
