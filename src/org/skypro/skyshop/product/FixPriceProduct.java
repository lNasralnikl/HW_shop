package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {

    public static final double fixPrice = 500;

    public FixPriceProduct(String name) {
        super(name);
    }

    @Override
    public double getPrice() {
        return fixPrice;
    }

    @Override
    public String toString() {
        return getName() + " с фиксированной ценой: " + getPrice();
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
