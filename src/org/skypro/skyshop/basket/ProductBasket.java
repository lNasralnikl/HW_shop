package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {

    private final Product[] products;
    private final boolean busketFull = false;
    private int productQuantity = 0;
    private final int maxProductQuantity;

    public ProductBasket(int maxProductQuantity) {
        this.products = new Product[maxProductQuantity];
        this.maxProductQuantity = maxProductQuantity;
    }

//Методы

    //Добавление продукта в корзину
    public void addNewProduct(String name, int cost) {
        if (productQuantity >= maxProductQuantity) {
            System.out.println("Корзина заполнена");
        } else {
            Product newProduct = new Product(name, cost);
            products[productQuantity] = newProduct;
            productQuantity++;
        }
    }

    //Проверка продукта в корзине
    public void checkProduct(String name) {
        boolean check = false;
        for (int i = 0; i < maxProductQuantity; i++) {
            if (products[i] != null) {
                if (name.equals(products[i].getName())) {
                    check = true;
                    System.out.println("Товар в корзине под номером " + (i + 1));
                }
            }
        }
        if (!check) System.out.println("Товара нет в корзине");
    }

    //Очистка корзины
    public void busketClean() {
        for (int i = 0; i < maxProductQuantity; i++) {
            products[i] = null;
        }
    }

    //Вывод корзины
    public void printBusket() {
        int sum = 0;
        for (int i = 0; i < maxProductQuantity; i++) {
            if (products[i] == null) {
                System.out.print("");
            } else {
                System.out.println(products[i].getName() + ": " + products[i].getCost());
                sum = sum + products[i].getCost();
            }
        }
        if (sum == 0) {
            System.out.println("Корзина пустая");
        } else {
            System.out.println("Итого: " + sum);
        }
    }

}
