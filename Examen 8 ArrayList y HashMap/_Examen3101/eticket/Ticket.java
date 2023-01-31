package eticket;

/**Ticket
 * Mantiene información de un Ticket de compra
 * Debe almacenar el código del ticket que se genera automáticamente
 * empezando en 1, la fecha del ticket y las compras realizadas
 * Para facilitar las cosas se te indica como debe manejar los productos
 * del ticket haciendo uso de un HashMap (Obviamente debes haber implementado
 * la clase TicketLine antes que esta)
 * Debe poder:
 * - Obtener la fecha del ticket
 * - Obtener el código del ticket
 * - Añadir una cantidad de un producto determinado a la compra
 * - Quitar una cantidad de un producto determinado de la compra
 *   Si no existe el producto debe lanzar una excepción (ProductDoesNotExists)
 *   Si la cantidad de productos a retirar de un producto es mayor a la 
 *   que existe en el ticket debe lanzar una excepción (NotEnoughStock)
 * - Obtener el total de la factura de la compra
 * - Imprimir el ticket de la siguiente manera:
 *                                       Levis 501 ( 1 x      79,95 € ) =      79,95 €
 *                               Camisa strech fit ( 2 x      49,95 € ) =      99,90 €
 *                           Zapato caballero piel ( 3 x      99,95 € ) =     299,85 €
 *                                           Total 479,70 €
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

public class Ticket {
    private HashMap<Product, TicketLine> purchase = new HashMap<Product, TicketLine>();
    private static int generalCode = 1;
    private int code;
    private Date date;

    public Ticket() {
        this.date = new Date();
        this.code = generalCode++;
    }

    public int getCode() {
        return code;
    }

    public Date getDate() {
        return date;
    }

    public Product add(Product p, int amount) {
        if (purchase.containsKey(p))
            purchase.put(p, new TicketLine(p, purchase.get(p).getAmount() + amount));
        else
            purchase.put(p, new TicketLine(p, amount));
        return p;
    }

    public Product remove(Product p, int amount) throws NotEnoughStock, ProductDoesNotExists {
        if (!purchase.containsKey(p))
            throw new ProductDoesNotExists();
        else if (amount > purchase.get(p).getAmount())
            throw new NotEnoughStock();
        else
            purchase.put(p, new TicketLine(p, purchase.get(p).getAmount() - amount));
        return p;
    }

    @Override
    public String toString() {
        double total = 0;
        String res = String.format("Número de ticket: %-30d Fecha: %s\n", code, date);
        res +="\n--------------------------------------------------------------------------------------\n";
        for (Map.Entry<Product, TicketLine> p : purchase.entrySet()) {
            res += p.getValue() + "\n";
            total += p.getValue().getTotalPrice();
        }
        res +="--------------------------------------------------------------------------------------\n";
        res += String.format(" Total: %.2f €", total);
        return res;
    }

}
