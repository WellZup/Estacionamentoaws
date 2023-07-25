package service;

import connection.Conexao;
import model.Carro;
import model.Estacionamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsável por listar os carros estacionados.
 */
public class ListarCarro {

    public static void listarCarroEstacoinamento() {
        try {

            Connection connection = Conexao.getConnection();

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_carro");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");

                String nome = resultSet.getString("nomedono");
                String marcacarro = resultSet.getString("marcacarro");
                String placa = resultSet.getString("placa");


                Carro carro = new Carro(id,nome,marcacarro,placa);


                System.out.println("ID: " + carro.getId(placa));
                System.out.println("Nome do dono: " + carro.getNomeDono());
                System.out.println("Marca do carro: " + carro.getMarcaCarro());
                System.out.println("Placa do carro: " + carro.getPlaca());



            }

        } catch (SQLException e ) {
            System.out.println("Erro ao listar carros no estacionamento: " + e.getMessage());
        }

    }
}
