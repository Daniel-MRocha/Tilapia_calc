package Java.Fases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class De_1_A_5Gr implements I_Fase {

    private final double pesoIni = 0.001;
    private final double porcentagemPv = 0.14;
    private final double tca = 1.0;
    private double racaoTotal ;
    private List<Double> racaoDiaria = new ArrayList<>();
    private int dias;
    private final int refeicoesPorDia = 5;
    private String racaotipo = "Pó 42% de proteína bruta";

    DecimalFormat dc = new DecimalFormat("###,##0.000");

    @Override
    public double getRacaoTotal() {
        return racaoTotal;
    }
    @Override
    public int getDias() {
        return dias;
    }
    public String getRacaotipo() {
        return racaotipo;
    }
    @Override
    public StringBuffer calculo(int qtdTilapias) {
        StringBuffer resultado = new StringBuffer();

        resultado.append("FASE----------\n");
        resultado.append("Larva de 1 a 5 gramas\n");
        resultado.append(racaotipo+"\n");

        double pesoDinamico = pesoIni;

        while (pesoDinamico<0.005){

            racaoDiaria.add((pesoDinamico * porcentagemPv)*qtdTilapias);
            racaoTotal += (pesoDinamico * porcentagemPv)*qtdTilapias;
            pesoDinamico += (pesoDinamico * porcentagemPv)/tca;
            dias++;

        }

        double mediaDeRacaoDiaria = racaoDiaria.stream().mapToDouble(e->e).sum()/dias;


        resultado.append("Ração total : Kg "+ dc.format(racaoTotal) + "\n");
        resultado.append("Média de ração diária : Kg " +dc.format(mediaDeRacaoDiaria)  + "\n");
        resultado.append("Dividida em "+ refeicoesPorDia + " refeição(ões) de Kg " + dc.format(mediaDeRacaoDiaria/refeicoesPorDia) + "\n");
        resultado.append("Dias : "+dias+"\n");




        return resultado;
    }
}
