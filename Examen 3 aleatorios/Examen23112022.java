
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
        String play;
        int minPlayerInterval;
        int maxPlayerInterval;
        int minInterval;
        int maxInterval;
        int num;

        // Var init
        play = "";

        // Scanner class
        Scanner sc = new Scanner(System.in);

        System.out.println("-A-L-E-A-T-O-R-I-U-M-");
        System.out.println("Aleatorium pensará un número entre los valores que tu decidas");
        do {
            // Solicitamos el rango al usuario
            System.out.print("Introduzca el mínimo valor del intervalo: ");
            minPlayerInterval = sc.nextInt();
            do {
                System.out.print("Introduzca el máximo valor del intervalo: ");
                maxPlayerInterval = sc.nextInt();
                if (maxPlayerInterval <= minPlayerInterval)
                    System.out.println(maxPlayerInterval
                            + " no es un número de intervalo correcto, debe ser mayor que  " + minPlayerInterval);
            } while (maxPlayerInterval <= minPlayerInterval);

            // Generamos el nuevo rango interior
            do {
                minInterval = (int) (Math.random() * ((maxPlayerInterval - minPlayerInterval) + 1)) + minPlayerInterval;
                maxInterval = (int) (Math.random() * ((maxPlayerInterval - minPlayerInterval) + 1)) + minPlayerInterval;
            } while (maxInterval <= minInterval);

            // Mostramos el intervalo
            System.out.println("-A-L-E-A-T-O-R-I-U-M-");
            System.out.printf("Estoy pensando en un número entre %d y %d", minInterval, maxInterval);

            // Preguntamos si quiere seguir jugando
            System.out.print("\n¿Quiéres seguir jugando (s para continuar):");
            sc.nextLine();
            play = sc.next();
        } while (play.equals("s") || play.equals("S"));
        // Close scanner
        sc.close();
    }

}
