package org.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class HotelTest {
    private Hotel hotel;

    @Before
    public void setUp() {
        hotel = new Hotel();
    }

    @Test
    public void testAdicionarReserva() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        Reserva reserva = new Reserva(1, 1, "2024-05-01");
        assertTrue(hotel.adicionarReserva(reserva));
        Quarto quarto2 = new Quarto(2);
        hotel.adicionarQuarto(quarto2);
        Reserva reserva2 = new Reserva(1, 8, "2024-05-01");
        assertTrue(hotel.adicionarReserva(reserva2));
    }

    @Test
    public void testAdicionarErrado(){
        Quarto quarto2 = new Quarto(1);
        hotel.adicionarQuarto(quarto2);
        Reserva reserva2 = new Reserva(1, 8, "2024-05-01");
        assertTrue(hotel.adicionarReserva(reserva2));
        Quarto quarto3 = new Quarto(1);
        hotel.adicionarQuarto(quarto3);
        Reserva reserva3 = new Reserva(1, 8, "2024-05-01");
        assertFalse(hotel.adicionarReserva(reserva3));
    }

    @Test
    public void testVerificarDisponibilidade() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        Reserva reserva = new Reserva(1, 1, "2024-05-01");
        hotel.adicionarReserva(reserva);
        assertFalse(hotel.verificarDisponibilidade(1, "2024-05-01"));
    }

    @Test
    public void testCancelarReserva() {
        Quarto quarto1 = new Quarto(1);
        hotel.adicionarQuarto(quarto1);
        Reserva reserva = new Reserva(1, 1, "2024-05-01");
        hotel.adicionarReserva(reserva);
        assertTrue(hotel.cancelarReserva(reserva.getId()));
    }
}