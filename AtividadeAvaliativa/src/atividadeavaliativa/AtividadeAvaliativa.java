package atividadeavaliativa;

import java.util.Random;
import java.util.Scanner;
public class AtividadeAvaliativa {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxTentativas = 20; // maximum number of tries
        int aleatorio = random.nextInt(1000) + 1; // random number between 1 and 100
        int numeroDeTentativas = 0;
        int resposta;

        System.out.println("Adivinhe um numero de 1 a 1000, você tem " + maxTentativas + " tentativas!");

        while (numeroDeTentativas < maxTentativas) {
            System.out.print("Resposta #" + (numeroDeTentativas + 1) + ": ");
            resposta = scanner.nextInt();
            numeroDeTentativas++;

            if (resposta < aleatorio) {
                System.out.println("Muito baixo!");
            } else if (resposta > aleatorio) {
                System.out.println("Muito Alto!");
            } else {
                System.out.println("Parabéns, você acertou o numero em  " + numeroDeTentativas + " tentativas!");
                return;
            }
        }

        System.out.println("Você errou. o número era:  " + aleatorio + ".");
    }
}