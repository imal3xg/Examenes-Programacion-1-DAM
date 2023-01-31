package eticket;

/**
 * Product
 * Mantiene la información de un producto
 * Información que mantiene:
 * code: Código del producto (se debe autogenerar empezando en 1)
 * brand: Marca del producto
 * model: Modelo del producto
 * tradeName: Nombre comercial del producto
 * price: Precio del producto
 * Nota:
 * - Getters de cada uno de los campos
 * - Debes implementar el método equals que indica si un producto es igual a
 * otro
 * para ello se deben comparar los códigos de productos y así determinar si son
 * iguales o no
 * - Se debe poder imprimir la información de un producto de la siguiente forma:
 * Ej:
 * Código: 7
 * Marca: C&A
 * Modelo: G123456
 * Nombre comercial: Vestido señora
 * Precio: 119,95 €
 */
public class Product {
    private static int generalCode = 1;
    private int code;
    private String brand;
    private String model;
    private String tradeName;
    private double price;

    public Product(String brand, String model, String tradeName, double price) {
        this.code = generalCode++;
        this.brand = brand;
        this.model = model;
        this.tradeName = tradeName;
        this.price = price;
    }

    public int getCode() {
        return code;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return tradeName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        String res = "";
        res += "Código: " + code + "\n";
        res += "Marca: " + brand + "\n";
        res += "Modelo: " + model + "\n";
        res += "Nombre comercial: " + tradeName + "\n";
        res += "Precio: " + price + "\n";
        return res;
    }

    @Override
    public boolean equals(Object p) {
        if (this.getClass() == p.getClass()) {
            return this.code == ((Product) p).getCode();
        }
        return false;
    }
}
