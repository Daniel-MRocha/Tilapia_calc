package Java;

import Java.EntradaDados.Dados;
import Java.Fases.*;
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

        while (qtdTilapias==0) qtdTilapias = dados.qtdTilapias();


        List<StringBuffer> bufLista = buffers();


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

        bufLista.get(0).append(larva.calculo(qtdTilapias));
        bufLista.get(1).append(alevino1.calculo(qtdTilapias));
        bufLista.get(2).append(alevino2.calculo(qtdTilapias));
        bufLista.get(3).append(juvenil1.calculo(qtdTilapias));
        bufLista.get(4).append(juvenil2.calculo(qtdTilapias));
        bufLista.get(5).append(adulto1.calculo(qtdTilapias));
        bufLista.get(6).append(adulto2.calculo(qtdTilapias));
        bufLista.get(7).append(adulto3.calculo(qtdTilapias));
        bufLista.get(8).append(adulto4.calculo(qtdTilapias));
        bufLista.get(9).append(adulto5.calculo(qtdTilapias));
        bufLista.get(10).append(adulto6.calculo(qtdTilapias));



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
        bufLista.get(0).append(uLarva.gastoComRacao(larva.getDias()));
        bufLista.get(1).append(uAlevino1.gastoComRacao(alevino1.getDias()));
        bufLista.get(2).append(uAlevino2.gastoComRacao(alevino2.getDias()));
        bufLista.get(3).append(uJuvenil1.gastoComRacao(juvenil1.getDias()));
        bufLista.get(4).append(uJuvenil2.gastoComRacao(juvenil2.getDias()));
        bufLista.get(5).append(uAdulto1.gastoComRacao(adulto1.getDias()));
        bufLista.get(6).append(uAdulto2.gastoComRacao(adulto2.getDias()));
        bufLista.get(7).append(uAdulto3.gastoComRacao(adulto3.getDias()));
        bufLista.get(8).append(uAdulto4.gastoComRacao(adulto4.getDias()));
        bufLista.get(9).append(uAdulto5.gastoComRacao(adulto5.getDias()));
        bufLista.get(10).append(uAdulto6.gastoComRacao(adulto6.getDias()));


        //Saídas
        System.out.print(bufLista.get(0).toString());
        System.out.println(bufLista.get(1).toString());
        System.out.println(bufLista.get(2).toString());
        System.out.println(bufLista.get(3).toString());
        System.out.println(bufLista.get(4).toString());
        System.out.println(bufLista.get(5).toString());
        System.out.println(bufLista.get(6).toString());
        System.out.println(bufLista.get(7).toString());
        System.out.println(bufLista.get(8).toString());
        System.out.println(bufLista.get(9).toString());
        System.out.println(bufLista.get(10).toString());


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

    public static List<StringBuffer> buffers(){
        List<StringBuffer> buffersList = new ArrayList<>();

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

        buffersList.add(larvaBuffer);
        buffersList.add(alevino1Buffer);
        buffersList.add(alevino2Buffer);
        buffersList.add(juvenil1Buffer);
        buffersList.add(juvenil2Buffer);
        buffersList.add(adulto1Buffer);
        buffersList.add(adulto2Buffer);
        buffersList.add(adulto3Buffer);
        buffersList.add(adulto4Buffer);
        buffersList.add(adulto5Buffer);
        buffersList.add(adulto6Buffer);
        return buffersList;
    }

}
