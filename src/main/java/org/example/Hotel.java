package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        this.quartos = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }


    public boolean verificarDisponibilidade(int numeroQuarto, LocalDateTime dataInicio, LocalDateTime dataFim) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumeroQuarto() == numeroQuarto &&
                    !(dataFim.isBefore(reserva.getDataInicio()) || dataInicio.isAfter(reserva.getDataFim()))) {
                return false;
            }
        }
        return true;
    }

    public boolean adicionarReserva(Reserva reserva) {
        int numeroQuarto = reserva.getNumeroQuarto();
        LocalDateTime dataInicio = reserva.getDataInicio();
        LocalDateTime dataFim = reserva.getDataFim();

        if (!verificarDisponibilidade(numeroQuarto, dataInicio, dataFim)) {
            return false;
        }

        reservas.add(reserva);
        return true;
    }

    public boolean cancelarReserva(int idReserva) {
        Reserva reservaParaRemover = null;
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                reservaParaRemover = reserva;
                break;
            }
        }
        if (reservaParaRemover != null) {
            reservas.remove(reservaParaRemover);
            for (Quarto quarto : quartos) {
                if (quarto.getId() == reservaParaRemover.getNumeroQuarto()) {
                    break;
                }
            }
            return true;
        }

        return false;
    }
}