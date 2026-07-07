package modelo;

import Exeptions.AumentoMaiorDoQueJurosException;

public class Casa extends Financiamento {

    private final double TAXA = 240;
    private double valorParcela;
    private int areaConstruida;
    private int dimensaoTerreno;

    public Casa(double valorImovel , int prazoFinanciamento, double taxaJurosAnual, int areaConstruida, int dimensaoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.dimensaoTerreno = dimensaoTerreno;
        this.areaConstruida = areaConstruida;
    }



    @Override
    public double valorMensalidade() {
        var valorParcelaSemJuros = getValorImovel() / quantidadeParcelas();
        valorParcela = valorParcelaSemJuros * (1 + (getTaxaJurosAnual() / 12)) + TAXA;
        var jurosParcela = valorParcela - valorParcelaSemJuros;

        if (jurosParcela / 2 < TAXA){
            throw new AumentoMaiorDoQueJurosException ("A taxa está muito elevada para essa parcela");
        }

        return valorParcela;
    }

    @Override
    public void exibirMensagem() {
        System.out.println("Valor da casa : " + String.format("%.2f", getValorImovel()) +
                "\nValor da parcela SEM A TAXA : " + String.format("%.2f", valorParcela) +
                "\nValor da parcela COM A TAXA : " + String.format("%.2f", valorMensalidade()) +
                "\nQuantidade de parcelas : " + quantidadeParcelas() +
                "\nValor total financiamento : " + String.format("%.2f", valorTotal()) + "\n");
    }

    @Override
    public String toString() {
        return "Valor da casa: " + getValorImovel() + "\n"
                + "Prazo: " + getPrazoFinanciamento() + " meses\n"
                + "Taxa de Juros Anual: " + getTaxaJurosAnual() + "%\n"
                + "Área Construída: " + areaConstruida + " m²\n"
                + "Dimensão do Terreno: " + dimensaoTerreno + " m²\n\n";
    }
}
