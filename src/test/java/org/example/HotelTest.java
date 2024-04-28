package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    private Hotel hotel;
    private Quarto quarto;

    private Reserva reserva;

    @BeforeEach
    public void setUp() {
        hotel = new Hotel();
    }

    @Test
    public void testAdicionarReservaComSucesso() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        LocalDateTime dataInicio = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime dataFim = LocalDateTime.parse("2024-05-08T00:00:00");
        Reserva reserva1 = new Reserva(1, 1, dataInicio, dataFim);
        assertTrue(hotel.adicionarReserva(reserva1));
    }

    @Test
    public void testAdicionarReservaComConflito() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        LocalDateTime dataInicio1 = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime dataFim1 = LocalDateTime.parse("2024-05-08T00:00:00");
        Reserva reserva1 = new Reserva(1, 1, dataInicio1, dataFim1);
        assertTrue(hotel.adicionarReserva(reserva1));

        LocalDateTime dataInicio2 = LocalDateTime.parse("2024-05-05T00:00:00");
        LocalDateTime dataFim2 = LocalDateTime.parse("2024-05-12T00:00:00");
        Reserva reserva2 = new Reserva(2, 1, dataInicio2, dataFim2);
        assertFalse(hotel.adicionarReserva(reserva2));
    }

    @Test
    public void testVerificarDisponibilidadeComReservaExistente() {
        Quarto quarto1 = new Quarto(1);
        Quarto quarto2 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        hotel.adicionarQuarto(quarto2);

        LocalDateTime dataInicio1 = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime dataFim1 = LocalDateTime.parse("2024-05-08T00:00:00");
        LocalDateTime dataInicio2 = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime dataFim2 = LocalDateTime.parse("2024-05-08T00:00:00");
        Reserva reserva = new Reserva(1, 1, dataInicio1, dataFim1);
        Reserva reserva1 = new Reserva(1, 1, dataInicio2, dataFim2);

        hotel.adicionarReserva(reserva);
        hotel.adicionarReserva(reserva1);


        assertFalse(hotel.verificarDisponibilidade(1, dataInicio1, dataFim1));
    }

    @Test
    public void testVerificarDisponibilidadeSemReserva() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        LocalDateTime dataInicio = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime dataFim = LocalDateTime.parse("2024-05-08T00:00:00");
        assertTrue(hotel.verificarDisponibilidade(1, dataInicio, dataFim));
    }

    @Test
    public void testCancelarReservaComSucesso() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        LocalDateTime dataInicio = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime dataFim = LocalDateTime.parse("2024-05-08T00:00:00");
        Reserva reserva = new Reserva(1, 1, dataInicio, dataFim);
        hotel.adicionarReserva(reserva);
        assertTrue(hotel.cancelarReserva(reserva.getId()));
    }

    @Test
    public void testCancelarReservaComIdInvalido() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        LocalDateTime dataInicio = LocalDateTime.parse("2024-05-01T00:00:00");
        LocalDateTime dataFim = LocalDateTime.parse("2024-05-08T00:00:00");
        Reserva reserva = new Reserva(1, 1, dataInicio, dataFim);
        hotel.adicionarReserva(reserva);
        assertFalse(hotel.cancelarReserva(2));
    }
}