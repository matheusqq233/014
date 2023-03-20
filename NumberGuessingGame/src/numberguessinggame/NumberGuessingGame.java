/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numberguessinggame;

import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxTries = 10;
        int randomNumber = random.nextInt(10) + 1;
        System.out.println("Welcome to the number guessing game!");
        System.out.println("You have " + maxTries + " tries to guess a number between 1 and 10.");

        for (int i = 1; i <= maxTries; i++) {
            System.out.print("Guess #" + i + ": ");
            int guess = scanner.nextInt();

            if (guess == randomNumber) {
                System.out.println("Congratulations, you guessed the number!");
                return;
            } else if (i == maxTries) {
                System.out.println("Sorry, you're out of tries. The number was " + randomNumber + ".");
            } else {
                System.out.println("Sorry, that's not the number. Try again.");
            }
        }
    }
}

