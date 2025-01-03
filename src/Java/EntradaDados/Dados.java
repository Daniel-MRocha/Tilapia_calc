package Java.EntradaDados;

import Java.Racao.Racao_Tipo;
import Java.Racao.Racao_Tempo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Dados {

    public int qtdTilapias(){

        try {
            Scanner leitura = new Scanner(System.in);
            System.out.print("Número de tilápias: ");
            int resultado = leitura.nextInt();
            System.out.println("\n");
            return resultado;

        }catch (InputMismatchException e){
            System.out.println("Apenas números inteiros!!\n");
            return 0;
        }
    }
    public int qtdFases(){
    Scanner leitura = new Scanner(System.in);
    try {
        int resultado;

            System.out.print("""
                    Plano até qual as fase? 
                    1) de 1 a 5  gramas
                    2) de 5 a 10 gramas
                    3) de 10 a 20 gramas
                    4) de 20 a 50 gramas
                    5) de 50 a 150 gramas
                    6) de 150 a 250 gramas
                    7) de 250 a 400 gramas
                    8) de 400 a 600 gramas
                    9) de 600 a 800 gramas
                    10) de 800 a 1300 gramas
                    11) de 1300 a 1800 gramas
                 
                    """);
        System.out.print("Opção: ");
        resultado = leitura.nextInt();
        System.out.println("\n");
        return resultado;

    }catch (Exception e){
        System.out.println(e);
        System.out.println("Apenas números inteiros de 1 a 11!!\n");
        return 0;
    }
}
    public List<Racao_Tempo> factoryRacao() throws Exception{

        Scanner leitura = new Scanner(System.in);
        List<Racao_Tempo> listaRacoes = new ArrayList<>();

        String empresa = new String();
        String tipo = new String();
        double precoDaSaca = 0.0;
        int pesoCadaSaca = 0;


        System.out.println("Cadastro de rações que serão utilizadas :");

        for (Racao_Tipo value : Racao_Tipo.values()) {
            System.out.println("______________________");
            System.out.print("Ração tipo : " + value);

            System.out.print("\nEmpresa : ");
            empresa = leitura.next();


            System.out.print("Tipo : ");
            tipo =  leitura.next();


            System.out.print("Preço/Saca : ");
            precoDaSaca = leitura.nextDouble();


            System.out.print("Peso/Saca : ");
            pesoCadaSaca = leitura.nextInt();



             Racao_Tempo racAux = new Racao_Tempo(empresa,tipo,precoDaSaca,pesoCadaSaca,value.toString());
             listaRacoes.add(racAux);
             carregaConstantesRacao(value.toString(),precoDaSaca,pesoCadaSaca);
             leitura.reset();
        }
      return listaRacoes;
    }
    public void carregaConstantesRacao(String fase,double preco, int peso){
        switch (fase){
            case "LARVA":
                Racao_Tempo.larvaRacaoPreco = preco;
                Racao_Tempo.larvaPesoSaca = peso;
                break;
            case "ALEVINO":
                Racao_Tempo.alevinoRacaoPreco = preco;
                Racao_Tempo.alevinoPesoSaca = peso;
                break;
            case "jUVENIL":
                Racao_Tempo.juvenilRacaoPreco = preco;
                Racao_Tempo.juvenilPesoSaca = peso;
                break;
            case "ADULTO":
                Racao_Tempo.adultoRacaoPreco = preco;
                Racao_Tempo.adultoPesoSaca = peso;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + fase);
        }
    }

}
