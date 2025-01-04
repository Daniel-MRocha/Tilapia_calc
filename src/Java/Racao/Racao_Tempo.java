package Java.Racao;


import Java.Fases.I_Fase;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Racao_Tempo {

    //Variaveis estáticas
    public static int cicloTotalDeDias = 0;


    public static LocalDate dataInicio;
    public static LocalDate dataFim;

    public static double larvaRacao = 0.0;
    public static double alevinoRacao = 0.0;
    public static double juvenilRacao = 0.0;
    public static double adultoRacao = 0.0;

    public static double larvaRacaoPreco = 0.0;
    public static double alevinoRacaoPreco = 0.0;
    public static double juvenilRacaoPreco =0.0;
    public static double adultoRacaoPreco = 0.0;

    public static int larvaPesoSaca = 0;
    public static int alevinoPesoSaca =0;
    public static int juvenilPesoSaca = 0;
    public static int adultoPesoSaca = 0;

    private String empresa;
    private String tipo;
    private double preco_Saca;
    private int pesoCadaSaca;
    private String racaoTipo;
    private LocalDate dataInicioFase;
    private LocalDate dataFinalFase;

    public Racao_Tempo(String empresa, String tipo, double precoSaca, int pesoCadaSaca, String racaoTipo){
        this.empresa = empresa;
        this.tipo= tipo;
        this.preco_Saca = precoSaca;
        this.pesoCadaSaca = pesoCadaSaca;
        this.racaoTipo = racaoTipo;
    }
    public void setDatas(int dias){
        this.dataInicioFase = dataInicio;
        this.dataFinalFase = dataInicioFase.plus(dias,ChronoUnit.DAYS);
    }

    public void setRacaoTipo(String tipo){
        racaoTipo = tipo;
    }

    public String getEmpresa() {
        return empresa;
    }
    public String getTipo() {
        return tipo;
    }
    public double getPreco_Saca() {
        return preco_Saca;
    }
    public LocalDate getDataInicioFase() {
        return dataInicioFase;
    }
    public LocalDate getDataFinalFase() {
        return dataFinalFase;
    }

    public String getRacaoTipo() {
        return racaoTipo;
    }

    public StringBuffer gastoComRacao(int dias){

        cicloTotalDeDias = cicloTotalDeDias + dias;


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DecimalFormat dc = new DecimalFormat("R$###,##0.00");

        StringBuffer resultado = new StringBuffer();

        resultado.append("RAÇÃO---------\n");
        resultado.append("Empresa : "+ empresa + "\n");
        resultado.append("Tipo : "+ tipo + "\n");
        resultado.append("Preço/Saca : " + dc.format(preco_Saca) + "\n");
        resultado.append("Data de ínicio da fase : " + dataInicioFase.format(dtf)+"\n");
        resultado.append("Data de final da fase : " + dataFinalFase.format(dtf)+"\n\n");

        dataInicio = dataFinalFase;

        return resultado;
    }

    public static void carregaRacaoPrecoPeso(Racao_Tempo racao){
        switch (racao.getRacaoTipo()){
            case "LARVA":
                larvaRacaoPreco = racao.preco_Saca;
                larvaPesoSaca = racao.pesoCadaSaca;
                break;
            case "ALEVINO":
                alevinoRacaoPreco = racao.preco_Saca;
                alevinoPesoSaca = racao.pesoCadaSaca;
                break;
            case "JUVENIL":
                juvenilRacaoPreco = racao.preco_Saca;
                juvenilPesoSaca = racao.pesoCadaSaca;
                break;
            case "ADULTO":
                adultoRacaoPreco = racao.preco_Saca;
                adultoPesoSaca = racao.pesoCadaSaca;
                break;
            default:
                throw new IllegalStateException("Unexpected value: ");
        }
    }
    

    public void adicionaRacaoTotal( String tipo, I_Fase fase){
        switch (tipo){
            case "LARVA":
                Racao_Tempo.larvaRacao +=  fase.getRacaoTotal();
                break;
            case "ALEVINO":
                Racao_Tempo.alevinoRacao += fase.getRacaoTotal() ;
                break;
            case "JUVENIL":
                Racao_Tempo.juvenilRacao += fase.getRacaoTotal();
                break;
            case "ADULTO":
                Racao_Tempo.adultoRacao += fase.getRacaoTotal();
                break;
        }
    }
}
