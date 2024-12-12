package Java.Fases;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class De_10_A_20Gr implements I_logicaDaFase{

    private final double pesoIni = 0.01;
    private final double porcentagemPv = 0.05;
    private final double tca = 1.1;
    private double racaoTotal ;
    private List<Double> racaoDiaria = new ArrayList<>();
    private int dias;
    private final int refeicoesPorDia = 3;
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

        resultado.append("---------------------\n");
        resultado.append("Alevino de 10 a 20 gramas\n");
        resultado.append(racaotipo+"\n");

        double pesoDinamico = pesoIni;

        while (pesoDinamico<0.02){

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
        resultado.append("---------------------\n");



        return resultado;
    }
}
