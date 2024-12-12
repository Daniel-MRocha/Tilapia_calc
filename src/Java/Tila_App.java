package Java;

import Java.Fases.*;

import java.util.Scanner;

public class Tila_App {

    public static int cicloDias = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de tilápias : ");
        int qtdTilapias = sc.nextInt();

        De_1_A_5Gr larva = new De_1_A_5Gr();
        De_5_A_10Gr alevino1 = new De_5_A_10Gr();
        De_10_A_20Gr alevino2 = new De_10_A_20Gr();
        De_20_A_50Gr juvenil1 = new De_20_A_50Gr();
        De_50_A_150Gr juvenil2 = new De_50_A_150Gr();
        De_150_A_250Gr adulto1 = new De_150_A_250Gr();


        System.out.println(larva.calculo(qtdTilapias).toString());
        System.out.println(alevino1.calculo(qtdTilapias).toString());
        System.out.println(alevino2.calculo(qtdTilapias).toString());
        System.out.println(juvenil1.calculo(qtdTilapias).toString());
        System.out.println(juvenil2.calculo(qtdTilapias).toString());
        System.out.println(adulto1.calculo(qtdTilapias).toString());


    }

}
