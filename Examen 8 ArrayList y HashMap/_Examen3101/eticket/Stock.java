package eticket;

/** Stock
 * Mantiene información sobre el stock de la tienda
 * Para facilitar las cosas se te indica como debe manejar el stock
 * haciendo uso de un HashMap
 * Por cada producto almacenado se tiene información de la cantidad
 * disponible del mismo
 * Debe poder:
 * - Añadir producto y retirar producto del stock
 * - Imprimir el stock de la tienda de la siguiente manera:
 * Ej:
 *    **********************************
 *    Código: 7
 *    Marca: C&A
 *    Modelo: G123456
 *    Nombre comercial: Vestido señora
 *    Precio: 119,95 €
 *    Stock disponible: 10
 *    **********************************
 *    Código: 1
 *    Marca: Levis
 *    Modelo: A123456
 *    Nombre comercial: Levis 501
 *    Precio: 79,95 €
 *    Stock disponible: 10
 * 
 * Al añadir producto recibirá el producto y la cantidad a añadir
 * Al retirar producto recibirá el producto y la cantidad a retirar.
 * Si el producto no existe deberá lanzar una execpción (ProductDoesNotExists)
 * Si no existe suficiente stock para retirar deberá lanzar una excepción (NotEnoughStock)
 * En el caso de que el producto no exista deberá lanzar una excepción
 * indicando de que el producto no existe.
 * En el caso de que no existan suficientes existencias deberá lanzar
 * una excepción indicando de que no hay suficiente stock.
 */
import java.util.HashMap;
import java.util.Map;

public class Stock {
    HashMap<Product, Integer> stock = new HashMap<Product, Integer>();

    public Stock() {
    }

    public Stock(HashMap<Product, Integer> stock) {
        this.stock = stock;
    }

    public Product addProduct(Product p, int units) {
        if (p != null) {
            if (stock.containsKey(p))
                this.stock.put(p, stock.get(p) + units);
            else
                this.stock.put(p, units);
        }
        return p;
    }

    public Product allocateProduct(Product p, int amount) throws NotEnoughStock, ProductDoesNotExists {
        if (!stock.containsKey(p))
            throw new ProductDoesNotExists();
        else if (stock.get(p) < amount)
            throw new NotEnoughStock();
        else
            this.stock.put(p, (stock.get(p) - amount));
        return p;
    }

    @Override
    public String toString() {
        String res = "";
        for (Map.Entry<Product, Integer> p : stock.entrySet()) {
            res += "****************************\n";
            res += p.getKey();
            res += "Stock disponible: " + p.getValue() + "\n";
        }
        return res;
    }
}
