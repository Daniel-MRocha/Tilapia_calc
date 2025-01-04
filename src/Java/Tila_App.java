package Java;

import Java.EntradaDados.Dados;
import Java.Fases.*;
import Java.Racao.Racao_Tempo;

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

        LocalDate inicioDoPlanejamento = dados.inicioDoPlanejamento();
        System.out.println("\n");
        Racao_Tempo.dataInicio = inicioDoPlanejamento;

        while (qtdFases < 1 || qtdFases > 11) qtdFases = dados.qtdFases();

        List<Racao_Tempo> listaRacao = dados.factoryRacao();

        System.out.println("\n");
        List<I_Fase> listaFases = fases(qtdFases);

        processamento(listaFases, listaRacao,qtdTilapias)
                .stream()
                .forEach(e-> System.out.println(e));

        painelDeDados(inicioDoPlanejamento,qtdTilapias,qtdFases);

    }
    public static void painelDeDados(LocalDate dataInicio, int qtdTilapias,int fases){

        double kilos = 0.0;

       //Set kilos dependendo da fase escolhida
        switch (fases){
           case 1:
               kilos = qtdTilapias * 0.005;
               break;
           case 2:
               kilos = qtdTilapias * 0.01;
               break;
           case 3:
               kilos = qtdTilapias * 0.02;
               break;
           case 4:
               kilos = qtdTilapias * 0.05;
               break;
           case 5:
               kilos = qtdTilapias * 0.15;
               break;
           case 6:
               kilos = qtdTilapias * 0.25;
               break;
           case 7:
               kilos = qtdTilapias * 0.4;
               break;
           case 8:
               kilos = qtdTilapias * 0.6;
               break;
           case 9:
               kilos = qtdTilapias * 0.8;
               break;
           case 10:
               kilos = qtdTilapias * 1.3;
               break;
           case 11:
               kilos = qtdTilapias * 1.8;
               break;
       }

        DecimalFormat dinheiroFormat = new DecimalFormat("R$ ###,##0.00");
        DecimalFormat pesoFormat =new DecimalFormat("Kg ###,##0.00");


        Period p = Period.between(dataInicio,dataInicio.plus(Racao_Tempo.cicloTotalDeDias, ChronoUnit.DAYS));

        System.out.println("Duração do ciclo_______");
        System.out.println("Anos = " + p.getYears());
        System.out.println("Meses = " + p.getMonths());
        System.out.println("Dias = " + p.getDays());

        System.out.println(investimento().toString());


        System.out.println("\nEstimativa de lucro:");
        System.out.println("Peso Total : " + pesoFormat.format(kilos));
        double fileKgs = (kilos/100) * 30;
        System.out.println("Peso em filé : " + pesoFormat.format(fileKgs));

        System.out.println("Total do ganho , considerando R$55.90/Kg");
        System.out.println(dinheiroFormat.format(fileKgs * 55.90));
    }
    public static List<I_Fase> fases(int qtdFases){

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


            return listFase.subList(0,qtdFases);
    }
    public static List<StringBuffer> processamento(List<I_Fase> fases, List<Racao_Tempo> racao,int qtdTilapias){
        List<StringBuffer> buffer = new ArrayList<>();
        StringBuffer aux = new StringBuffer();

        for (I_Fase fase : fases) {
            buffer.add(fase.calculo(qtdTilapias));
        }

        for(int count = 0; count < fases.size();count++){
            if(count==0){
                racao.get(0).setRacaoTipo("LARVA");
                racao.get(0).setDatas(fases.get(count).getDias());
                aux.append(racao.get(0).gastoComRacao(fases.get(count).getDias()));
                Racao_Tempo.carregaRacaoPrecoPeso(racao.get(0));
                racao.get(0).adicionaRacaoTotal(racao.get(0).getRacaoTipo(),fases.get(count));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
            else if(count > 0 && count < 3){
                racao.get(1).setRacaoTipo("ALEVINO");
                racao.get(1).setDatas(fases.get(count).getDias());
                aux.append(racao.get(1).gastoComRacao(fases.get(count).getDias()));
                Racao_Tempo.carregaRacaoPrecoPeso(racao.get(1));
                racao.get(1).adicionaRacaoTotal(racao.get(1).getRacaoTipo(),fases.get(count));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
            else if(count > 2 && count < 5){
                racao.get(2).setRacaoTipo("JUVENIL");
                racao.get(2).setDatas(fases.get(count).getDias());
                aux.append(racao.get(2).gastoComRacao(fases.get(count).getDias()));
                Racao_Tempo.carregaRacaoPrecoPeso(racao.get(2));
                racao.get(2).adicionaRacaoTotal(racao.get(2).getRacaoTipo(),fases.get(count));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
            else{
                racao.get(3).setRacaoTipo("ADULTO");
                racao.get(3).setDatas(fases.get(count).getDias());
                aux.append(racao.get(3).gastoComRacao(fases.get(count).getDias()));
                Racao_Tempo.carregaRacaoPrecoPeso(racao.get(3));
                racao.get(3).adicionaRacaoTotal(racao.get(3).getRacaoTipo(),fases.get(count));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
        }
   return  buffer;
        }
    public static StringBuffer investimento(){

        StringBuffer result = new StringBuffer();

        DecimalFormat dinheiroFormat = new DecimalFormat("R$ ###,##0.##");
        DecimalFormat pesoFormat =new DecimalFormat("Kg ###,##0.##");

        int sacasLarva = (int) ((Racao_Tempo.larvaRacao%Racao_Tempo.larvaPesoSaca == 0)
                ?(Racao_Tempo.larvaRacao/Racao_Tempo.larvaPesoSaca)
                :(Racao_Tempo.larvaRacao/Racao_Tempo.larvaPesoSaca) +1);

        int sacasAlevino = (int) ((Racao_Tempo.alevinoRacao%Racao_Tempo.alevinoPesoSaca == 0)
                ?(Racao_Tempo.alevinoRacao/Racao_Tempo.alevinoPesoSaca)
                :(Racao_Tempo.alevinoRacao/Racao_Tempo.alevinoPesoSaca) +1);

        int sacasJuvenil = (int) ((Racao_Tempo.juvenilRacao%Racao_Tempo.juvenilPesoSaca == 0)
                ?(Racao_Tempo.juvenilRacao/Racao_Tempo.juvenilPesoSaca)
                :(Racao_Tempo.juvenilRacao/Racao_Tempo.juvenilPesoSaca) +1);

        int sacasAdulto = (int) ((Racao_Tempo.adultoRacao%Racao_Tempo.adultoPesoSaca == 0)
                ?(Racao_Tempo.adultoRacao/Racao_Tempo.adultoPesoSaca)
                :(Racao_Tempo.adultoRacao/Racao_Tempo.adultoPesoSaca) +1);

        double larvaInvestimento = Racao_Tempo.larvaRacaoPreco * sacasLarva;
        double alevinoInvestimento = Racao_Tempo.alevinoRacaoPreco * sacasAlevino;
        double juvenilInvestimento = Racao_Tempo.juvenilRacaoPreco * sacasJuvenil;
        double adultoInvestimento = Racao_Tempo.adultoRacaoPreco * sacasAdulto;

        //Carregamento do buffer de resultado com os processamentos
        result.append("\nInvestimento");

        result.append("\nLarva:");
        result.append("\nTotal de ração : ").append(pesoFormat.format(Racao_Tempo.larvaRacao));
        result.append("\nPeso/saca : ").append(pesoFormat.format(Racao_Tempo.larvaPesoSaca));
        result.append("\nPreço/saca : ").append(dinheiroFormat.format(Racao_Tempo.larvaRacaoPreco));
        result.append("\nSacas necessárias : ").append(sacasLarva);
        result.append("\nValor : ").append(dinheiroFormat.format(larvaInvestimento));

        result.append("\nAlevino:");
        result.append("\nTotal de ração : ").append(pesoFormat.format(Racao_Tempo.alevinoRacao));
        result.append("\nPeso/saca : ").append(pesoFormat.format(Racao_Tempo.alevinoPesoSaca));
        result.append("\nPreço/saca : ").append(dinheiroFormat.format(Racao_Tempo.alevinoRacaoPreco));
        result.append("\nSacas necessárias : ").append(sacasAlevino);
        result.append("\nValor : ").append(dinheiroFormat.format(alevinoInvestimento));

        result.append("\nJuvenil:");
        result.append("\nTotal de ração : ").append(pesoFormat.format(Racao_Tempo.juvenilRacao));
        result.append("\nPeso/saca : ").append(pesoFormat.format(Racao_Tempo.juvenilPesoSaca));
        result.append("\nPreço/saca : ").append(dinheiroFormat.format(Racao_Tempo.juvenilRacaoPreco));
        result.append("\nSacas necessárias : ").append(sacasJuvenil);
        result.append("\nValor : ").append(dinheiroFormat.format(juvenilInvestimento));

        result.append("\nAdulto:");
        result.append("\nTotal de ração : ").append(pesoFormat.format(Racao_Tempo.adultoRacao));
        result.append("\nPeso/saca : ").append(pesoFormat.format(Racao_Tempo.adultoPesoSaca));
        result.append("\nPreço/saca : ").append(dinheiroFormat.format(Racao_Tempo.adultoRacaoPreco));
        result.append("\nSacas necessárias : ").append(sacasAdulto);
        result.append("\nValor : ").append(dinheiroFormat.format(adultoInvestimento));

        result.append("\n*****Investimento*****\n");
        result.append(dinheiroFormat.format((larvaInvestimento + alevinoInvestimento + juvenilInvestimento+adultoInvestimento)));
        result.append("\n");

        return result;
    }
    }


