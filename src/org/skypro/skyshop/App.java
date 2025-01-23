package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.searchable.SearchEngine;

public class App {

    public static void main(String[] args) {

        ProductBasket busket = new ProductBasket();

        //Добавление продукта в корзину
 HW4
        Product product;
        try {
            product = new FixPriceProduct("   ");
        } catch (IllegalArgumentException e){
            product = new FixPriceProduct("Пиво");
        }

        busket.addProduct(product);

        Product product1;
        try {
            product1 = new DiscountedProduct("Пиво", 150, -15);
        }catch (IllegalArgumentException e){
            product1 = new DiscountedProduct("Пиво", 150, 50);
        }



        Product product = new FixPriceProduct("Помидор");
        busket.addProduct(product);
 HW5_List
        Product product1 = new DiscountedProduct("Пиво светлое", 150, 20);


        Product product1 = new DiscountedProduct("Пиво", 150, 20);
 master
 master
        busket.addProduct(product1);
        Product product2 = new DiscountedProduct("Пиво темное", 400, 5);
        busket.addProduct(product2);

        //Добавление статьи
        Article article = new Article("Статья 1", "Текст статьи 1");
        Article article1 = new Article("Статья 2", "Текст статьи 2");
        Article article2 = new Article("Статья 3", "Текст статьи 3");
        Article article3 = new Article("Статья 4", "Текст статьи 4");
 HW4

        //Создание объекта SearchEngine
        SearchEngine searchEngine = new SearchEngine(5);

        //Добавление объектов в массив для поиска
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(product1);
        searchEngine.add(product);

        //Точный поиск
        searchEngine.getSearchTerm("Статья 3");
        searchEngine.getSearchTerm("Водка");

        /*
        //Вызов Search
        searchEngine.search("Пиво");
        searchEngine.search("Статья 3");


 master

        //Создание объекта SearchEngine
        SearchEngine searchEngine = new SearchEngine();

        //Добавление объектов в массив для поиска
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(product2);
        searchEngine.add(product1);
        searchEngine.add(product);

        //Печать содержимого корзины
        busket.printBusket();
 HW5_List

        System.out.println(); //Добавил себе для красивого вывода

        /*
        //Добавление товара в заполненную корзину
 master

        //Вызов Search
        searchEngine.search("пиво");

        //Поиск товара
        //busket.checkProduct("Помидор");
        //busket.checkProduct("Пиво");

        /*
        //Очистка корзины
        busket.busketClean();
        */

        //Удаление по наименованию
        busket.deleteProduct("пиво");
        //busket.deleteProduct(" ");

        //Вывод корзины
        busket.printBusket();

        /*
        System.out.println(); //Добавил себе для красивого вывода
        //Поиск товара в пустой корзине
        busket.checkProduct("Помидор");
*/

    }
}
