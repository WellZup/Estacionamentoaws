package model;

public class Carro {

    private int id;
    private String nomeDono;
    private String marcaCarro;
    private String placa;


    /**
     * Classe que representa um carro.
     */
    public Carro(int id, String nomeDono, String marcaCarro, String placa) {
        this.id = id;
        this.nomeDono = nomeDono;
        this.marcaCarro = marcaCarro;
        this.placa = placa;

    }

    public int getId(String placa) {
        return id;
    }

    public String getNomeDono() {
        return nomeDono;
    }

    public String getMarcaCarro() {
        return marcaCarro;
    }

    public String getPlaca() {
        return placa;
    }


}
