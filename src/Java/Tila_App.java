package Java;

import Java.EntradaDados.Dados;
import Java.Fases.*;
import Java.Racao_Tempo.I_Racao;
import Java.Racao_Tempo.Util_Racao_Tempo;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Tila_App {

    public static void main(String[] args) {

        Dados dados = new Dados();

        int qtdTilapias = 0;
        int qtdFases = 0;

        while (qtdTilapias==0) qtdTilapias = dados.qtdTilapias();
        while (qtdFases < 1 || qtdFases > 11) qtdFases = dados.qtdFases();


        List<StringBuffer> bufLista = buffers(qtdFases,qtdTilapias);






//        //Instâncias com calculo de tempo e ração estimada
//        Util_Racao_Tempo uLarva = new Util_Racao_Tempo("Mercado livre","pó com hormônio",132.5,2,larva.getRacaoTotal(), LocalDate.now(), larva.getDias());
//        Util_Racao_Tempo uAlevino1 = new Util_Racao_Tempo("Supra alisul","42% , 1.7mm",349,25,alevino1.getRacaoTotal(),uLarva.getDataFinalFase(),alevino1.getDias());
//        Util_Racao_Tempo uAlevino2 = new Util_Racao_Tempo("Supra alisul","42% , 1.7mm",349,25,alevino2.getRacaoTotal(),uAlevino1.getDataFinalFase(),alevino2.getDias());
//        Util_Racao_Tempo uJuvenil1 = new Util_Racao_Tempo("Cocamar Aqua","32% 2-4mm",74.46,25,juvenil1.getRacaoTotal(),uAlevino2.getDataFinalFase(), juvenil1.getDias());
//        Util_Racao_Tempo uJuvenil2 = new Util_Racao_Tempo("Cocamar Aqua","32% 2-4mm",74.46,25,juvenil2.getRacaoTotal(),uJuvenil1.getDataFinalFase(), juvenil2.getDias());
//        Util_Racao_Tempo uAdulto1 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto1.getRacaoTotal(),uJuvenil2.getDataFinalFase(),adulto1.getDias());
//        Util_Racao_Tempo uAdulto2 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto2.getRacaoTotal(),uAdulto1.getDataFinalFase(),adulto2.getDias());
//        Util_Racao_Tempo uAdulto3 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto3.getRacaoTotal(),uAdulto2.getDataFinalFase(),adulto3.getDias());
//        Util_Racao_Tempo uAdulto4 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto4.getRacaoTotal(),uAdulto3.getDataFinalFase(),adulto4.getDias());
//        Util_Racao_Tempo uAdulto5 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto5.getRacaoTotal(),uAdulto4.getDataFinalFase(),adulto5.getDias());
//        Util_Racao_Tempo uAdulto6 = new Util_Racao_Tempo("Cocamar aqua rpx4","32% 6mm",74.14,25,adulto6.getRacaoTotal(),uAdulto5.getDataFinalFase(),adulto6.getDias());




        //Saídas
bufLista.forEach(System.out::println);


        DecimalFormat dc = new DecimalFormat("R$###,##0.00");


        Period p = Period.between(LocalDate.now(),LocalDate.now().plus(Util_Racao_Tempo.cicloTotalDeDias,ChronoUnit.DAYS));

        System.out.println("Duração do ciclo_______");
        System.out.println("Anos = " + p.getYears());
        System.out.println("Meses = " + p.getMonths());
        System.out.println("Dias = " + p.getDays());
        System.out.println("Ração : " + dc.format(Util_Racao_Tempo.investimentoAproximado));

        System.out.println("\nEstimativa de lucro:");
        System.out.println("Peso Total: Kg" + qtdTilapias * 0.8);
        double fileKgs = ((qtdTilapias * 0.8)/100) * 30;
        System.out.println("Peso em filé: Kg" + fileKgs);

        System.out.println("Total do ganho , considerando R$55.90/Kg");
        System.out.println(dc.format(fileKgs * 55.90));


    }

    public static List<StringBuffer> buffers(int qtdFases,int qtdTilapias){

        List<StringBuffer> buffersList = new ArrayList<>();

       for(int count = 0; count < qtdFases ; count++){
           StringBuffer buffer = new StringBuffer();
           buffersList.add(buffer);
       }

       List<I_Fase> listFase =new ArrayList<>();
        I_Fase larva = new De_1_A_5Gr();
        I_Fase alevino1 = new De_5_A_10Gr();
        I_Fase alevino2 = new De_10_A_20Gr();
        I_Fase juvenil1 = new De_20_A_50Gr();
        I_Fase juvenil2 = new De_50_A_150Gr();
        I_Fase adulto1 = new De_150_A_250Gr();
        I_Fase adulto2 = new De_250_A_400Gr();
        I_Fase adulto3 = new De_400_A_600Gr();
        I_Fase adulto4 = new De_600_A_800Gr();
        I_Fase adulto5 = new De_800_A_1300Gr();
        I_Fase adulto6 = new De_1300_A_1800Gr();

        listFase.add(larva);
        listFase.add(alevino1);
        listFase.add(alevino2);
        listFase.add(juvenil1);
        listFase.add(juvenil2);
        listFase.add(adulto1);
        listFase.add(adulto2);
        listFase.add(adulto3);
        listFase.add(adulto4);
        listFase.add(adulto5);
        listFase.add(adulto6);

        for(int count = 0; count < qtdFases ; count++){
            buffersList.get(count).append(listFase.get(count).calculo(qtdTilapias));
        }
            return buffersList;
    }

}
