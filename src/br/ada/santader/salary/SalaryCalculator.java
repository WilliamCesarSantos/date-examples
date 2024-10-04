package br.ada.santader.salary;

import java.math.BigDecimal;
import java.util.List;

public class SalaryCalculator {

    public BigDecimal calculate(List<WorkDay> days) {
        if (days.size() < 7) {
            throw new IllegalArgumentException("Deve ter sido trabalhado no mínimo 7 dias para receber.");
        }
        var totalValue = BigDecimal.ZERO;
        for (WorkDay day : days) {
            var totalHours = BigDecimal.valueOf(day.totalHours());
            totalValue = totalValue.add(
                    day.hourlyRate().multiply(totalHours)
            );
        }
        return totalValue;
    }

}
