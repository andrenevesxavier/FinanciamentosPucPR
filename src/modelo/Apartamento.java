package modelo;

public class Apartamento extends Financiamento {

    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public double valorTotal() {
        return (getValorImovel()) * (1 + (getTaxaJurosAnual() / 100 * getPrazoFinanciamento()));
    }

    @Override
    public double valorMensalidade() {
        return valorTotal() / (getPrazoFinanciamento() * 12);
    }

    @Override
    public void exibirMensagem() {
        System.out.println("Valor do Apartamento : " + String.format("%.2f", getValorImovel()) +
                "\nValor da parcela : " + String.format("%.2f", valorMensalidade()) +
                "\nQuantidade de parcelas : " + quantidadeParcelas() +
                "\nValor total financiamento : " + String.format("%.2f", valorTotal()) + "\n");
    }

    @Override
    public String toString() {
        return "Valor do apartamento: " + getValorImovel() + "\n"
                + "Prazo: " + getPrazoFinanciamento() + " meses\n"
                + "Taxa de Juros Anual: " + getTaxaJurosAnual() + "%\n"
                + "Vagas garagem: " + vagasGaragem + " vaga(s)\n"
                + "Andar: " + numeroAndar + " andar\n\n";
    }
}
