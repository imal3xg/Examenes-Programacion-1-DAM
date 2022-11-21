
/**
 * Examen21112022.java
 *
 * @version: 21/11/2022
 * @author: Juan Manuel Gutiérrez
 *          https://github.com/Juanma-Gutierrez
 */

import java.util.Scanner;


public class Examen21112022 {
    public static void main(String[] args) {
        // Var declarations
        long num;
        long aux;
        long lon;
        long numAux;
        long rotated;
        long rotatedAux;
        long res;
        int max;

        // Var init;
        lon = 0;
        numAux = 0;
        rotated = 0;
        max = 0;

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Input data
        do {
            System.out.print("Intruduzca un número: ");
            num = sc.nextLong();
            if (num <= 0)
                System.out.println("Número erroneo, debe ser mayor que 0");
        } while (num <= 0);

        // Calcular longitud del número
        aux = num;
        do {
            lon++;
            aux /= 10;
        } while (aux > 0);

        // Rotar número
        aux = num;
        do {
            rotated *= 10;
            rotated += aux % 10;
            aux /= 10;
        } while (aux > 0);

        // Output data
        // Primera línea
        for (int i = 0; i < lon; i++)
            System.out.print("----");
        System.out.println("-");

        // Segunda línea cabecera de números
        rotatedAux = rotated;
        for (int i = 0; i < lon; i++) {
            numAux = rotatedAux % 10;
            if (numAux > max)
                max = (int) numAux;
            rotatedAux /= 10;
            System.out.print("| " + numAux + " ");
        }
        System.out.println("|");

        // Tercera línea
        for (int i = 0; i < lon; i++)
            System.out.print("----");
        System.out.println("-");

        // Gráfica
        for (int i = 0; i < max; i++) {
            numAux = rotated;
            for (int j = 0; j < lon; j++) {
                res =  numAux % 10;
                if (res > i)
                    System.out.print("| * ");
                else
                    System.out.print("|   ");
                numAux /= 10;
            }
            System.out.println("|");
        }

        // esta línea hay que borrarla
        System.out.println("longitud: " + lon);
        System.out.println("rotated: " + rotated);
        System.out.println("máximo: " + max);
        // Close Scanner
        sc.close();
    }
}
