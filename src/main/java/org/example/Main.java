package org.example;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();


        Quarto quarto1 = new Quarto(1);
        Quarto quarto2 = new Quarto(2);
        hotel.adicionarQuarto(quarto1);
        hotel.adicionarQuarto(quarto2);


        Reserva reserva1 = new Reserva(1, 1, "2024-05-01");
        Reserva reserva2 = new Reserva(2, 2, "2024-05-02");
        Reserva reserva3 = new Reserva(3, 1, "2024-05-01");

        System.out.println("Adicionando reserva 1: " + hotel.adicionarReserva(reserva1));
        System.out.println("Adicionando reserva 2: " + hotel.adicionarReserva(reserva2));
        System.out.println("Adicionando reserva 3: " + hotel.adicionarReserva(reserva3));


        System.out.println("Verificando disponibilidade do quarto 1 em 2024-05-01: " +
                hotel.verificarDisponibilidade(1, "2024-05-01"));
        System.out.println("Verificando disponibilidade do quarto 2 em 2024-05-01: " +
                hotel.verificarDisponibilidade(2, "2024-05-01"));

        System.out.println("Cancelando reserva 1: " + hotel.cancelarReserva(1));
        System.out.println("Cancelando reserva 3: " + hotel.cancelarReserva(3));

        System.out.println("Verificando disponibilidade do quarto 1 em 2024-05-01 após cancelamento: " +
                hotel.verificarDisponibilidade(1, "2024-05-01"));
    }
}