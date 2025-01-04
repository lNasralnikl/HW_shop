package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;

public class App {

    public static void main(String[] args) {

        ProductBasket busket = new ProductBasket(5);

        //Добавление продукта в корзину
        busket.addNewFixProduct("Помидор");
        busket.addNewFixProduct("Яйца");
        busket.addNewDiscountProduct("Тыква", 200, 50);
        busket.addNewDiscountProduct("Ручка", 420, 50);
        busket.addNewSimpleProduct("Майонез", 700);

        //Печать содержимого корзины
        System.out.println("Корзина:"); //Добавил себе для красивого вывода
        busket.printBusket();
        System.out.println(); //Добавил себе для красивого вывода

        //Добавление товара в заполненную корзину
        busket.addNewSimpleProduct("Стол", 3000);
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
