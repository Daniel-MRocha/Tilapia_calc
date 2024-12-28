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
            leitura.close();
            return resultado;

        }catch (InputMismatchException e){
            System.out.println("Apenas números inteiros!!\n");
            return 0;
        }
    }


}
