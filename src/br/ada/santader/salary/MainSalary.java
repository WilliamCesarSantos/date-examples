package br.ada.santader.salary;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainSalary {

    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        System.out.println("Bem vindo ao sistema de cálculo salarial.");
        System.out.println("Para iniciar vamos precisar que seja informado alguns parâmetros.");

        System.out.println("Qual o valor da hora base do trabalhador?");
        var hourlyRate = new BigDecimal(scanner.nextLine());

        System.out.println("Vamos começar a fazer o input dos dias trabalhados");
        var days = new ArrayList<WorkDay>();
        var loop = "s";
        while (loop.equalsIgnoreCase("s")) {
            var workDay = captureWorkDay(scanner, hourlyRate);
            days.add(workDay);

            System.out.println("Deseja informar mais dias(s/n)?");
            loop = scanner.nextLine();
        }
        var salary = new SalaryCalculator().calculate(days);
        System.out.println("O total a receber é de: " + salary);
    }

    private static WorkDay captureWorkDay(Scanner scanner, BigDecimal hourlyRate) {
        System.out.println("Informe a data(dd/mm/aaaa)");
        var value = scanner.nextLine();
        var day = LocalDate.parse(value, dateFormatter);

        System.out.println("Informe os dados da manhã");
        var morning = captureWorkShift(scanner, day, hourlyRate);
        System.out.println("Informe os dados da tarde");
        var afternoon = captureWorkShift(scanner, day, hourlyRate);
        return new WorkDay(morning, afternoon);
    }

    private static WorkShift captureWorkShift(Scanner scanner, LocalDate day, BigDecimal hourlyRate) {
        System.out.println("Informe a hora de inicio(hh:mm):");
        var value = scanner.nextLine();
        var hour = LocalTime.parse(value, timeFormatter);
        var start = day.atTime(hour);

        System.out.println("Informe a hora de saída(hh:mm):");
        value = scanner.nextLine();
        hour = LocalTime.parse(value, timeFormatter);
        var end = day.atTime(hour);
        return new WorkShift(start, end, hourlyRate);
    }

}
