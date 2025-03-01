import java.util.Scanner;
import java.util.Locale;

public class Main {
    static String nome;
    static double imc;

    public static void main(String[] args) {
        CalcularImc();
        ExibirImc();
    }

    public static void CalcularImc() {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Digite seu Nome: ");
        nome = scanner.nextLine();

        while (nome.trim().isEmpty()) {
            System.out.println("Nome NÃO pode estar vazio.");
            System.out.print("Digite Seu Nome: ");
            nome = scanner.nextLine();
        }
        double altura = 0;
        boolean entradaValidaAltura = false;
        while (!entradaValidaAltura) {
            System.out.print("Digite Sua Altura: ");
            if (scanner.hasNextDouble()) {
                altura = scanner.nextDouble();
                if (altura > 1.00) {
                    entradaValidaAltura = true;
                } else {
                    System.out.println("A Altura Deve Ser Maior que 1.00M, Tente Novamente.");
                }
            } else {
                System.out.println("Por Favor,Digite um número VÁLIDO para a altura.");
                scanner.next();
            }

        }
        double peso = 0;
        boolean entradaValidaPeso = false;
        while (!entradaValidaPeso){
            System.out.print("Digite Seu Peso: ");
            if (scanner.hasNextDouble()){
                peso = scanner.nextDouble();
                if (peso > 0){
                    entradaValidaPeso = true;
                }
                else {
                    System.out.println("O Peso Deve Ser Maior que 0,Tente Novamente.");
                }
            }
            else {
                System.out.println("Por Favor,digite um número válido para o peso.");
                scanner.next();
                scanner.close();
            }
        }
        imc = peso / (altura * altura);
    }

    public static void ExibirImc () {
            System.out.printf("Olá %s,Seu IMC é: %.2f%n", nome, imc);
            if (imc > 40) {
                System.out.print("Você está em Obesidade Grau 3.");
            } else if (imc >= 35 && imc < 40) {
                System.out.print("Você Esta em Obesidade Grau 2.");
            } else if (imc >= 30 && imc < 35) {
                System.out.print("Você está em Obesidade Grau 1.");
            } else if (imc >= 25 && imc < 30) {
                System.out.print("Você está em Sobrepeso.");
            } else if (imc >= 18.5 && imc < 25) {
                System.out.print("Você está Saudável");
            } else {
                System.out.print("Você Está Abaixo Do Peso.");
            }
        }
    }
