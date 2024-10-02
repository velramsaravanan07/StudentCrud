package studentcrud;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MainProduct {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ImplementationProduct ip = new ImplementationProduct();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("=== Product CRUD Operations ===");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Fetch Product Data");
            System.out.println("4. Fetch All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Brand Name: ");
                    String brand = scanner.nextLine();
                    System.out.print("Enter Product Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Product Discount: ");
                    double discount = scanner.nextDouble();

                    Product p = new Product(id, brand, price, discount);
                    int insertResult = ip.insert(p);
                    System.out.println(insertResult > 0 ? "Product added successfully!" : "Failed to add product.");
                    break;

                case 2:
                    System.out.print("Enter Product ID to be deleted: ");
                    int deleteId = scanner.nextInt();
                    int deleteResult = ip.delete(deleteId);
                    System.out.println(deleteResult > 0 ? "Product deleted successfully!" : "Failed to delete product.");
                    break;

                case 3:
                    System.out.print("Enter Product ID to fetch data: ");
                    int fetchId = scanner.nextInt();
                    Product fetchedProduct = ip.fetchdata(fetchId);
                   
                    if (fetchedProduct != null) {
//                        System.out.println(fetchedProduct.getId()+" "+fetchedProduct.getBrand()+" "+fetchedProduct.getPrice()+" "+fetchedProduct.getDiscount());
                    	System.out.println(fetchedProduct); 
                    	} else {
                        System.out.println("No product found with ID: " + fetchId);
                    }
                    break;

                case 4:
                    List<Product> products = ip.fetchAll();
                    if (products.isEmpty()) {
                        System.out.println("No products found.");
                    } else {
                        for (Product prod : products) {
                            System.out.println(prod.getId()+" "+prod.getBrand()+" "+prod.getPrice()+" "+prod.getDiscount());
                        }
                    }
                    break;

                case 5:
                    scanner.close();
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
