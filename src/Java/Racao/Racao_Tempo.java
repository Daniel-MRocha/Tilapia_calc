package Java.Racao;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Racao_Tempo {

    //Variaveis estáticas
    public static int cicloTotalDeDias = 0;
    public static double investimentoAproximado = 0.0;

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
    private int sacas;
    private int pesoCadaSaca;
    private double pesoTotal;
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

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
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

        int sacasEstimadas = (int) ((pesoTotal%pesoCadaSaca==0)?pesoTotal/pesoCadaSaca:((pesoTotal/pesoCadaSaca)+1));
        investimentoAproximado = investimentoAproximado + (preco_Saca * sacasEstimadas);

        resultado.append("Sacas estimadas : " + sacasEstimadas + "\n");
        resultado.append("Investimento nesta fase : " + dc.format(preco_Saca * sacasEstimadas ) +"\n");
        resultado.append("Data de ínicio da fase : " + dataInicioFase.format(dtf)+"\n");
        resultado.append("Data de final da fase : " + dataFinalFase.format(dtf)+"\n\n");

        dataInicio = dataFinalFase;

        return resultado;
    }

    public static void carregaConstantesRacao(Racao_Tempo racao){
        switch (racao.getRacaoTipo()){
            case "LARVA":
                larvaRacaoPreco = racao.preco_Saca;
                larvaPesoSaca = racao.pesoCadaSaca;
                larvaRacao += racao.pesoTotal;
                break;
            case "ALEVINO":
                alevinoRacaoPreco = racao.preco_Saca;
                alevinoPesoSaca = racao.pesoCadaSaca;
                alevinoRacao += racao.pesoTotal;
                break;
            case "JUVENIL":
                juvenilRacaoPreco = racao.preco_Saca;
                juvenilPesoSaca = racao.pesoCadaSaca;
                juvenilRacao += racao.pesoTotal;
                break;
            case "ADULTO":
                adultoRacaoPreco = racao.preco_Saca;
                adultoPesoSaca = racao.pesoCadaSaca;
                adultoRacao += racao.pesoTotal;
                break;
            default:
                throw new IllegalStateException("Unexpected value: ");
        }
    }
}
