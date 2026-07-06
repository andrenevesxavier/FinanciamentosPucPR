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

    public static int medidaTerreno() {
        int tamanhoTerreno = 0;
        boolean controle = false;

        while(!controle) {
            try {
                System.out.println("\nDigite o tamanho do terreno (em m²");
                tamanhoTerreno = scanner.nextInt();

                if (tamanhoTerreno > 1) {
                    System.out.println("Tamannho do terreno adicionado com sucesso\n");
                    controle = true;

                } else {
                    System.out.println("\nOcorreu um erro, digite novamente\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada invalida, digite um número");
                scanner.nextLine();
            }
        }

        return tamanhoTerreno;
    }

    public static String tipoZona() {

        String tipoLocal = null;
        boolean controle = false;

        while(!controle) {

            try {
                System.out.println("\nDigite o tipo de area onde o terreno fica localizado (residencial ou comercial)");
                tipoLocal = scanner.nextLine();
                controle = true;

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada invalida, Tente novamente");
                scanner.nextLine();
            }
        }
        return tipoLocal;
    }

    public static int areaConstruida() {

        boolean controle = false;
        int areaDeConstrucao = 0;


        while(!controle) {
            try {
                System.out.println("\nDigite o tamanho da área contruída da casa (em m²");
                areaDeConstrucao = scanner.nextInt();

                if (areaDeConstrucao > 1) {
                    System.out.println("Tamannho do terreno adicionado com sucesso\n");
                    controle = true;

                } else {
                    System.out.println("\nOcorreu um erro, digite novamente\n");
                }

            } catch (InputMismatchException e) {
                System.out.println("\nEntrada invalida, digite um número");
                scanner.nextLine();
            }
        }

        return areaDeConstrucao;
    }

    public static int vagasGaragem() {

        int vagasGaragem = 0;
        boolean controle = false;

        while(!controle) {
            try {
                System.out.println("Há quantas vagas de garagem diponíveis do apartamento");
                vagasGaragem = scanner.nextInt();
                scanner.nextLine();

                if (vagasGaragem > 1) {
                    System.out.println("Ok, apartamento com " + vagasGaragem + " vagas de garagem");
                    controle = true;
                } else {
                    System.out.println("\nOcorreu um erro, digite novamente\n");
                }

            }catch (InputMismatchException e){
                System.out.println("\nEntrada invalida, digite um número");
                scanner.nextLine();
            }
        }

        return vagasGaragem;
    }

    public static int andarApartamento() {
        int andarApartamento = 0;
        boolean controle = false;


        while(!controle) {
            try {
                System.out.println("Há quantas vagas de garagem diponíveis do apartamento");
                andarApartamento = scanner.nextInt();
                scanner.nextLine();

                if (andarApartamento > 0) {
                    System.out.println("Ok, apartamento localizado no " + andarApartamento + " andar");
                    controle = true;
                } else {
                    System.out.println("\nOcorreu um erro, digite novamente\n");
                }

            }catch (InputMismatchException e){
                System.out.println("\nEntrada invalida, digite um número");
                scanner.nextLine();
            }
        }
        return andarApartamento;
    }

}

