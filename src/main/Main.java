package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Financiamento> financiamentos = new ArrayList<Financiamento>();

        for (int i = 0; i < 1; i++) {

            System.out.println("Qual tipo de financiamento você deseja?\n" +
                    "1 - Casa\n" +
                    "2 - Apartamento\n" +
                    "3 - Terreno\n");
            var entradaUsuario = sc.nextInt();
            sc.nextLine();

            if (entradaUsuario == 1) {
                System.out.println("\nDigite os dados do " + (i + 1) + "º financiamento do terreno:");

                double valorDoImovel = InterfaceUsuario.valorImovel();
                int prazo = InterfaceUsuario.prazoFinanciamento();
                double taxa = InterfaceUsuario.taxaJuros();
                int areaConstruida = InterfaceUsuario.areaConstruida();
                int tamanhoTerreno = InterfaceUsuario.medidaTerreno();

                Financiamento financiamento = new Casa(valorDoImovel, prazo, taxa, areaConstruida, tamanhoTerreno);
                financiamento.exibirMensagem();
                financiamentos.add(financiamento);
            }

            if (entradaUsuario == 2) {
                double valorDoImovel = InterfaceUsuario.valorImovel();
                int prazo = InterfaceUsuario.prazoFinanciamento();
                double taxa = InterfaceUsuario.taxaJuros();
                int vagaGaragem = InterfaceUsuario.vagasGaragem();
                int numeroAndar = InterfaceUsuario.andarApartamento();

                Financiamento financiamento = new Apartamento(valorDoImovel, prazo, taxa, vagaGaragem, numeroAndar);

                financiamento.exibirMensagem();
                financiamentos.add(financiamento);

            }

            if (entradaUsuario == 3) {
                System.out.println("\nDigite os dados do " + (i + 1) + "º financiamento do terreno:");

                double valorDoImovel = InterfaceUsuario.valorImovel();
                int prazo = InterfaceUsuario.prazoFinanciamento();
                double taxa = InterfaceUsuario.taxaJuros();
                String tipoTerreno = InterfaceUsuario.tipoZona();

                Financiamento financiamento = new Terreno(valorDoImovel, prazo, taxa, tipoTerreno);
                financiamento.exibirMensagem();
                financiamentos.add(financiamento);
            }
        }

        financiamentos.add(new Casa(150000, 20, 10, 50, 80));
        financiamentos.add(new Casa(180000, 15, 12, 100, 80));
        financiamentos.add(new Apartamento(250000, 25, 9, 2, 6));
        financiamentos.add(new Apartamento(320000, 30, 11, 1, 3));

        FileWriter fw = null;

        try {
            fw = new FileWriter("financiamentos.txt");

            for (Financiamento financiamento : financiamentos) {
                fw.write(financiamento.toString() + System.lineSeparator());
            }

            fw.flush();
            fw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileReader fr = null;

        try {
            fr = new FileReader("financiamentos.txt");
            int c;

            while ((c = fr.read()) != -1)
                System.out.print((char)c);
            fr.close();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("financiamentos.test"));
            outputStream.writeObject(financiamentos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream("financiamentos.test"));

            ArrayList <Financiamento> financiamentosLidosArquivo = (ArrayList<Financiamento>) inputStream.readObject();

            for (Financiamento financiamento : financiamentosLidosArquivo) {
                System.out.println(financiamento);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        int i = 1;
//
//        System.out.println("-".repeat(25)+ "\nLista de financiamentos\n" + "-".repeat(25));
//        for (var f : financiamentos) {
//            System.out.println("Financiamento " + i + ": ");
//            f.exibirMensagem();
//            i++;
//        }
//
//        double somaImovel = 0;
//        double somaFinanciamento = 0;
//
//        for (var f : financiamentos) {
//            somaImovel += f.getValorImovel();
//            somaFinanciamento += f.valorTotal();
//        }
//
//        System.out.println("Valor total dos imóveis: " + String.format("%.2f", somaImovel) +
//                "\nValor total dos financiamentos: " + String.format("%.2f", somaFinanciamento));
   }
}