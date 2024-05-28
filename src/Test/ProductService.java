package Test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    public List<Product> filterByPrice(double priceThreshold) {
        return products.stream()
                .filter(product -> product.getPrice() <= priceThreshold)
                .collect(Collectors.toList());
    }

    public List<Product> sortByName() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    public Map<Integer, List<Product>> groupByQuantity() {
        return products.stream()
                .collect(Collectors.groupingBy(Product::getQuantity));
    }

    public int calculateTotalStockValue() {
        return products.stream()
                .mapToInt(Product::getQuantity)
                .sum();
    }

    public Optional<Product> findMostExpensiveProduct() {
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice));
    }

    public List<Product> findProductsWithFutureExpirationDate() {
        return products.stream()
                .filter(product -> product.getExpirationDate().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }
}
