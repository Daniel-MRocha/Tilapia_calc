package Java;

import Java.Fases.De_1_A_5Gr;

import java.util.Scanner;

public class Tila_App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de tilápias : ");
        int qtdTilapias = sc.nextInt();

        De_1_A_5Gr tilapia = new De_1_A_5Gr();

        System.out.println(tilapia.calculo(qtdTilapias).toString());

    }

}
