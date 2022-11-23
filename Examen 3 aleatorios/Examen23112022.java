
/**
 * Examen23112022.java
 *
 * @version: 23/11/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

import java.util.Scanner;

public class Examen23112022 {
    public static void main(String[] args) {
        // Var declarations
        int play;
        int minPlayerInterval;
        int maxPlayerInterval;
        int minInterval;
        int maxInterval;
        int intentos;
        int num;
        int numFinal;
        boolean win;

        // Scanner class
        Scanner sc = new Scanner(System.in);

        System.out.println("-A-L-E-A-T-O-R-I-U-M-");
        System.out.println("Aleatorium pensará un número entre los valores que tu decidas");

        // Solicitamos el rango al usuario
        System.out.print("\nIntroduzca el mínimo valor del intervalo: ");
        minPlayerInterval = sc.nextInt();
        do {
            System.out.print("Introduzca el máximo valor del intervalo: ");
            maxPlayerInterval = sc.nextInt();
            if (maxPlayerInterval <= minPlayerInterval)
                System.out.println(maxPlayerInterval
                        + " no es un número de intervalo correcto, debe ser mayor que  " + minPlayerInterval);
        } while (maxPlayerInterval <= minPlayerInterval);

        // Bucle general del proceso de juego
        do {
            win = false;

            // Generamos el nuevo rango interior
            do {
                minInterval = (int) (Math.random() * ((maxPlayerInterval - minPlayerInterval) + 1)) + minPlayerInterval;
                maxInterval = (int) (Math.random() * ((maxPlayerInterval - minPlayerInterval) + 1)) + minPlayerInterval;
            } while (maxInterval <= minInterval);

            // Mostramos el intervalo
            System.out.println("\n-A-L-E-A-T-O-R-I-U-M-");
            System.out.printf("Estoy pensando en un número entre %d y %d\n", minInterval, maxInterval);

            // Calculamos el número a buscar y el número de intentos y lo mostramos
            numFinal = (int) (Math.random() * ((maxInterval - minInterval) + 1)) + minInterval;
            intentos = (int) (Math.log(maxInterval - minInterval + 1) / Math.log(2));
            System.out.println("Tienes " + intentos + " intentos\n");

            // Juego del jugador
            do {
                System.out.print("Escribe el número: ");
                num = sc.nextInt();
                if (num > numFinal)
                    System.out.println("Te has pasado");
                else if (num < numFinal)
                    System.out.println("Te has quedado corto");
                else
                    win = true;
            } while (--intentos > 0 && !win);

            // Mostramos mensaje de victoria o derrota
            System.out.println();
            if (win) {
                System.out.println("Enhorabuena!!!! has acertado.");
                System.out.printf("Efectivamente, el número era: %d\n", numFinal);
            } else {
                System.out.println("Has superado el número de intentos");
                System.out.printf("El número que había pensado era: %d\n", numFinal);
            }

            // Preguntamos si quiere seguir jugando
            System.out.println("\nElige una opción");
            System.out.println("1. Volver a jugar");
            System.out.println("2. Salir del juego");
            do {
                play = sc.nextInt();
                if (play != 1 && play != 2)
                    System.out.print("Por favor, introduce una opción correcta (1/2): ");
            } while (play != 1 && play != 2);
        } while (play != 2);

        System.out.println("\nGracias por jugar a -A-L-E-A-T-O-R-I-U-M-\n");
        // Close scanner
        sc.close();
    }

}
