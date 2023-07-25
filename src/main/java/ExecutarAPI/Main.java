package ExecutarAPI;

import model.Menu;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Classe principal do programa.
 */
public class Main {
    public static void main(String[] args) {
        Calendar calendario = Calendar.getInstance();
        Date data = calendario.getTime();
        DateFormat formatdate = DateFormat.getDateInstance(DateFormat.LONG);

        System.out.println("|---------------------------------------------|");
        System.out.println("|-Seu acesso ao programa foi feita neste dia.-|");
        System.out.println("|--------------Data/Hora atual: --------------|\n" + "|------------" +formatdate.format(data) + "--------------|");
        System.out.println("|---------------------------------------------|");
        System.out.println();
        Menu.exibirMenu();




        }

}