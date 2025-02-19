package br.com.fiap.ms_email.framework.config;

import br.com.fiap.ms_email.core.port.in.SchedulingPortIn;
import br.com.fiap.ms_email.core.port.out.PatientPortOut;
import br.com.fiap.ms_email.core.service.EmailService;
import br.com.fiap.ms_email.core.service.PatientService;
import br.com.fiap.ms_email.core.service.SchedulingServiceImpl;
import br.com.fiap.ms_email.infrastructure.adapter.PatientAdapterImpl;
import br.com.fiap.ms_email.infrastructure.api.PatientApiClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class AppConfig {

    @Bean
    public SchedulingPortIn schedulingServiceImpl(EmailService emailService, PatientService patientService) {
        return new SchedulingServiceImpl(emailService, patientService);
    }

    @Bean
    public EmailService emailServiceImpl(JavaMailSender javaMailSender) {
        return new EmailService(javaMailSender);
    }

    @Bean
    public PatientService patientServiceImpl(PatientPortOut patientPortOut) {
        return new PatientService(patientPortOut);
    }

    @Bean
    public PatientPortOut patientAdapterImpl(PatientApiClient patientApiClient) {
        return new PatientAdapterImpl(patientApiClient);
    }
}
