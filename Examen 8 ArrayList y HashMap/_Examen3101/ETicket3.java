import java.util.Scanner;

import eticket.NotEnoughStock;
import eticket.Product;
import eticket.ProductDoesNotExists;
import eticket.Stock;
import eticket.Ticket;

import java.util.ArrayList;
import java.util.HashMap;
public class ETicket3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stock stock = new Stock();
        HashMap<Integer, Product> products_map = new HashMap<Integer, Product>();
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        Product product = new Product("Levis", "A123456", "Levis 501", 79.95);
        products_map.put(product.getCode(), product);
        product = new Product("Zara", "B123456", "Camisa strech fit", 49.95);
        products_map.put(product.getCode(), product);
        product = new Product("Martinelli", "C123456", "Zapato caballero piel", 99.95);
        products_map.put(product.getCode(), product);
        

        stock.addProduct(products_map.get(1), 10);
        stock.addProduct(products_map.get(2), 10);
        stock.addProduct(products_map.get(3), 10);
        boolean salir = false;
        do {
            System.out.println("<><><><><><><><><><><><><><><>");
            System.out.println("<><><><><> E-Ticket <><><><><>");
            System.out.println("<><><><><><><><><><><><><><><>");
            System.out.println("1. Gestión de Productos");
            System.out.println("2. Gestión de Stock");
            System.out.println("3. Nuevo Ticket");
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
                case 2:
                    System.out.println("<><><><><><><><><><><><><><><>");
                    System.out.println("<><><><><> E-Ticket <><><><><>");
                    System.out.println("<><><><><><><><><><><><><><><>");
                    System.out.println("1. Añadir stock");
                    System.out.println("2. Retirar stock");
                    System.out.println("3. Listar stock");
                    int option2 = Integer.parseInt(sc.nextLine());
                    switch (option2) {
                        case 1:
                            {
                                System.out.println("Introduzca el código del producto: ");
                                int code = Integer.parseInt(sc.nextLine());
                                System.out.println("Introduzca la cantidad de productos: ");
                                int amount = Integer.parseInt(sc.nextLine());
                                stock.addProduct(products_map.get(code), amount);
                            }
                            break;
                        case 2:
                            {
                                System.out.println("Introduzca el código del producto: ");
                                int code = Integer.parseInt(sc.nextLine());
                                System.out.println("Introduzca la cantidad de productos: ");
                                int amount = Integer.parseInt(sc.nextLine());
                                try {
                                    stock.allocateProduct(products_map.get(code), amount);    
                                } catch (NotEnoughStock e) {
                                    System.out.println("No hay suficiente stock para retirar");
                                } catch (ProductDoesNotExists e) {
                                    System.out.println("No existe el producto en el stock");
                                }
                            }
                            break;
                        case 3:
                            System.out.println(stock);
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
                case 3:
                    boolean closedTicket = false;
                    Ticket ticket = new Ticket();
                    tickets.add(ticket);
                    do {
                        System.out.println("<><><><><><><><><><><><><><><>");
                        System.out.println("<><><><><> E-Ticket <><><><><>");
                        System.out.println("<><><><><><><><><><><><><><><>");
                        System.out.println("1. Añadir producto a la compra");
                        System.out.println("2. Retirar producto de la compra");
                        System.out.println("3. Imprimir ticket");
                        System.out.println("4. Cerrar ticket");
                        int option3 = Integer.parseInt(sc.nextLine());
                        switch (option3) {
                            case 1:
                                {
                                    System.out.println("Introduzca el código del producto: ");
                                    int code = Integer.parseInt(sc.nextLine());
                                    System.out.println("Introduzca la cantidad de productos: ");
                                    int amount = Integer.parseInt(sc.nextLine());
                                    try {
                                        stock.allocateProduct(products_map.get(code), amount); 
                                        ticket.add(products_map.get(code), amount);   
                                    } catch (NotEnoughStock e) {
                                        System.out.println("No hay suficiente stock para retirar");
                                    } catch (ProductDoesNotExists e) {
                                        System.out.println("No existe el producto en el stock");
                                    }
                                }
                                break;
                            case 2:
                                {
                                    System.out.println("Introduzca el código del producto: ");
                                    int code = Integer.parseInt(sc.nextLine());
                                    System.out.println("Introduzca la cantidad de productos: ");
                                    int amount = Integer.parseInt(sc.nextLine());
                                    try {
                                        ticket.remove(products_map.get(code), amount);   
                                        stock.addProduct(products_map.get(code), amount); 
                                    } catch (NotEnoughStock e) {
                                        System.out.println("No hay suficiente stock para retirar");
                                    } catch (ProductDoesNotExists e) {
                                        System.out.println("No existe el producto en el stock");
                                    }
                                }
                                break;
                            case 3:
                                System.out.println(ticket);
                                break;
                            case 4:
                                closedTicket = true;
                            default:
                                System.out.println("Opción no válida");
                                break;
                        }
                    } while (!closedTicket);
                    
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
