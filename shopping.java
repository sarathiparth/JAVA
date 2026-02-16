
package scenario;
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct() {
        System.out.println("Product: " + name + " Price: " + price);
    }
}

class ShoppingCart {
    private List<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(String productName) {
        products.removeIf(p -> p.getName().equalsIgnoreCase(productName));
    }

    public double calculateTotalCost() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void displayCart() {
        for (Product p : products) {
            p.displayProduct();
        }
        System.out.println("Total Cost: " + calculateTotalCost());
    }
}

public class shopping {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 55000));
        cart.addProduct(new Product("Mouse", 800));
        cart.addProduct(new Product("Keyboard", 1500));

        cart.displayCart();

        cart.removeProduct("Mouse");

        System.out.println("After removing Mouse:");
        cart.displayCart();
    }
}



