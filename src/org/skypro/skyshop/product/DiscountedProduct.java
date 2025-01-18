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
        try{
            if (discountPercent < 0 || discountPercent > 100){
                throw new IllegalArgumentException("Ошибка: Скидка на товар должна быть в диапазоне от 0 до 100%");
            }
            price = basePrice * (1 - discountPercent / 100.0);
            return price;
        }catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Скидка на товар должна быть в диапазоне от 0 до 100%");
            return 0;
        }
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
