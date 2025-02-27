package br.com.fiap.ms_email.infrastructure.mapper;

import br.com.fiap.ms_email.core.domain.EmailPattern;
import org.springframework.mail.SimpleMailMessage;

public class EmailPatternDomainSimpleMailMessageMapper {

    private EmailPatternDomainSimpleMailMessageMapper() {
    }

    public static SimpleMailMessage toSimpleMailMessage(EmailPattern emailPattern) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(emailPattern.getRecipient());
        simpleMailMessage.setSubject(emailPattern.getSubject());
        simpleMailMessage.setText(emailPattern.getBody());
        return simpleMailMessage;
    }
}
