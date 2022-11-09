
/**
 * Exercise: Examen condicionales
 * 
 * @version: 09/11/2022 10:27
 * @author: Juan Manuel Gutiérrez Mellado
 *          https://github.com/Juanma-Gutierrez
 */

import java.util.Scanner;

public class ExamenCondicionales {
    public static void main(String[] args) {
        // Var declarations
        int item;
        int food;
        int cant;
        double price;
        String name;
        int porcIva;
        float iva;
        int porcDiscount;
        float discount;
        float discount3x2;
        boolean valid;
        double total;
        double totalWithIva;

        // Var init
        item = 0;
        food = 0;
        cant = 0;
        price = 0;
        name = "";
        porcIva = 0;
        iva = 0;
        porcDiscount = 0;
        discount = 0;
        discount3x2 = 0;
        valid = true;
        total = 0;
        totalWithIva = 0;

        // Scanner class
        Scanner sc = new Scanner(System.in);

        // Input data
        System.out.println("Introduzca el tipo de producto:");
        System.out.println("1. Alimentación");
        System.out.println("2. Electrónica");
        System.out.println("3. Farmacia");
        System.out.println("4. Moda");
        System.out.print("Opción: ");
        item = sc.nextInt();

        // Comprobamos que se introduzca un valor correcto
        if (item < 1 || item > 4)
            valid = false;

        if (valid) {
            switch (item) {
                // Alimentación
                case 1:
                    System.out.println("Introduzca el tipo de alimento");
                    System.out.println("1. Huevos");
                    System.out.println("2. Leche");
                    // no hay alimento nº 3 en el enuciado del ejercicio
                    System.out.println("4. Pan");
                    System.out.println("5. Fruta");
                    System.out.println("6. Verdura");
                    System.out.println("7. Otros");
                    System.out.print("Opción: ");
                    food = sc.nextInt();

                    // Asignamos el valor del IVA
                    if (food == 7)
                        porcIva = 10;
                    else
                        porcIva = 4;

                    // Comprobamos el valor introducido para alimento
                    if (food < 1 || food > 7)
                        valid = false;
                    break;

                // Electrónica
                case 2:
                    // Asignamos valor al IVA y al descuento
                    porcDiscount = 20;
                    porcIva = 21;
                    break;

                // Farmacia
                case 3:
                    // Asignamos valor al IVA
                    porcIva = 4;
                    break;

                // Moda
                case 4:
                    // Asignamos valor al IVA
                    porcIva = 21;
                    break;
            }

        }

        if (valid) {
            // Pedimos el nombre del producto
            System.out.print("Introduzca el nombre del producto: ");
            name = sc.nextLine();
            // Repito asignación para que funcione correctamente
            name = sc.nextLine();
            
            // Pedimos la cantidad
            System.out.print("Introduzca la cantidad de productos: ");
            cant = sc.nextInt();

            // Pedimos el precio por producto
            System.out.print("Introduzca el precio por unidad del producto: ");
            price = sc.nextFloat();

            // Output data
            // Inserto E en lugar del símbolo euro porque la consola no muestra el carácter
            System.out.printf("\n\nFactura");
            System.out.printf("\n________________________________________");
            System.out.printf("\n%-15s%25s", "Artículo", name);
            System.out.printf("\n%-15s%16.2f E/unidad", "Precio", price);
            System.out.printf("\n%-15s%25d", "Cantidad", cant);
            total = price * cant;
            System.out.printf("\n%-15s%24.2fE", "Total", total);

            // Process option moda (3x2)
            if (item == 4 && cant >= 3) {
                discount3x2 = (int) cant / 3;
                discount3x2 *= price * (-1);
                System.out.printf("\nDescuento (3x2)%24.2fE", discount3x2);
                total += discount3x2;
                System.out.printf("\nTotal con descuento%20.2fE", total);
            }

            // Process descuento
            if (porcDiscount != 0) {
                discount = (float) total * porcDiscount * -1 / 100;
                System.out.printf("\nDescuento (%2d%1s)%24.2fE", porcDiscount, "%", discount);
                total += discount;
                System.out.printf("\nTotal con descuento%20.2fE", total);
            }

            // IVA
            iva = (float) (total * porcIva / 100);
            System.out.printf("\n%-7s%2d%1s%29.2fE", "IVA al ", porcIva, "%", iva);
            System.out.printf("\n________________________________________");

            // Total
            totalWithIva = total + iva;
            System.out.printf("\nTotal con IVA%26.2fE", totalWithIva);
        } else
            System.out.println("Ha introducido un tipo de producto no válido");

        // Close scanner
        sc.close();
    }

}
