package model;

import java.util.Calendar;

/**
 * Classe que representa o estacionamento de um carro.
 * Esta classe herda da classe Carro.
 */
public class Estacionamento {
    private int carroId;
    private Calendar entrada;
    private Calendar saida;
    private double valorPago;
    private double permanencia;
    private boolean estado;

    public int getCarroId() {
        return carroId;
    }

    public Calendar getEntrada() {
        return entrada;
    }

    public Calendar getSaida() {
        return saida;
    }

    public double getValorPago() {
        return valorPago;
    }

    public double getPermanencia(Integer id, double permanencia) {
        return this.permanencia;
    }


}


