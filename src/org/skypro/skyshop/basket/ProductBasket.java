package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final List<Product> deletedProducts = new ArrayList<>();
    private final Map<String, List<Product>> products = new HashMap<>();

    //Методы
    //Добавление продукта в корзину
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Продукт не может быть пустым");
        }
        if (!products.containsKey(product.getName())) {
            products.put(product.getName(), new ArrayList<>());
        }
        products.get(product.getName()).add(product);
    }

    //Удаление продукта по наименованию
    public List<Product> deleteProduct(String productName) {
        if (productName.isBlank() || productName.isEmpty()) {
            return deletedProducts;
        }

        List<String> toRemove = new ArrayList<>();
        for (String key : products.keySet()) {
            if (key.toLowerCase().contains(productName.toLowerCase())) {
                deletedProducts.addAll(products.get(key));
                toRemove.add(key);
            }
        }

        for (String key : toRemove) {
            products.remove(key);
        }

        return deletedProducts;

    }

//Вывод корзины
public void printBusket() {
    double sum = 0;
    int special = 0;
    System.out.println("Продуктовая корзина:");

    for (Map.Entry<String, List<Product>> map : products.entrySet()) {
        System.out.println(map.getValue());
        for (Product product : map.getValue()) {
            sum += product.getPrice();
            if (map.getValue().getFirst().isSpecial()) {
                special++;
            }
        }
    }

    if (products.isEmpty()) {
        System.out.println("Продукты не добавлены");
    } else if (deletedProducts.isEmpty()) {
        System.out.println("Итого: " + sum + "\nСпециальных товаров в корзине: " + special + "\n");
    } else {
        System.out.println("Итого: " + sum + "\nСпециальных товаров в корзине: " + special + "\nУдаленные товары: " + deletedProducts + "\n");
    }
}

//Очистка корзины
public void busketClean() {
    System.out.println("Корзина очищена\n");
    products.clear();
}

}
