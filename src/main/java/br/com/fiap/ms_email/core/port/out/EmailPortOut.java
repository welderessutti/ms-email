package br.com.fiap.ms_email.core.port.out;

import br.com.fiap.ms_email.core.domain.EmailPattern;

public interface EmailPortOut {

    void sendEmail(EmailPattern email);
}
