package org.example;

    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {
    private Hotel hotel; // Declaração da variável hotel

    @BeforeEach
    public void setUp() {
        hotel = new Hotel(); // Inicialização do hotel antes de cada teste
    }

    // Teste para adicionar uma reserva com sucesso
    @Test
    public void testAdicionarReservaComSucesso() {
        // Definição das datas de início e fim da reserva
        LocalDateTime comecoReserva = LocalDateTime.of(2024, 5, 1, 0, 0);
        LocalDateTime fimReserva = LocalDateTime.of(2024, 5, 8, 0, 0);
        // Criação da reserva
        Reserva reserva1 = new Reserva(1, 1, comecoReserva, fimReserva);
        // Verificação se a reserva foi adicionada com sucesso e se está contida na lista de reservas do hotel
        assertTrue(hotel.adicionarReserva(reserva1));
        assertTrue(hotel.getReservas().contains(reserva1));
    }

    // Teste para adicionar uma reserva com conflito
    @Test
    public void testAdicionarReservaComConflito() {
        // Definição das datas de início e fim da primeira reserva
        LocalDateTime comecoReserva = LocalDateTime.of(2024, 5, 1, 0, 0);
        LocalDateTime fimReserva1 = LocalDateTime.of(2024, 5, 8, 0, 0);
        // Criação da primeira reserva
        Reserva reserva1 = new Reserva(1, 1, comecoReserva, fimReserva1);
        // Adição da primeira reserva ao hotel
        assertTrue(hotel.adicionarReserva(reserva1));

        // Definição das datas de início e fim da segunda reserva
        LocalDateTime comecoReserva2 = LocalDateTime.of(2024, 5, 5, 0, 0);
        LocalDateTime fimReserva2 = LocalDateTime.of(2024, 5, 12, 0, 0);
        // Criação da segunda reserva
        Reserva reserva2 = new Reserva(2, 1, comecoReserva2, fimReserva2);
        // Verificação se a segunda reserva não foi adicionada devido a conflito com a primeira
        assertFalse(hotel.adicionarReserva(reserva2));
        assertFalse(hotel.getReservas().contains(reserva2));
    }


    // Teste para verificar a disponibilidade sem reserva
    @Test
    public void testVerificarDisponibilidadeSemReserva() {
        // Definição das datas de início e fim do período desejado
        LocalDateTime comecoReserva = LocalDateTime.of(2024, 5, 1, 0, 0);
        LocalDateTime fimReserva = LocalDateTime.of(2024, 5, 8, 0, 0);
        // Verificação se o quarto está disponível para o período desejado
        assertTrue(hotel.verificarDisponibilidade(1, comecoReserva, fimReserva));
    }

    // Teste para cancelar uma reserva com sucesso
    @Test
    public void testCancelarReservaComSucesso() {
        // Definição das datas de início e fim da reserva
        LocalDateTime comecoReserva = LocalDateTime.of(2024, 5, 1, 0, 0);
        LocalDateTime fimReserva = LocalDateTime.of(2024, 5, 8, 0, 0);
        // Criação da reserva
        Reserva reserva = new Reserva(1, 1, comecoReserva, fimReserva);
        // Adição da reserva ao hotel
        hotel.adicionarReserva(reserva);
        // Cancelamento da reserva
        assertTrue(hotel.cancelarReserva(reserva.getId()));
        // Verificação se a reserva foi removida da lista de reservas do hotel
        assertFalse(hotel.getReservas().contains(reserva));
    }

    // Teste para cancelar uma reserva com ID inválido
    @Test
    public void testCancelarReservaComIdInvalido() {
        // Definição das datas de início e fim da reserva
        LocalDateTime comecoReserva = LocalDateTime.of(2024, 5, 1, 0, 0);
        LocalDateTime fimReserva = LocalDateTime.of(2024, 5, 8, 0, 0);
        // Criação da reserva
        Reserva reserva = new Reserva(1, 1, comecoReserva, fimReserva);
        // Adição da reserva ao hotel
        hotel.adicionarReserva(reserva);
        // Verificação se a reserva foi adicionada ao hotel
        assertTrue(hotel.getReservas().contains(reserva));
        // Tentativa de cancelar uma reserva com ID inválido
        assertFalse(hotel.cancelarReserva(2));
    }
}