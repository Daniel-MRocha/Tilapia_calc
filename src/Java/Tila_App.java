package Java;

import Java.Fases.De_1_A_5Gr;
import Java.Fases.De_5_A_10Gr;

import java.util.Scanner;

public class Tila_App {

    public static int cicloDias = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de tilápias : ");
        int qtdTilapias = sc.nextInt();

        De_1_A_5Gr larva = new De_1_A_5Gr();
        De_5_A_10Gr alevino = new De_5_A_10Gr();

        System.out.println(larva.calculo(qtdTilapias).toString());
       
        System.out.println(alevino.calculo(qtdTilapias).toString());

    }

}
