package Java.Fases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class De_250_A_400Gr implements I_Fase {

    private final double pesoIni = 0.25;
    private final double porcentagemPv = 0.022;
    private final double tca = 1.4;
    private double racaoTotal ;
    private final List<Double> racaoDiaria = new ArrayList<>();
    private int dias;
    private final int refeicoesPorDia = 2;
    private final String racaotipo = "Pellet de 4-6mm 28-32% de proteína bruta";

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

        resultado.append("---------------------\n");
        resultado.append("Adulto de 250 a 400 gramas\n");
        resultado.append(racaotipo+"\n");

        double pesoDinamico = pesoIni;

        while (pesoDinamico<0.4){

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
