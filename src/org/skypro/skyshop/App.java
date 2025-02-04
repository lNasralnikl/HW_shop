package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.searchable.SearchEngine;

public class App {

    public static void main(String[] args) {

        ProductBasket busket = new ProductBasket();

        //Добавление продукта в корзину
        Product product = new FixPriceProduct("Пиво крафтовое");
        busket.addProduct(product);
        Product product1 = new DiscountedProduct("Пиво светлое", 100, 20);
        busket.addProduct(product1);
        Product product2 = new DiscountedProduct("Пиво темное", 100, 5);
        busket.addProduct(product2);
        Product product3 = new SimpleProduct("Пиво обычное", 400);
        busket.addProduct(product3);
        Product product4 = new SimpleProduct("Водка люкс", 800);
        busket.addProduct(product4);
        Product product5 = new SimpleProduct("Водка люкс", 800);
        busket.addProduct(product5);

        //Добавление статьи
        Article article = new Article("Научные изыскания (статья)", "Текст статьи 1");
        Article article1 = new Article("Пришельцы среди нас (статья)", "Текст статьи 2");
        Article article2 = new Article("Мексиканский залив (статья)", "Текст статьи 3");
        Article article3 = new Article("Статья 4", "Текст статьи 4");
        Article article4 = new Article("Статья 2", "Текст статьи 2");

        //Создание объекта SearchEngine
        SearchEngine searchEngine = new SearchEngine();

        //Добавление объектов в массив для поиска
        searchEngine.add(article);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        searchEngine.add(article4);
        searchEngine.add(product5);
        searchEngine.add(product4);
        searchEngine.add(product3);
        searchEngine.add(product2);
        searchEngine.add(product1);
        searchEngine.add(product);

        //Печать содержимого корзины
        busket.printBusket();

        //Вызов Search
        searchEngine.search("статья");

        //Поиск товара
        //busket.checkProduct("Помидор");

        //Очистка корзины
        busket.busketClean();

        //Удаление по наименованию
        busket.deleteProduct("светлое");
        //busket.deleteProduct(" ");

        //Вывод корзины
        busket.printBusket();

    }
}
