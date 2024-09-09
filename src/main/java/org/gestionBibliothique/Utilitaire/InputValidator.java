package org.gestionBibliothique.Utilitaire;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {


    private static Scanner scanner = new Scanner(System.in);


    public static int getIntInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (Pattern.matches("\\d+", input)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Entrée invalide. Veuillez entrer un nombre entier.");
            }
        }
    }

    public static String getStringInput(String prompt) {
        while (true) {
            System.out.println(prompt);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;

            } else {
                System.out.println("L'entrée ne peut pas être vide.");
            }
        }
    }
}
