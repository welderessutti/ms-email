package br.com.fiap.ms_email.framework.event;

import br.com.fiap.ms_email.core.port.in.EmailPortIn;
import br.com.fiap.ms_email.framework.dto.event.SchedulingCreatedEventDto;

import java.util.function.Consumer;

public class AppointmentSchedulingCreatedEventListener implements Consumer<SchedulingCreatedEventDto> {

    private final EmailPortIn emailPortIn;

    public AppointmentSchedulingCreatedEventListener(EmailPortIn emailPortIn) {
        this.emailPortIn = emailPortIn;
    }

    @Override
    public void accept(SchedulingCreatedEventDto schedulingCreatedEventDto) {

    }
}
