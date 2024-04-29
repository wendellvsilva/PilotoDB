package org.example;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Reserva reserva = new Reserva(1, 101, LocalDateTime.of(2024, 4, 25, 12, 0),
                LocalDateTime.of(2024, 4, 30, 16, 0));
        LocalDateTime verificarReserva = LocalDateTime.of(2024, 7, 30, 15, 0);
        if (reserva.estaOcupado(verificarReserva)) {
            System.out.println("O quarto está ocupado nessa hora/data.");
        } else {
            System.out.println("O quarto está livre nessa hora/data.");
        }
    }
}