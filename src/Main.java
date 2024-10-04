import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        capturaDataEHora();
    }

    public static void capturaDataEHora() {
        var formatter = DateTimeFormatter
                .ofPattern("HH:mm");
        var scanner = new Scanner(System.in);
        System.out.println("Informe o horário de entrada(hh:mm):");
        var textDate = scanner.nextLine();
        var date = LocalTime.parse(textDate, formatter);
        System.out.println(date);
    }

    public static void calculoSimplificadoDasHorastrabalhadas() {
        LocalDateTime entrada = LocalDateTime.of(2024, 10, 04, 8, 00, 00);
        LocalDateTime saida = LocalDateTime.of(
                2024,
                11,
                04,
                17,
                30,
                00
        );

        var duration = Duration.between(entrada, saida);
        var horasTrabalhadas = duration.toHours();
        var minutosTrabalhados = duration.toMinutesPart();
        System.out.println("Foram trabalhadas: " + horasTrabalhadas + ":"+minutosTrabalhados+" horas");
    }

    public static void localDate() {
        java.time.LocalDate dataAtual = LocalDate.now();
        System.out.println("Data: " + dataAtual);
    }

    public static void localDateTime() {
        java.time.LocalDateTime dataEHoraAtual = LocalDateTime.now();
    }

    public static void zonedDateTime() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Europe/Lisbon"));
        System.out.println("Data e hora de Lisboa: " + zonedDateTime);

        ZonedDateTime zonedDateTimeSP = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo"));
        System.out.println("Data e hora de SP: " + zonedDateTimeSP);

        ZonedDateTime zonedDateTimeUTC = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println("Data e hora de UTC: " + zonedDateTimeUTC);
    }


}
