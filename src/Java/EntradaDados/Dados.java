package Java.EntradaDados;

import Java.Racao.Racao_Tipo;
import Java.Racao.Racao_Tempo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            return resultado;

        }catch (InputMismatchException e){
            System.out.println("Apenas números inteiros!!\n");
            return 0;
        }
    }
    public LocalDate inicioDoPlanejamento(){
        Scanner leitura = new Scanner(System.in);
        StringBuffer data = new StringBuffer();
        try {
            System.out.println("Data de ínicio do planejamento:");
            System.out.print("Dia : ");
            data.append(leitura.next()+"-");
            System.out.print("Mês : ");
            data.append(leitura.next()+"-");
            System.out.print("Ano : ");
            data.append(leitura.next());
        }catch (Exception e){
            System.out.println("Data invalida!!!");
        }
        return LocalDate.parse(data.toString(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
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
    public List<Racao_Tempo> factoryRacao(){

        Scanner leitura = new Scanner(System.in);
        List<Racao_Tempo> listaRacoes = new ArrayList<>();

        String empresa = new String();
        String tipo = new String();
        double precoDaSaca = 0.0;
        int pesoCadaSaca = 0;

        System.out.println("Cadastro de rações que serão utilizadas :");
        try {

        for (Racao_Tipo value : Racao_Tipo.values()) {
            System.out.println("______________________");
            System.out.print("Ração tipo : " + value);

            System.out.print("\nEmpresa : ");
            empresa = leitura.next();


            System.out.print("Tipo : ");
            tipo = leitura.next();


            System.out.print("Preço/Saca : ");
            precoDaSaca = leitura.nextDouble();


            System.out.print("Peso/Saca : ");
            pesoCadaSaca = leitura.nextInt();

            Racao_Tempo racAux = new Racao_Tempo(empresa, tipo, precoDaSaca, pesoCadaSaca, value.toString());
            Racao_Tempo.carregaRacaoPrecoPeso(racAux);
            listaRacoes.add(racAux);
            leitura.reset();
        }
        }catch (Exception e){
            System.out.println(e);
        }
      return listaRacoes;
    }
}
