package eticket;

/**
 * TicketLine
 * Mantiene información de una línea de un ticket
 * Una línea contiene información del producto y la cantidad comprada del mismo
 * Debe poder:
 * - Devolver el producto de la línea
 * - Devolver la cantidad comprada del producto
 * - Modificar la cantidad comprada del producto
 * - Devolver el precio total de la línea (Cantidad*Precio del producto)
 * - Imprimir la línea del ticket de la siguiente manera:
 * ------------------------- 50 --------------------- --- 10 --- --- 10 ---
 * Levis 501 ( 1 x 79,95 € ) = 79,95 €
 */

public class TicketLine {
    Product product;
    int amount;

    public TicketLine(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public double getTotalPrice() {
        return product.getPrice() * amount;
    }
    public Product getLine() {
        return this.product;
    }

    @Override
    public String toString() {
        String res = String.format("%-50s(%3d x %10.2f € ) = %10.2f €", product.getName(), amount,
                this.getProduct().getPrice(), this.getTotalPrice());
        return res;
    }

}
