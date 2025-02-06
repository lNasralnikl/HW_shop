package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductBasket {

    private final List<Product> products = new ArrayList<>();
    private final List<Product> deletedProducts = new ArrayList<>();
    private final boolean delProducts = false;

    //Статические переменные счетчики
    static double sum = 0;
    static int special = 0;

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
        System.out.println("Корзина очищена\n");
        products.removeAll(products);
        sum = 0;
        special = 0;
    }

    //Вывод корзины
    public void printBusket() {
        System.out.println("Продуктовая корзина:");
        products.forEach(n -> {
            System.out.println(n.toString());
            busketSum(n.getPrice());
            specialProducts(n.isSpecial());
        });
        if (sum == 0){
            System.out.println("Корзина пустая");
        }else if (special != 0){
            System.out.println("Итого: " + sum + ". Специальных продуктов: " + special + "\n");
        }
    }

    //Статические методы
    //Стоимость корзины
    private static double busketSum(double price){
        sum += price;
        return sum;
    }

    //Счетчик специальных продуктов
    private static int specialProducts(boolean check){
        if (check == true){
            special++;
        }
        return special;
    }

}
