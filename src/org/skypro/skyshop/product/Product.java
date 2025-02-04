package org.skypro.skyshop.product;

import org.skypro.skyshop.searchable.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {

    private final String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getName());
    }

    public Product(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ошибка: Наименование не может состоять из пробелов или иметь значение null");
        }
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
