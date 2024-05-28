package Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 5, 1500.99, true, LocalDate.of(2025, 12, 31)));
        products.add(new Product("Smartphone", 10, 799.49, true, LocalDate.of(2024, 6, 15)));
        products.add(new Product("Headphones", 20, 99.99, true, LocalDate.of(2026, 8, 23)));
        products.add(new Product("Monitor", 7, 249.99, false, LocalDate.of(2023, 5, 1)));
        products.add(new Product("Keyboard", 15, 49.99, true, LocalDate.of(2025, 11, 11)));

        ProductService productService = new ProductService(products);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMeniu:");
            System.out.println("1. Filtrează produsele după preț");
            System.out.println("2. Sortează produsele după nume");
            System.out.println("3. Grupează produsele după cantitate");
            System.out.println("4. Calculează valoarea totală a stocului");
            System.out.println("5. Găsește cel mai scump produs");
            System.out.println("6. Afișarea produselor care au data de expirare în viitor.");
            System.out.println("0. Ieși");
            System.out.print("Alege o opțiune: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Introdu prețul max: ");
                    double priceMax = scanner.nextDouble();
                    List<Product> filteredProducts = productService.filterByPrice(priceMax);
                    System.out.println("Produse cu prețul mai mic sau egal cu " + priceMax + ":");
                    filteredProducts.forEach(x -> System.out.println(x));
                    break;
                case 2:
                    List<Product> sortedProducts = productService.sortByName();
                    System.out.println("Produse sortate după nume:");
                    sortedProducts.forEach(x -> System.out.println(x));
                    break;
                case 3:
                    Map<Integer, List<Product>> groupedProducts = productService.groupByQuantity();
                    System.out.println("Produse grupate după cantitate:");
                    groupedProducts.forEach((quantity, prodList) -> {
                        System.out.println("Cantitate: " + quantity);
                        prodList.forEach(x -> System.out.println(x));
                    });
                    break;
                case 4:
                    int totalStock = productService.calculateTotalStockValue();
                    System.out.println("Valoarea totală a stocului: " + totalStock);
                    break;
                case 5:
                    Optional<Product> mostExpensiveProduct = productService.findMostExpensiveProduct();
                    System.out.println("Cel mai scump produs:");
                    mostExpensiveProduct.ifPresent(x -> System.out.println(x));
                    break;
                case 6:
                    List<Product> futureExpirationProducts = productService.findProductsWithFutureExpirationDate();
                    System.out.println("Produse cu data de expirare în viitor:");
                    futureExpirationProducts.forEach(x -> System.out.println(x));
                    break;
                case 0:
                    System.out.println("Ieșire din program.");
                    break;
                default:
                    System.out.println("Opțiune invalidă. Te rog să încerci din nou.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
