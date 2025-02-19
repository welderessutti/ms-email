package br.com.fiap.ms_email.framework.mapper;

import br.com.fiap.ms_email.core.domain.Scheduling;
import br.com.fiap.ms_email.framework.dto.event.SchedulingCreatedEventDto;

public class SchedulingDtoDomainMapper {

    public static Scheduling toScheduling(SchedulingCreatedEventDto schedulingCreatedEventDto) {
        Scheduling scheduling = new Scheduling();
        scheduling.setId(schedulingCreatedEventDto.getId());
        scheduling.setPatientId(schedulingCreatedEventDto.getPatientId());
        scheduling.setSchedulingTime(schedulingCreatedEventDto.getSchedulingTime());
        scheduling.setAppointment(scheduling.isAppointment());
        return scheduling;
    }
}
