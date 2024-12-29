package Java.EntradaDados;

import java.util.InputMismatchException;
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

}
