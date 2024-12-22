package org.skypro.skyshop;

public class App {

    public static void main(String[] args) {

        ProductBasket busket = new ProductBasket(5);

        //Добавление продукта в корзину
        busket.addNewProduct("Помидор", 50);
        busket.addNewProduct("Тыква", 354);
        busket.addNewProduct("Майонез", 500);
        busket.addNewProduct("Огурцы", 45);
        busket.addNewProduct("Стол", 3000);

        //Печать содержимого корзины
        busket.printBusket();

        //Добавление товара в заполненную корзину
        busket.addNewProduct("Стол", 3000);

        //Поиск товара
        busket.checkProduct("Помидор");
        busket.checkProduct("Пиво");

        //Очистка корзины
        busket.busketClean();
        //Вывод корзины
        busket.printBusket();
        //Поиск товара в пустой корзине
        busket.checkProduct("Помидор");
    }

}
