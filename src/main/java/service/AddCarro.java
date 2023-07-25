package service;

import connection.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Classe responsável por adicionar um carro no estacionamento.
 */
public class AddCarro {


    static Connection connection = Conexao.getConnection();
    public static void addCarro () {
        Scanner entrada = new Scanner(System.in);
        String nomeDono;
        String marcaCarro;
        String placa;
        boolean estado;


        System.out.println("Digite o nome do Dono: ");
        nomeDono = entrada.nextLine();
        System.out.println("Digite a marca do Carro: ");
        marcaCarro = entrada.nextLine();
        System.out.println("Informe a placa do Carro: ");
        placa = entrada.nextLine();
        System.out.println("Informe o estado do carro: ");
        estado = entrada.hasNextBoolean();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into tb_carro" +
                    "(nomedono,marcacarro, placa, estado) values(?,?,?,?)");
                    preparedStatement.setString(1,nomeDono);
                    preparedStatement.setString(2,marcaCarro);
                    preparedStatement.setString(3,placa);
                    preparedStatement.setBoolean(4,estado);



                    preparedStatement.executeUpdate();

            System.out.println("|-----------Carro adicionado com sucesso!----------|");


        } catch (SQLException e) {
            System.out.println("|------Erro ao cadastrar carro: ----|" + e.getMessage());
        }

    }

}
