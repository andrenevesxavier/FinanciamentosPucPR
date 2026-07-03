package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {

    private static Scanner scanner = new Scanner(System.in);
    public static final double LIMITE_LEGAL_ANUAL = 50.0;
    public static final int LIMITE_ANOS_FINANCIAMENTO = 35;

    public static double valorImovel() {

        double valorImovel = 0;
        boolean controle = false;

        while(!controle){
            try {
                System.out.println("\nDigite o valor do imóvel");
                valorImovel = scanner.nextDouble();

                if (valorImovel > 0) {
                    controle = true;
                    System.out.println("Valor do imóvel adicionado com sucesso");
                } else{
                    System.out.println("\nOcorreu um erro, digite um valor positivo");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada invalida, digite um número");
                scanner.nextLine();
            }
        }
    return valorImovel;
    }

    public static int prazoFinanciamento() {

        int prazo = 0;
        boolean controle = false;

        while(!controle){
            try {
                System.out.println("\nDigite o prazo do financiamento");
                prazo = scanner.nextInt();

                if (prazo > LIMITE_ANOS_FINANCIAMENTO) {
                    System.out.println("O limite máximo de anos que um imóvel pode ser financiado no Brasil é de 35 anos, tente novamente");
                }else if (prazo > 0) {
                    controle = true;
                    System.out.println("prazo do financiamento adicionado com sucesso");
                } else{
                    System.out.println("\nOcorreu um erro, digite um valor positivo");
                }
            } catch (InputMismatchException e) {
                System.out.println("\nEntrada invalida, digite um número");
                scanner.nextLine();
            }
        }
        return prazo;
    }


    public static double taxaJuros() {

        double taxa = 0;
        boolean controle = false;

        while(!controle){
            try {
                System.out.println("\nDigite a taxa de Juros (taxa anual)");
                taxa = scanner.nextDouble();

                if (taxa > LIMITE_LEGAL_ANUAL) {
                    System.out.println("Taxa excede o limite permitido (Limite permitido = 50% ao ano)");

                }else if (taxa >= 0) {
                    controle = true;
                    System.out.println("\ntaxa adicionada com sucesso\n");

                } else{
                    System.out.println("\nOcorreu um erro, digite um valor positivo");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada invalida, digite um número");
                scanner.nextLine();
            }
        }
        return taxa;
    }
}

