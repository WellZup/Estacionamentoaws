package service;

import model.Carro;

import java.util.Calendar;

public class RegistroEstacionamento {

    private Carro carro;
    private Calendar entrada;
    private Calendar saida;
    private double valorPago;

    public RegistroEstacionamento(Carro carro, Calendar entrada) {
        this.carro = carro;
        this.entrada = entrada;
    }

    public RegistroEstacionamento(Carro carro, Calendar entrada, Calendar saida, int permanencia, double valorPago) {
    }

    public Carro getCarro() {
        return carro;
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

    public void setSaida(Calendar saida) {
        this.saida = saida;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

}
