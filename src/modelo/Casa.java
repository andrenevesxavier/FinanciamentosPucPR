package modelo;

public class Casa extends Financiamento {

    private final double TAXA = 240;

    public Casa(int valorImovel , int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    @Override
    public double valorMensalidade() {
        return super.valorMensalidade() + TAXA;
    }

    @Override
    public void exibirMensagem() {
        System.out.println("Valor da casa : " + String.format("%.2f", getValorImovel()) +
                "\nValor da parcela SEM A TAXA : " + String.format("%.2f", super.valorMensalidade()) +
                "\nValor da parcela COM A TAXA : " + String.format("%.2f", valorMensalidade()) +
                "\nQuantidade de parcelas : " + quantidadeParcelas() +
                "\nValor total financiamento : " + String.format("%.2f", valorTotal()) + "\n");
    }
}
