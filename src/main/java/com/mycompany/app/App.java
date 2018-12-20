package com.mycompany.app;

import java.util.Scanner;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class App {

    private static final char[] operations = {'+','-','*','/'};
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean again = true;

        while (again) {
            log.println("Resultat : " + calculate());
            log.println("Again ? (Y/N)");
            String entry = scanner.nextLine();
            again = entry.equals("Y") || entry.equals("y");
        }
    }

    private static double calculate() {
        log.println("Enter first number : ");
        int firstNb = Integer.parseInt(scanner.nextLine());
        log.println("Enter operation :");
        char op = scanner.nextLine().charAt(0);
        log.println("Enter second number :");
        int secondNb = Integer.parseInt(scanner.nextLine());

        String err = validateEntrees(op, secondNb);

        if (!err.equals("")) {
            log.println(err);
            calculate();
        }

        switch(op) {
            case '+' :
                return (double) firstNb + secondNb;
            case '-' :
                return (double) firstNb - secondNb;
            case '*' :
                return (double) firstNb * secondNb;
            case '/' :
                return (double) firstNb / secondNb;
            default:
                return 0;
        }
    }

    private static String validateEntrees(char op, int secondNb) {
        char finalOp = ' ';
        for (char operation : operations) if (operation == op) finalOp = operation;
        if (finalOp == ' ') return "ERREUR : Il n'y a pas d'opérateur valide \n";
        if(finalOp == '/' && Math.abs(secondNb) < Double.MIN_VALUE) return "ERREUR : Division par zéro \n";
        return "";
    }
}
