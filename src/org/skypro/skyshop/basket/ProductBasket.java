package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {

    private final List<Product> products = new ArrayList<>();
    private final List<Product> deletedProducts = new ArrayList<>();

    //Методы
    //Добавление продукта в корзину
    public void addProduct(Product product) {
        products.add(product);
    }

    //Удаление продукта по наименованию
    public void deleteProduct(String productName) {
        for (Product product : products) {
            if (!productName.isBlank() && product.getName().toLowerCase().contains(productName.toLowerCase())) {
                deletedProducts.add(product);
            }
        }
        products.removeAll(deletedProducts);
    }

    //Проверка продукта в корзине
    public void checkProduct(String name) {
        int busketSize = products.size();
        boolean check = false;
        for (int i = 0; i < busketSize; i++) {
            if (products.get(i) != null && name.equals(products.get(i).getName())) {
                check = true;
                System.out.println("Товар в корзине под номером " + (i + 1));
            }
        }
        if (!check) System.out.println("Товара " + name + " нет в корзине");
    }

    //Очистка корзины
    public void busketClean() {
        System.out.println("Корзина очищена");
        int busketSize = products.size();
        for (int i = 0; i < busketSize; i++) {
            products.remove(0);
        }
    }

    //Вывод корзины
    public void printBusket() {
        int busketSize = products.size();
        double sum = 0;
        int special = 0;
        System.out.println("Продуктовая корзина:");
        for (int i = 0; i < busketSize; i++) {
            System.out.println(products.get(i).toString());
            sum = sum + products.get(i).getPrice();
            if (products.get(i).isSpecial()) {
                special++;
            }
        }
        if (sum == 0) {
            System.out.println("Корзина пустая");
        } else if (deletedProducts.isEmpty()) {
            System.out.println("Итого: " + sum + "\nСпециальных товаров в корзине: " + special + "\n");
        } else {
            System.out.println("Итого: " + sum + "\nСпециальных товаров в корзине: " + special + "\nУдаленные товары: " + deletedProducts + "\n");
        }
    }

}
