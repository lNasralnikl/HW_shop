package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

public abstract class Product implements Searchable {

    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double getPrice();
    public abstract boolean isSpecial();

    //Добавление поиска


    @Override
    public String searchTerm() {
        return name;
    }

    @Override
    public String content() {
        return "PRODUCT";
    }

}
