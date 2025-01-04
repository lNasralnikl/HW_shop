package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

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
    public void addNewSimpleProduct(String name, double price) {
        if (productQuantity >= maxProductQuantity) {
            System.out.println("Корзина заполнена");
        } else {
            SimpleProduct newProduct = new SimpleProduct(name, price);
            products[productQuantity] = newProduct;
            productQuantity++;
        }
    }

    public void addNewDiscountProduct(String name, double basePrice, int discountPercent) {
        if (productQuantity >= maxProductQuantity) {
            System.out.println("Корзина заполнена");
        } else {
            DiscountedProduct newProduct = new DiscountedProduct(name, basePrice, discountPercent);
            products[productQuantity] = newProduct;
            productQuantity++;
        }
    }

    public void addNewFixProduct(String name) {
        if (productQuantity >= maxProductQuantity) {
            System.out.println("Корзина заполнена");
        } else {
            FixPriceProduct newProduct = new FixPriceProduct(name);
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
        if (!check) System.out.println("Товара " + name + " нет в корзине");
    }

    //Очистка корзины
    public void busketClean() {
        for (int i = 0; i < maxProductQuantity; i++) {
            products[i] = null;
        }
    }

    //Вывод корзины
    public void printBusket() {
        double sum = 0;
        int special = 0;
        for (int i = 0; i < maxProductQuantity; i++) {
            if (products[i] == null) {
                System.out.print("");
            } else {
                System.out.println(products[i].toString());
                sum = sum + products[i].getPrice();
                if (products[i].isSpecial()) {
                    special++;
                }
            }

        }
        if (sum == 0) {
            System.out.println("Корзина пустая");
        } else {
            System.out.println("Итого: " + sum + "\nСпециальных товаров в корзине: " + special);
        }
    }
}
