package modelo;

public class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public int quantidadeParcelas() {
        return prazoFinanciamento * 12;
    }

    public double valorMensalidade() {
        return (valorImovel / quantidadeParcelas()) * (1 + (taxaJurosAnual / 12));
    }

    public double valorTotal(){
        return valorMensalidade() * quantidadeParcelas();
    }

    public void exibirMensagem(){
        System.out.println("Valor do imóvel : " + String.format("%.2f", valorImovel) +
                "\nValor da parcela : " + String.format("%.2f", valorMensalidade()) +
                "\nQuantidade de parcelas : " + quantidadeParcelas() +
                "\nValor total financiamento : " + String.format("%.2f", valorTotal()) + "\n");
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }
}
