package com.mycompany.app;

import java.util.Scanner;

public class App {

    private static final char[] operations = {'+','-','*','/'};
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        boolean again = true;

        while (again) {
            System.out.println("Resultat : " + calculate());
            System.out.println("Again ? (Y/N)");
            again = scanner.nextLine().equals("Y");
        }
    }

    private static double calculate() {
        System.out.println("Enter first number : ");
        int firstNb = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter operation :");
        char op = scanner.nextLine().charAt(0);
        System.out.println("Enter second number :");
        int secondNb = Integer.parseInt(scanner.nextLine());

        String err = validateEntrees(firstNb, op, secondNb);

        if (!err.equals("")) {
            System.out.println(err);
            calculate();
        };

        switch(op) {
            case '+' :
                return firstNb + secondNb;
            case '-' :
                return firstNb - secondNb;
            case '*' :
                return firstNb * secondNb;
            case '/' :
                return (double) firstNb / (double) secondNb;
        }
        return 0;
    }

    private static String validateEntrees(int firstNb, char op, int secondNb) {
        char finalOp = ' ';
        String err = "";

        for (char operation : operations) if (operation == op) finalOp = operation;
        if (finalOp == ' ') return "ERREUR : Il n'y a pas d'opérateur valide \n";
        if(finalOp == '/' && Math.abs(secondNb) < Double.MIN_VALUE) return "ERREUR : Division par zéro \n";
        return "";
    }
}
