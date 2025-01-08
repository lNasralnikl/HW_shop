package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

public class App {

    public static void main(String[] args) {

        ProductBasket busket = new ProductBasket(5);

        //Добавление продукта в корзину
        FixPriceProduct product = new FixPriceProduct("Помидор");
        busket.addProduct(product);

        DiscountedProduct product1 = new DiscountedProduct("Пиво", 150, 20);
        busket.addProduct(product1);



        //Печать содержимого корзины
        System.out.println("Корзина:"); //Добавил себе для красивого вывода
        busket.printBusket();
        System.out.println(); //Добавил себе для красивого вывода

        //Добавление товара в заполненную корзину

        System.out.println(); //Добавил себе для красивого вывода

        //Поиск товара
        busket.checkProduct("Помидор");
        busket.checkProduct("Пиво");

        //Очистка корзины
        busket.busketClean();
        System.out.println(); //Добавил себе для красивого вывода
        //Вывод корзины
        busket.printBusket();
        System.out.println(); //Добавил себе для красивого вывода
        //Поиск товара в пустой корзине
        busket.checkProduct("Помидор");
    }
}
