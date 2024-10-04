package br.ada.santader.salary;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;

public class WorkShift {

    private LocalDateTime start;
    private LocalDateTime end;
    private BigDecimal hourlyRate;

    public WorkShift(LocalDateTime start, LocalDateTime end, BigDecimal hourlyRate) {
        this.start = start;
        this.end = end;
        this.hourlyRate = hourlyRate;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Duration totalHours() {
        if (start.toLocalDate().compareTo(end.toLocalDate()) != 0) {
            throw new IllegalArgumentException("Não é possível calcular as horas pois foi inputado valores incorretos.");
        }
        return Duration.between(start, end);
    }

    public BigDecimal hourlyRate() {
        if (start.getDayOfWeek() == DayOfWeek.SATURDAY
                || start.getDayOfWeek() == DayOfWeek.MONDAY) {
            return hourlyRate.multiply(BigDecimal.valueOf(1.20));
        } else {
            return hourlyRate;
        }
    }

}
