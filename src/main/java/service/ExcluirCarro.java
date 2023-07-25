package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Classe responsável por excluir um carro do estacionamento.
 */
public class ExcluirCarro {

    public static void excluirCarroEstacionamento() {
        Scanner entrada = new Scanner(System.in);
        int id;


        System.out.println("|-Digite o Id do carro para retirar do estacionamento:-|");
        id = entrada.nextInt();

        try {
            Connection connection = Conexao.getConnection();

            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM tb_carro WHERE id = ?");
            selectStatement.setInt(1, id);

            if (selectStatement.executeQuery().next()) {
                PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM tb_carro WHERE id = ?");
                deleteStatement.setInt(1, id);
                System.out.println("|--Carro removido do estacionamento.--|");
                deleteStatement.close();
            } else {
                System.out.println("|--Carro não encontrado no estacionamento.--|");

            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar carro do estacionamento: " + e.getMessage());
        }
    }
}
