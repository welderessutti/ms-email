package br.com.fiap.ms_email.framework.event;

import br.com.fiap.ms_email.core.domain.Scheduling;
import br.com.fiap.ms_email.core.port.in.SchedulingPortIn;
import br.com.fiap.ms_email.framework.dto.event.SchedulingCreatedEventDto;
import br.com.fiap.ms_email.framework.mapper.SchedulingDtoDomainMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
public class TestSchedulingCreatedEventListener implements Consumer<SchedulingCreatedEventDto> {

    private final SchedulingPortIn schedulingPortIn;

    public TestSchedulingCreatedEventListener(SchedulingPortIn schedulingPortIn) {
        this.schedulingPortIn = schedulingPortIn;
    }

    @Override
    public void accept(SchedulingCreatedEventDto schedulingCreatedEventDto) {
        log.info("TEST Scheduling received patient id: {}", schedulingCreatedEventDto.getPatientId());
        schedulingCreatedEventDto.setAppointment(false);
        Scheduling scheduling = SchedulingDtoDomainMapper.toScheduling(schedulingCreatedEventDto);
        schedulingPortIn.getPatientData(scheduling);
    }
}
