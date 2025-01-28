package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();
    //private final List<Product> products = new ArrayList<>();
    private List<Product> deletedProducts = new ArrayList<>();
    private final boolean delProducts = false;

    //Методы
    //Добавление продукта в корзину
    public void addProduct(Product product) {
        if (!products.containsKey(product.getName())) {
            products.put(product.getName(), new ArrayList<>());
        }
        products.get(product.getName()).add(product);
    }

    //Удаление продукта по наименованию
    public void deleteProduct(String productName) {
        if (productName.isBlank()){
            return;
        }
        Iterator<Map.Entry<String, List<Product>>> mapIterator = products.entrySet().iterator();
        while (mapIterator.hasNext()){
            Map.Entry<String, List<Product>> map = mapIterator.next();
            if (map.getKey().toLowerCase().contains(productName.toLowerCase())){
                deletedProducts.addAll(map.getValue());
                mapIterator.remove();
            }
        }

    }


    //Вывод корзины
    public void printBusket() {
        int busketSize = products.size();
        double sum = 0;
        int special = 0;
        System.out.println("Продуктовая корзина:");

        for (Map.Entry<String, List<Product>> map: products.entrySet()){
            System.out.println(map.getValue());
            sum += map.getValue().getFirst().getPrice();
            if (map.getValue().getFirst().isSpecial()){
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

    //Очистка корзины
    public void busketClean() {
        System.out.println("Корзина очищена");
        int busketSize = products.size();
        for (int i = 0; i < busketSize; i++) {
            products.remove(0);
        }
    }

    /*
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
    */


}
