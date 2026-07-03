package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        List<Financiamento> financiamentos = new ArrayList<Financiamento>();

        for (int i = 0; i < 1; i++) {

            System.out.println("\nDigite os dados do " + (i + 1) + "º financiamento:");

            double valorDoImovel = InterfaceUsuario.valorImovel();
            int prazo = InterfaceUsuario.prazoFinanciamento();
            double taxa = InterfaceUsuario.taxaJuros();

            Financiamento financiamento = new Terreno(valorDoImovel, prazo, taxa);
            financiamento.exibirMensagem();
            financiamentos.add(financiamento);
        }

        financiamentos.add(new Casa(150000, 20, 10));
        financiamentos.add(new Casa(180000, 15, 12));
        financiamentos.add(new Apartamento(250000, 25, 9));
        financiamentos.add(new Apartamento(320000, 30, 11));


        int i = 1;

        System.out.println("-".repeat(25)+ "\nLista de financiamentos\n" + "-".repeat(25));
        for (var f : financiamentos) {
            System.out.println("Financiamento " + i + ": ");
            f.exibirMensagem();
            i++;
        }

        double somaImovel = 0;
        double somaFinanciamento = 0;

        for (var f : financiamentos) {
            somaImovel += f.getValorImovel();
            somaFinanciamento += f.valorTotal();
        }

        System.out.println("Valor total dos imóveis: " + String.format("%.2f", somaImovel) +
                "\nValor total dos financiamentos: " + String.format("%.2f", somaFinanciamento));
    }
}