package service;

import connection.Conexao;
import model.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class EstacionamentoService {
    static Connection connection = Conexao.getConnection();

    public static int calcularPermanencia(Calendar entrada, Calendar saida) {
        long diferencaMillis = saida.getTimeInMillis() - entrada.getTimeInMillis();
        int permanenciaMinutos = (int) (diferencaMillis / (1000 * 60));

        return permanenciaMinutos;
    }

    public static double calcularValorPagamento(int permanenciaMinutos) {
        double valorBase = 10.0;
        double valorAdicional = 2.0;
        double valorMeioPeriodo = 90.0;

        if (permanenciaMinutos <= 60) {
            return valorBase;
        } else if (permanenciaMinutos <= 90) {
            return valorBase + valorAdicional;
        } else {
            int numMeioPeriodos = (permanenciaMinutos - 90) / (12 * 60);
            return valorBase + valorAdicional + (numMeioPeriodos * valorMeioPeriodo);
        }
    }


    public static void adicionarCarro() {
        Scanner entradad = new Scanner(System.in);
        int carroid;
        int entrada;


        System.out.println("Digite o ID do Carro: ");
        carroid = entradad.nextInt();
        System.out.println("Digite entrada do Carro: ");
        entrada = entradad.nextInt();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO tb_estacionamento (carroid, entrada) VALUES (?, ?)");
            preparedStatement.setInt(1, carroid);
            preparedStatement.setInt(2, entrada);


            preparedStatement.executeUpdate();
            System.out.println("|-----------Carro adicionado com sucesso!----------|");

        } catch (SQLException e) {
            System.out.println("|------Erro ao cadastrar carro: ----|" + e.getMessage());
        }
    }

    public static void atualizarCarroEstacionado() {
        Scanner entrada = new Scanner(System.in);
        int carroId;


        System.out.println("|-Digite o Id do carro para atualizar os dados:-|");
        carroId = entrada.nextInt();

        try {
            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM tb_carro WHERE id = ?");
            selectStatement.setInt(1, carroId);

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getTimestamp("entrada"));

                Calendar saida = Calendar.getInstance();
                saida.setTime(resultSet.getTimestamp("saida"));

                int permanenciaMinutos = calcularPermanencia(calendar, saida);
                double valorPago = calcularValorPagamento(permanenciaMinutos);

                PreparedStatement updateStatement = connection.prepareStatement(
                        "UPDATE tb_estacionamento SET permanencia = ?, valorpago = ? WHERE carroid = ?");
                updateStatement.setInt(1, permanenciaMinutos);
                updateStatement.setDouble(2, valorPago);
                updateStatement.setInt(3, carroId);

                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("|----------Dados atualizados. --------------|");
                } else {
                    System.out.println("|----------Erro ao atualizar dados.-------------|");
                }
            } else {
                System.out.println("|--Carro não encontrado no estacionamento.--|");
            }

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar dados do carro: " + e.getMessage());
        }
    }

    public static void editarCarroEstacionado() {
        Scanner entrada = new Scanner(System.in);
        int carroId;
        int novaPermanenciaMinutos;

        System.out.println("|-Digite o Id do carro para editar a permanência:-|");
        carroId = entrada.nextInt();
        System.out.println("|-Digite a nova permanência do carro em minutos:--|");
        novaPermanenciaMinutos = entrada.nextInt();

        try {
            Connection connection = Conexao.getConnection();

            PreparedStatement selectStatement = connection.prepareStatement("SELECT * FROM tb_estacionamento WHERE id = ?");
            selectStatement.setInt(1, carroId);

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(resultSet.getTimestamp("entrada"));

                Calendar saida = Calendar.getInstance();
                saida.setTime(resultSet.getTimestamp("saida"));

                int permanenciaMinutos = EstacionamentoService.calcularPermanencia(calendar, saida);
                int diferencaMinutos = novaPermanenciaMinutos - permanenciaMinutos;

                Calendar novaSaida = Calendar.getInstance();
                novaSaida.setTime(saida.getTime());
                novaSaida.add(Calendar.MINUTE, diferencaMinutos);

                PreparedStatement updateStatement = connection.prepareStatement(
                        "UPDATE tb_estacionamento SET saida = ?, permanencia = ? WHERE carroid = ?");
                updateStatement.setTimestamp(1, new java.sql.Timestamp(novaSaida.getTimeInMillis()));
                updateStatement.setInt(2, novaPermanenciaMinutos);
                updateStatement.setInt(3, carroId);

                int rowsAffected = updateStatement.executeUpdate();
                if (rowsAffected > 0) {
                    double novoValorPago = EstacionamentoService.calcularValorPagamento(novaPermanenciaMinutos);
                    System.out.println("|----------Permanência atualizada. --------------|");
                    System.out.println("|----------Novo valor a ser pago: R$" + novoValorPago + "------------|");
                } else {
                    System.out.println("|----------Erro ao atualizar permanência.-------------|");
                }
            } else {
                System.out.println("|--Carro não encontrado no estacionamento.--|");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar permanência do carro: " + e.getMessage());
        }
    }


    public static List<RegistroEstacionamento> listarCarroEstacionamento() {
        List<RegistroEstacionamento> registros = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM tb_estacionamento " +
                    "JOIN tb_carro ON tb_estacionamento.carroid = tb_carro.id");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int idCarro = resultSet.getInt("id");
                String nome = resultSet.getString("nomedono");
                String marcacarro = resultSet.getString("marcacarro");
                String placa = resultSet.getString("placa");

                Carro carro = new Carro(idCarro, nome, marcacarro, placa);

                System.out.println(idCarro);
                System.out.println(nome);
                System.out.println(marcacarro);


                Calendar entrada = Calendar.getInstance();
                entrada.setTime(resultSet.getTimestamp("entrada"));

                Calendar saida = null;
                if (resultSet.getTimestamp("saida") != null) {
                    saida = Calendar.getInstance();
                    saida.setTime(resultSet.getTimestamp("saida"));
                }

                int permanenciaMinutos = resultSet.getInt("permanencia");
                double valorPago = resultSet.getDouble("valorpago");

                RegistroEstacionamento registro = new RegistroEstacionamento(carro, entrada, saida, permanenciaMinutos, valorPago);
                registros.add(registro);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar carros no estacionamento: " + e.getMessage());
        }


        return registros;
    }

}
