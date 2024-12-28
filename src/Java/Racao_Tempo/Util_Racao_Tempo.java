package Java.Racao_Tempo;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Util_Racao_Tempo {

    public static int cicloTotalDeDias = 0;
    public static double investimentoAproximado = 0.0;

    private String empresa;
    private String tipo;
    private double preco_Saca;
    private int sacas;
    private int pesoCadaSaca;
    private double pesoTotal;
    private LocalDate dataInicioFase;
    private LocalDate dataFinalFase;

    public Util_Racao_Tempo(String empresa,String tipo,double preco_Saca,int pesoCadaSaca,double pesoTotal,LocalDate dataInicioFase,int dias){
        this.empresa = empresa;
        this.tipo= tipo;
        this.preco_Saca = preco_Saca;
        this.pesoCadaSaca = pesoCadaSaca;
        this.pesoTotal= pesoTotal;
        this.dataInicioFase = dataInicioFase;
        this.dataFinalFase = dataInicioFase.plus(dias,ChronoUnit.DAYS);
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

        return resultado;
    }
}
