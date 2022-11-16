/**
 * Examen16112022.java
 *
 * @version: 16/11/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */
/*
 * Simulación examen 16/11/2022
 */

import java.util.Scanner;

public class Examen16112022 {
    public static void main(String[] args) {
        // Var declarations
        int height;
        String text;
        float longitud;

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Input data
        height = 0;
        longitud = 0;

        /* ************************************************ */
        do {
            System.out.println("Escribe el mensaje que quieres enviar:");
            text = sc.nextLine();
            longitud = text.length();
            height = (int) ((longitud + 4) / 2);

            if (text.length() < 5)
                System.out.println("Debes introducir un texto mayor de 5 caracteres");
        } while (text.length() < 5);

        if (longitud % 4 == 2 || longitud % 4 == 3)
            height++;
        if (height % 2 == 0)
            height++;

        /* ************************************************ */
        System.out.println("\n\n\nPrimera parte\n");
        // Pintamos el cuadrado
        // Primera línea
        for (int i = 0; i < height; i++) {
            System.out.print("* ");
        }
        System.out.println();

        // bloque central
        for (int i = 1; i < height - 1; i++) {
            for (int j = 0; j < height; j++) {
                if (j == 0 || j == height - 1)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }

        // última línea
        for (int i = 0; i < height; i++)
            System.out.print("* ");

        /* ************************************************ */
        System.out.println("\n\n\nSegunda parte\n");
        // Pintamos el cuadrado
        // Primera línea
        for (int i = 0; i < height; i++)
            System.out.print("* ");

        System.out.println();

        // bloque central
        for (int i = 1; i < height - 1; i++) {
            System.out.print("* ");
            for (int j = 1; j < height - 1; j++) {
                if (j == i || height - i - 1 == j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println("*");
        }

        // última línea
        for (int i = 0; i < height; i++)
            System.out.print("* ");

        /* ************************************************ */
        System.out.println("\n\n\nTercera parte\n");
        // Pintamos el cuadrado
        // Primera línea
        for (int i = 0; i < height; i++)
            System.out.print("* ");
        System.out.println();

        // bloque central
        for (int i = 1; i < (height + 1) / 2; i++) {
            System.out.print("* ");
            for (int j = 1; j < height - 1; j++) {
                if (j == i || height - i - 1 == j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println("*");
        }
        // Línea intermedia
        for (int i = 0; i < height; i++)
            System.out.print("* ");
        System.out.println();

        // Línea mensaje
        System.out.print("* ");
        for (int i = 1; i < height - 1; i++)
            System.out.print("  ");
        System.out.println("*");

        // Línea final
        for (int i = 0; i < height; i++)
            System.out.print("* ");

        /* ************************************************ */
        System.out.println("\n\n\nCuarta parte\n");
        // Pintamos el cuadrado
        // Primera línea
        for (int i = 0; i < height; i++)
            System.out.print("* ");
        System.out.println();

        // bloque central
        for (int i = 1; i < (height + 1) / 2; i++) {
            System.out.print("* ");
            for (int j = 1; j < height - 1; j++) {
                if (j == i || height - i - 1 == j)
                    System.out.print("* ");
                else
                    System.out.print("  ");
            }
            System.out.println("*");
        }
        // Línea intermedia
        for (int i = 0; i < height; i++)
            System.out.print("* ");
        System.out.println();

        // Línea mensaje
        System.out.print("* ");
        switch ((int) longitud % 4) {
            case 2:
            case 3:
                System.out.print(" ");
                break;
        }
        System.out.print(text);
        switch ((int) longitud % 4) {
            case 0:
            case 3:
                System.out.print(" ");
                break;
            case 2:
                System.out.print("  ");
                break;
        }
        System.out.println(" *");

        // Línea final
        for (int i = 0; i < height; i++)
            System.out.print("* ");

        // Close scanner
        sc.close();
    }
}