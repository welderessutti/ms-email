package br.com.fiap.ms_email.core.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Scheduling {

    private Long id;
    private Long patientId;
    private LocalDateTime schedulingTime;
    private boolean isAppointment;

    public Scheduling() {
    }

    public Scheduling(Long id, Long patientId, LocalDateTime schedulingTime, boolean isAppointment) {
        this.id = id;
        this.patientId = patientId;
        this.schedulingTime = schedulingTime;
        this.isAppointment = isAppointment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public LocalDateTime getSchedulingTime() {
        return schedulingTime;
    }

    public void setSchedulingTime(LocalDateTime schedulingTime) {
        this.schedulingTime = schedulingTime;
    }

    public boolean isAppointment() {
        return isAppointment;
    }

    public void setAppointment(boolean appointment) {
        isAppointment = appointment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scheduling that = (Scheduling) o;
        return isAppointment == that.isAppointment && Objects.equals(id, that.id) && Objects.equals(patientId, that.patientId) && Objects.equals(schedulingTime, that.schedulingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientId, schedulingTime, isAppointment);
    }

    @Override
    public String toString() {
        return "Scheduling{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", schedulingTime=" + schedulingTime +
                ", isAppointment=" + isAppointment +
                '}';
    }
}
