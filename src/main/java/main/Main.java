package main;

import prod.Product;

public class Main {
    public static void main(String[] args) {
        Product.totalPrice(new Product(3, 100, 0.75));
        System.out.println("-----------");
        Product.totalPrice(new Product(4, 80.75, 42.575));
        System.out.println("-----------");
        Product.totalPrice(new Product(5, 543.21, 59.1));
    }
}