package Java;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Tila_App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de tilápias : ");
        int qtdTilapias = sc.nextInt();



    }


    public static void alevino(int qtdTilapias){
        DecimalFormat dc = new DecimalFormat("#,##0.000");

        System.out.println("\n----------------------------------");
        System.out.println("Alevinos de 3 a 5cm e de 10 a 15gr");
        System.out.println("----------------------------------");

        double peso = qtdTilapias * 0.012f;
        double racaoTotal = 0f;
        double racaoDinamica = 0f;

        for(int count = 0;count<45;count++){
           racaoDinamica =  peso * 0.08f;
           racaoTotal += racaoDinamica;
           peso += (racaoDinamica/1000);

        }

        System.out.printf("""
                Dados ao longo de 45 dias:
                Peso  = Kg %5s
                Ração = Kg %5s
                """,dc.format(peso),dc.format(racaoTotal));
    }
    public static void juvenil(int qtdTilapias){
        DecimalFormat dc = new DecimalFormat("#,##0.000");

        System.out.println("\n----------------------------------");
        System.out.println("Juvenis de 5 a 12cm e de 15 a 100gr");
        System.out.println("----------------------------------");

        double peso = qtdTilapias * 0.020f;
        double racaoTotal = 0f;
        double racaoDinamica = 0f;

        for(int count = 0;count<60;count++){
            racaoDinamica =  peso * 0.045f;
            racaoTotal += racaoDinamica;
            peso += (racaoDinamica/1130);

        }

        System.out.printf("""
                Dados ao longo de 60 dias:
                Peso  = Kg %5s
                Ração = Kg %5s
                """,dc.format(peso),dc.format(racaoTotal));
    }
}
