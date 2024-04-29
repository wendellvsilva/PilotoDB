package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Classe que representa um hotel com funcionalidades de reserva
public class Hotel {
    // Lista de reservas do hotel
    private List<Reserva> reservas;

    // Construtor da classe Hotel
    public Hotel() {
        // Inicializa a lista de reservas
        this.reservas = new ArrayList<>();
    }

    // Método para verificar a disponibilidade de um quarto em um determinado período
    public boolean verificarDisponibilidade(int numeroQuarto, LocalDateTime ComecoReserva, LocalDateTime fimReserva) {
            for (Reserva reserva : reservas) {
            // Verifica se o número do quarto da reserva atual é o mesmo que o número do quarto desejado
            if (reserva.getNumeroQuarto() == numeroQuarto) {
                // Verifica se o quarto está ocupado no período desejado
                if (reserva.estaOcupado(ComecoReserva) || reserva.estaOcupado(fimReserva)) {
                    return false; // Retorna false se o quarto estiver ocupado em qualquer momento do período
                }
            }
        }
        return true; // Retorna true se o quarto estiver disponível durante todo o período
    }

    // Método para adicionar uma nova reserva
    public boolean adicionarReserva(Reserva reserva) {
        int numeroQuarto = reserva.getNumeroQuarto();
        LocalDateTime dataInicio = reserva.getComecoReserva();
        LocalDateTime dataFim = reserva.getFimReserva();

        // Verifica se as datas de início e fim da reserva são válidas e se o quarto está disponível nesse período
        if ((dataFim == null && dataInicio == null) || !verificarDisponibilidade(numeroQuarto, dataInicio, dataFim)) {
            return false; // Retorna false se a reserva não puder ser adicionada
        }

        // Adiciona a reserva à lista de reservas do hotel
        reservas.add(reserva);
        return true; // Retorna true se a reserva foi adicionada com sucesso
    }

    // Método para cancelar uma reserva pelo ID
    public boolean cancelarReserva(int idReserva) {
        // Procura a reserva com o ID fornecido na lista de reservas
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) { // Se encontrar a reserva com o ID fornecido
                reservas.remove(reserva); // Remove a reserva da lista
                return true; // Retorna true indicando que a reserva foi cancelada com sucesso
            }
        }
        return false; // Retorna false se não encontrar uma reserva com o ID fornecido
    }

    // Método para obter todas as reservas do hotel
    public List<Reserva> getReservas() {
        return reservas; // Retorna a lista de reservas do hotel
    }
}