package ru.mtsbank.prod;

/**
 * Класс, содержащий 3 параметра, для ДЗ-1
 */
public class Product {
    //Кол-во товара
    private int amountOfProduct;
    //Сумма товара
    private double price;
    //Скидка на товар, в процентах
    private double discount;

    public Product() {
        this(0, 0, 0);
    }

    public Product(int a, double p) {
        this(a, p, 0);
    }

    public Product(int a, double p, double d) {
        if (a < 0 || p < 0 || d < 0)
            throw new IllegalArgumentException("Negative numbers are not allowed");
        amountOfProduct = a;
        price = p;
        discount = d;
    }

    public int getAmountOfProduct() {
        return amountOfProduct;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setAmountOfProduct(int amountOfProduct) {
        this.amountOfProduct = amountOfProduct;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static void totalPrice(Product p) {
        double total = p.amountOfProduct * p.price;
        System.out.printf("Сумма покупки без скидки: %.2f\n", total);
        System.out.printf("Сумма покупки со скидкой: %.2f\n", total * (1 - p.discount / 100));
    }

    @Override
    public String toString() {
        return "Product{amountOfProduct=" + amountOfProduct + ", price=" + price + ", discount=" + discount + '}';
    }
}