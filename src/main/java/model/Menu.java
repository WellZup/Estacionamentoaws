package model;

import service.*;

import java.util.Scanner;

/**
 * Classe que contém o menu do programa.
 */
public class Menu {

    public static void exibirMenu() {
        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println("|---------------------------------------------|");
            System.out.println("|-------------------MENU----------------------|");
            System.out.println("|----------1. Adicionar Carro-----------------|");
            System.out.println("|----------2. Remover Carro-------------------|");
            System.out.println("|----------3. Relatório: Carros --------------|");
            System.out.println("|----------4. Entrada de Carro  --------------|");
            System.out.println("|----------5. Editar permanência de Carro-----|");
            System.out.println("|----------6. Listar Carros no Estacionamento-|");
            System.out.println("|----------0. Sair----------------------------|");
            System.out.println("|---------------------------------------------|");


            int opcao = entrada.nextInt();

            switch (opcao) {
                case 1:
                    AddCarro.addCarro();
                    break;

                case 2:
                    ExcluirCarro.excluirCarroEstacionamento();
                    break;
                case 3:
                    ListarCarro.listarCarroEstacoinamento();
                    break;
                case 4:
                    EstacionamentoService.adicionarCarro();
                    break;
                case 5:
                    EstacionamentoService.editarCarroEstacionado();
                    break;
                case 6:
                    EstacionamentoService.listarCarroEstacionamento();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println();
        }
    }
}
