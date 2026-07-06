package modelo;

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
        valorParcela = (getValorImovel() / quantidadeParcelas()* (1 + (getTaxaJurosAnual() / 12))) + TAXA;
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
}
