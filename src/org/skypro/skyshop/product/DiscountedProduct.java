package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private final double basePrice;
    private final int discountPercent;
    private double price;

    public DiscountedProduct(String name, double basePrice, int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        this.discountPercent = discountPercent;
    }

    @Override
    public double getPrice() {
        if (discountPercent >= 0 && discountPercent <= 100) {
            price = basePrice * (1 - discountPercent / 100.0);
        } else {
            System.out.println("Неверно указана скидка на продукт");
        }
        return price;
    }

    @Override
    public String toString() {
        return getName() + " со скидкой " + +discountPercent + "%: " + getPrice();
    }

    @Override
    public boolean isSpecial(){
        return true;
    }
}
