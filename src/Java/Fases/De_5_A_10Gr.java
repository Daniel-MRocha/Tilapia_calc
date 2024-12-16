package Java.Fases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class De_5_A_10Gr implements I_logicaDaFase{

    private final double pesoIni = 0.005;
    private final double porcentagemPv = 0.08;
    private final double tca = 1.0;
    private double racaoTotal ;
    private List<Double> racaoDiaria = new ArrayList<>();
    private int dias;
    private final int refeicoesPorDia = 4;
    private String racaotipo = "Pellet de 2-3mm 42% de proteína bruta";

    DecimalFormat dc = new DecimalFormat("###,##0.000");

    public double getRacaoTotal() {
        return racaoTotal;
    }

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
        resultado.append("Alevino de 5 a 10 gramas\n");
        resultado.append(racaotipo+"\n");

        double pesoDinamico = pesoIni;

        while (pesoDinamico<0.01){

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
