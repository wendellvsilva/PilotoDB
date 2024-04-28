package org.example;

import java.time.LocalDateTime;

public class Reserva {
    private int id;
    private int numeroQuarto;
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;

    public Reserva(int id, int numeroQuarto, LocalDateTime dataInicio, LocalDateTime dataFim) {
        this.id = id;
        this.numeroQuarto = numeroQuarto;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Reserva(int id, int numeroQuarto, String date) {
    }

    public int getId() {
        return id;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public boolean estaOcupado(LocalDateTime dataVerificar, LocalDateTime dataFim) {
        return dataVerificar.isAfter(dataInicio) && dataVerificar.isBefore(this.dataFim);
    }

    public static void main(String[] args) {
        Reserva reserva = new Reserva(1, 101, LocalDateTime.of(2024, 4, 25, 12, 0),
                LocalDateTime.of(2024, 4, 30, 16, 0));
        LocalDateTime dataVerificar = LocalDateTime.of(2024, 4, 30, 18, 0);
        if (reserva.estaOcupado(dataVerificar, reserva.getDataFim())) {
            System.out.println("O quarto está ocupado nessa hora/data.");
        } else {
            System.out.println("O quarto está livre nessa hora/data.");
        }
    }
}