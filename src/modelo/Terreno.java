package modelo;

public class Terreno extends Financiamento{

    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        this.tipoZona = tipoZona;
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double valorMensalidade() {
        return (getValorImovel() / quantidadeParcelas()* (1 + (getTaxaJurosAnual() / 12))) * 1.02;
    }

    @Override
    public void exibirMensagem(){
        System.out.println("Valor do terreno : " + String.format("%.2f", getValorImovel()) +
                "\nValor da parcela : " + String.format("%.2f", valorMensalidade()) +
                "\nQuantidade de parcelas : " + quantidadeParcelas() +
                "\nValor total financiamento : " + String.format("%.2f", valorTotal()) + "\n");
    }
}
