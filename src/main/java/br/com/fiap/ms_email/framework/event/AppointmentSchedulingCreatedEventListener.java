package br.com.fiap.ms_email.framework.event;

import br.com.fiap.ms_email.core.domain.Scheduling;
import br.com.fiap.ms_email.core.port.in.SchedulingPortIn;
import br.com.fiap.ms_email.framework.dto.event.SchedulingCreatedEventDto;
import br.com.fiap.ms_email.framework.mapper.SchedulingDtoDomainMapper;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class AppointmentSchedulingCreatedEventListener implements Consumer<SchedulingCreatedEventDto> {

    private final SchedulingPortIn schedulingPortIn;

    public AppointmentSchedulingCreatedEventListener(SchedulingPortIn schedulingPortIn) {
        this.schedulingPortIn = schedulingPortIn;
    }

    @Override
    public void accept(SchedulingCreatedEventDto schedulingCreatedEventDto) {
        schedulingCreatedEventDto.setAppointment(true);
        Scheduling scheduling = SchedulingDtoDomainMapper.toScheduling(schedulingCreatedEventDto);
        schedulingPortIn.composeEmail(scheduling);
    }
}
