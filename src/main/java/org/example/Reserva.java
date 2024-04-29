package org.example;

import java.time.LocalDateTime;

// Classe que representa uma reserva de quarto
public class Reserva {
    // Atributos da classe
    private int id; // Identificador da reserva
    private int numeroQuarto; // Número do quarto reservado
    private LocalDateTime ComecoReserva; // Data e hora de início da reserva
    private LocalDateTime fimReserva; // Data e hora de término da reserva

    // Construtor da classe
    public Reserva(int id, int numeroQuarto, LocalDateTime ComecoReserva, LocalDateTime fimReserva) {
        this.id = id;
        this.numeroQuarto = numeroQuarto;
        this.ComecoReserva = ComecoReserva;
        this.fimReserva = fimReserva;
    }


    // Métodos de acesso aos atributos da classe
    public int getId() {
        return id;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public LocalDateTime getComecoReserva() {
        return ComecoReserva;
    }

    public LocalDateTime getFimReserva() {
        return fimReserva;
    }

    // Método para verificar se o quarto está ocupado em uma determinada data e hora
    public boolean estaOcupado(LocalDateTime verificarReserva) {
        return verificarReserva.isAfter(ComecoReserva) && verificarReserva.isBefore(fimReserva);
    }
}