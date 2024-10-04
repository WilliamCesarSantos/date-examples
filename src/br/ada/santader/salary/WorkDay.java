package br.ada.santader.salary;

import java.math.BigDecimal;

public class WorkDay {

    private WorkShift morning;
    private WorkShift afternoon;

    public WorkDay(WorkShift morning, WorkShift afternoon) {
        this.morning = morning;
        this.afternoon = afternoon;
    }

    public WorkShift getMorning() {
        return morning;
    }

    public void setMorning(WorkShift morning) {
        this.morning = morning;
    }

    public WorkShift getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(WorkShift afternoon) {
        this.afternoon = afternoon;
    }

    public Double totalHours() {
        var morningTime = morning.totalHours();
        var afternoonTime = afternoon.totalHours();
        return (morningTime.toMinutes() + afternoonTime.toMinutes()) / 60d;
    }

    public BigDecimal hourlyRate() {
        return morning.hourlyRate();
    }

}
