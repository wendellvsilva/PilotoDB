package org.example;

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

    public void removerQuarto(Quarto quarto) {
        quartos.remove(quarto);
    }

    public boolean verificarDisponibilidade(int numeroQuarto, String data) {
        for (Reserva reserva : reservas) {
            if (reserva.getNumeroQuarto() == numeroQuarto && reserva.getData().equals(data)) {
                return false;
            }
        }
        return true;
    }

    public boolean adicionarReserva(Reserva reserva) {
        if (verificarDisponibilidade(reserva.getNumeroQuarto(), reserva.getData())) {
            reservas.add(reserva);
            for (Quarto quarto : quartos) {
                if (quarto.getId() == reserva.getNumeroQuarto()) {
                    quarto.setOcupado(true);
                    break;
                }
            }
            return true;
        }
        return false;
    }

    public boolean cancelarReserva(int idReserva) {
        for (Reserva reserva : reservas) {
            if (reserva.getId() == idReserva) {
                reservas.remove(reserva);
                for (Quarto quarto : quartos) {
                    if (quarto.getId() == reserva.getNumeroQuarto()) {
                        quarto.setOcupado(false);
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }
}