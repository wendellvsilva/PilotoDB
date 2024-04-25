package org.example;

public class Reserva {
    private int id;
    private int numeroQuarto;
    private String data;

    public Reserva(int id, int numeroQuarto, String data) {
        this.id = id;
        this.numeroQuarto = numeroQuarto;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public String getData() {
        return data;
    }
}
