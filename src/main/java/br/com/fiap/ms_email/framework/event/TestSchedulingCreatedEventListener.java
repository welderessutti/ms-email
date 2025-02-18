package br.com.fiap.ms_email.framework.event;

import br.com.fiap.ms_email.core.port.in.EmailPortIn;
import br.com.fiap.ms_email.framework.dto.event.SchedulingCreatedEventDto;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class TestSchedulingCreatedEventListener implements Consumer<SchedulingCreatedEventDto> {

    private final EmailPortIn emailPortIn;

    public TestSchedulingCreatedEventListener(EmailPortIn emailPortIn) {
        this.emailPortIn = emailPortIn;
    }

    @Override
    public void accept(SchedulingCreatedEventDto schedulingCreatedEventDto) {

    }
}
