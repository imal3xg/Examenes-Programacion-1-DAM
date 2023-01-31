import java.util.Scanner;

import eticket.NotEnoughStock;
import eticket.Product;
import eticket.ProductDoesNotExists;
import eticket.Stock;
import eticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
public class ETicket1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Product> products_map = new HashMap<Integer, Product>();
        Product product = new Product("Levis", "A123456", "Levis 501", 79.95);
        products_map.put(product.getCode(), product);
        product = new Product("Zara", "B123456", "Camisa strech fit", 49.95);
        products_map.put(product.getCode(), product);
        product = new Product("Martinelli", "C123456", "Zapato caballero piel", 99.95);
        products_map.put(product.getCode(), product);
        boolean salir = false;
        do {
            System.out.println("<><><><><><><><><><><><><><><>");
            System.out.println("<><><><><> E-Ticket <><><><><>");
            System.out.println("<><><><><><><><><><><><><><><>");
            System.out.println("1. Gestión de Productos");
            System.out.println("4. Salir");
            int option = Integer.parseInt(sc.nextLine());
            switch (option) {
                case 1:
                    System.out.println("<><><><><><><><><><><><><><><>");
                    System.out.println("<><><><><> E-Ticket <><><><><>");
                    System.out.println("<><><><><><><><><><><><><><><>");
                    System.out.println("1. Añadir producto");
                    System.out.println("2. Listar productos");
                    int option1 = Integer.parseInt(sc.nextLine());
                    switch (option1) {
                        case 1:
                            System.out.println("Introduzca la marca del producto: ");
                            String brand = sc.nextLine();
                            System.out.println("Introduzca el modelo del producto: ");
                            String model = sc.nextLine();
                            System.out.println("Introduzca el nombre comercial: ");
                            String name = sc.nextLine();
                            System.out.println("Introduzca el precio de venta: ");
                            double price = Double.parseDouble(sc.nextLine());
                            product = new Product(brand, model, name, price);
                            products_map.put(product.getCode(), product);
                            break;
                        case 2:
                            System.out.println("**********************************");
                            for(Product p:products_map.values()){
                                System.out.println(p);
                                System.out.println("**********************************");
                            }
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
                case 4:
                    salir=true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }    
        } while (!salir);

        sc.close();
        
    }
}
