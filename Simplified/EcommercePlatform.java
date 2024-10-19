import java.util.*;

class Product {
    String name;
    double price;
    
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class EcommercePlatform {
    List<Product> products = new ArrayList<>();
    Map<String, Integer> cart = new HashMap<>();
    Scanner sc = new Scanner(System.in);
    
    void addProducts() {
        products.add(new Product("Laptop", 1000.0));
        products.add(new Product("Phone", 500.0));
        products.add(new Product("Headphones", 100.0));
    }
    
    void displayProducts() {
        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).name + " - $" + products.get(i).price);
        }
    }

    void addToCart() {
        displayProducts();
        System.out.print("Enter product number to add to cart: ");
        int choice = sc.nextInt();
        Product selectedProduct = products.get(choice - 1);
        cart.put(selectedProduct.name, cart.getOrDefault(selectedProduct.name, 0) + 1);
        System.out.println(selectedProduct.name + " added to cart.");
    }

    void checkout() {
        System.out.println("Cart Summary:");
        double total = 0;
        for (String item : cart.keySet()) {
            int qty = cart.get(item);
            double price = 0;
            for (Product p : products) {
                if (p.name.equals(item)) {
                    price = p.price;
                    break;
                }
            }
            System.out.println(item + " x" + qty + " = $" + (price * qty));
            total += price * qty;
        }
        System.out.println("Total Amount: $" + total);
    }

    void run() {
        addProducts();
        while (true) {
            System.out.println("\n1. Add to Cart\n2. Checkout\n3. Exit");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            if (option == 1) {
                addToCart();
            } else if (option == 2) {
                checkout();
            } else {
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        new EcommercePlatform().run();
    }
}
