package Java;

import Java.Fases.*;
import Java.Racao_Tempo.Util_Racao_Tempo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
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
        De_250_A_400Gr adulto2 = new De_250_A_400Gr();
        De_400_A_600Gr adulto3 = new De_400_A_600Gr();
        De_600_A_800Gr adulto4 = new De_600_A_800Gr();
        De_800_A_1300Gr adulto5 = new De_800_A_1300Gr();
        De_1300_A_1800Gr adulto6 = new De_1300_A_1800Gr();

        larvaBuffer.append(larva.calculo(qtdTilapias));
        alevino1Buffer.append(alevino1.calculo(qtdTilapias));
        alevino2Buffer.append(alevino2.calculo(qtdTilapias));
        juvenil1Buffer.append(juvenil1.calculo(qtdTilapias));
        juvenil2Buffer.append(juvenil2.calculo(qtdTilapias));
        adulto1Buffer.append(adulto1.calculo(qtdTilapias));
        adulto2Buffer.append(adulto2.calculo(qtdTilapias));
        adulto3Buffer.append(adulto3.calculo(qtdTilapias));
        adulto4Buffer.append(adulto4.calculo(qtdTilapias));
        adulto5Buffer.append(adulto5.calculo(qtdTilapias));
        adulto6Buffer.append(adulto6.calculo(qtdTilapias));



        //Instâncias com calculo de tempo e ração estimada
        Util_Racao_Tempo uLarva = new Util_Racao_Tempo("Mercado livre","pó com hormônio",132.5,2,larva.getRacaoTotal(), LocalDate.now(), larva.getDias());
        Util_Racao_Tempo uAlevino1 = new Util_Racao_Tempo("Supra alisul","42% , 1.7mm",349,25,alevino1.getRacaoTotal(),uLarva.getDataFinalFase(),alevino1.getDias());
        Util_Racao_Tempo uAlevino2 = new Util_Racao_Tempo("Supra alisul","42% , 1.7mm",349,25,alevino2.getRacaoTotal(),uAlevino1.getDataFinalFase(),alevino2.getDias());
        Util_Racao_Tempo uJuvenil1 = new Util_Racao_Tempo("Cocamar Aqua","32% 2-4mm",74.46,25,juvenil1.getRacaoTotal(),uAlevino2.getDataFinalFase(), juvenil1.getDias());
        Util_Racao_Tempo uJuvenil2 = new Util_Racao_Tempo("Cocamar Aqua","32% 2-4mm",74.46,25,juvenil2.getRacaoTotal(),uJuvenil1.getDataFinalFase(), juvenil2.getDias());
        Util_Racao_Tempo uAdulto1 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto1.getRacaoTotal(),uJuvenil2.getDataFinalFase(),adulto1.getDias());
        Util_Racao_Tempo uAdulto2 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto2.getRacaoTotal(),uAdulto1.getDataFinalFase(),adulto2.getDias());
        Util_Racao_Tempo uAdulto3 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto3.getRacaoTotal(),uAdulto2.getDataFinalFase(),adulto3.getDias());
        Util_Racao_Tempo uAdulto4 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto4.getRacaoTotal(),uAdulto3.getDataFinalFase(),adulto4.getDias());
        Util_Racao_Tempo uAdulto5 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto5.getRacaoTotal(),uAdulto4.getDataFinalFase(),adulto5.getDias());
        Util_Racao_Tempo uAdulto6 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto6.getRacaoTotal(),uAdulto5.getDataFinalFase(),adulto6.getDias());

        //Carregamento dos buffers
        larvaBuffer.append(uLarva.gastoComRacao(larva.getDias()));
        alevino1Buffer.append(uAlevino1.gastoComRacao(alevino1.getDias()));
        alevino2Buffer.append(uAlevino2.gastoComRacao(alevino2.getDias()));
        juvenil1Buffer.append(uJuvenil1.gastoComRacao(juvenil1.getDias()));
        juvenil2Buffer.append(uJuvenil2.gastoComRacao(juvenil2.getDias()));
        adulto1Buffer.append(uAdulto1.gastoComRacao(adulto1.getDias()));
        adulto2Buffer.append(uAdulto2.gastoComRacao(adulto2.getDias()));
        adulto3Buffer.append(uAdulto3.gastoComRacao(adulto3.getDias()));
        adulto4Buffer.append(uAdulto4.gastoComRacao(adulto4.getDias()));
        adulto5Buffer.append(uAdulto5.gastoComRacao(adulto5.getDias()));
        adulto6Buffer.append(uAdulto6.gastoComRacao(adulto6.getDias()));


        //Saídas
        System.out.print(larvaBuffer.toString());
        System.out.println(alevino1Buffer.toString());
        System.out.println(alevino2Buffer.toString());
        System.out.println(juvenil1Buffer.toString());
        System.out.println(juvenil2Buffer.toString());
        System.out.println(adulto1Buffer.toString());
        System.out.println(adulto2Buffer.toString());
        System.out.println(adulto3Buffer.toString());
        System.out.println(adulto4Buffer.toString());
        System.out.println(adulto5Buffer.toString());
        System.out.println(adulto6Buffer.toString());


        DecimalFormat dc = new DecimalFormat("R$##0.00");


        Period p = Period.between(LocalDate.now(),LocalDate.now().plus(Util_Racao_Tempo.cicloTotalDeDias,ChronoUnit.DAYS));
        System.out.println("p.getYears() = " + p.getYears());
        System.out.println("p.getMonths() = " + p.getMonths());
        System.out.println("p.getDays() = " + p.getDays());
        System.out.println("Money : " + dc.format(Util_Racao_Tempo.investimentoAproximado));


    }

}
