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

        processamento(listaFases, listaRacao,qtdTilapias).stream().forEach(e-> System.out.println(e));


        DecimalFormat dc = new DecimalFormat("R$###,##0.00");


        Period p = Period.between(LocalDate.now(),LocalDate.now().plus(Racao_Tempo.cicloTotalDeDias,ChronoUnit.DAYS));

        System.out.println("Duração do ciclo_______");
        System.out.println("Anos = " + p.getYears());
        System.out.println("Meses = " + p.getMonths());
        System.out.println("Dias = " + p.getDays());
        System.out.println("Ração : " + dc.format(Racao_Tempo.investimentoAproximado));

        System.out.println("\nEstimativa de lucro:");
        System.out.println("Peso Total: Kg" + qtdTilapias * 0.8);
        double fileKgs = ((qtdTilapias * 0.8)/100) * 30;
        System.out.println("Peso em filé: Kg" + fileKgs);

        System.out.println("Total do ganho , considerando R$55.90/Kg");
        System.out.println(dc.format(fileKgs * 55.90));


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
                Racao_Tempo.carregaConstantesRacao(racao.get(0));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
            else if(count > 0 && count < 3){
                racao.get(1).setRacaoTipo("ALEVINO");
                racao.get(1).setDatas(fases.get(count).getDias());
                aux.append(racao.get(1).gastoComRacao(fases.get(count).getDias()));
                Racao_Tempo.carregaConstantesRacao(racao.get(1));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
            else if(count > 2 && count < 5){
                racao.get(2).setRacaoTipo("JUVENIL");
                racao.get(2).setDatas(fases.get(count).getDias());
                aux.append(racao.get(2).gastoComRacao(fases.get(count).getDias()));
                Racao_Tempo.carregaConstantesRacao(racao.get(2));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
            else{
                racao.get(3).setRacaoTipo("ADULTO");
                racao.get(3).setDatas(fases.get(count).getDias());
                aux.append(racao.get(3).gastoComRacao(fases.get(count).getDias()));
                Racao_Tempo.carregaConstantesRacao(racao.get(3));
                buffer.get(count).append(aux);
                aux.delete(0,aux.length());
            }
        }
   return  buffer;
        }
    }

