package Java;

import Java.Fases.*;
import Java.Racao_Tempo.Util_Racao_Tempo;

import java.time.LocalDate;
import java.util.Scanner;

public class Tila_App {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Número de tilápias : ");
        int qtdTilapias = sc.nextInt();
        System.out.println("\n");
        sc.close();

        //Buffers para as informações de cada fase
        StringBuffer larvaBuffer = new StringBuffer();
        StringBuffer alevino1Buffer = new StringBuffer();
        StringBuffer alevino2Buffer = new StringBuffer();
        StringBuffer juvenil1Buffer = new StringBuffer();
        StringBuffer juvenil2Buffer = new StringBuffer();
        StringBuffer adulto1Buffer = new StringBuffer();
        StringBuffer adulto2Buffer = new StringBuffer();
        StringBuffer adulto3Buffer = new StringBuffer();
        StringBuffer adulto4Buffer = new StringBuffer();
        StringBuffer adulto5Buffer = new StringBuffer();
        StringBuffer adulto6Buffer = new StringBuffer();

        //Instâncias de fases
        De_1_A_5Gr larva = new De_1_A_5Gr();
        De_5_A_10Gr alevino1 = new De_5_A_10Gr();
        De_10_A_20Gr alevino2 = new De_10_A_20Gr();
        De_20_A_50Gr juvenil1 = new De_20_A_50Gr();
        De_50_A_150Gr juvenil2 = new De_50_A_150Gr();
        De_150_A_250Gr adulto1 = new De_150_A_250Gr();
        De_250_A_400Gr adulto3 = new De_250_A_400Gr();
        De_400_A_600Gr adulto4 = new De_400_A_600Gr();
        De_600_A_800Gr adulto5 = new De_600_A_800Gr();
        De_800_A_1300Gr adulto6 = new De_800_A_1300Gr();
        De_1300_A_1800Gr adulto7 = new De_1300_A_1800Gr();

        larvaBuffer.append(larva.calculo(qtdTilapias));
        alevino1Buffer.append(alevino1.calculo(qtdTilapias));

        //Instâncias com calculo de tempo e ração estimada
        Util_Racao_Tempo uLarva = new Util_Racao_Tempo("Mercado livre","pó com hormônio",132.5,2,larva.getRacaoTotal(), LocalDate.now(), larva.getDias());
        Util_Racao_Tempo uAlevino1 = new Util_Racao_Tempo("Supra alisul","42% , 1.7mm",349,25,alevino1.getRacaoTotal(),uLarva.getDataFinalFase(),alevino1.getDias());

        //Carregamento dos buffers
        larvaBuffer.append(uLarva.gastoComRacao(larva.getDias()));
        alevino1Buffer.append(uAlevino1.gastoComRacao(alevino1.getDias()));



        System.out.print(larvaBuffer.toString());

        System.out.println(alevino1Buffer.toString());


        System.out.println(alevino2.calculo(qtdTilapias).toString());
        System.out.println(juvenil1.calculo(qtdTilapias).toString());
        System.out.println(juvenil2.calculo(qtdTilapias).toString());
        System.out.println(adulto1.calculo(qtdTilapias).toString());
        System.out.println(adulto3.calculo(qtdTilapias).toString());
        System.out.println(adulto4.calculo(qtdTilapias).toString());
        System.out.println(adulto5.calculo(qtdTilapias).toString());
        System.out.println(adulto6.calculo(qtdTilapias).toString());
        System.out.println(adulto7.calculo(qtdTilapias).toString());


    }

}
