package com.pluralsight;

import java.util.ArrayList;

public class StoreApp {
    public static void main(String[] args) {

        ArrayList<Product> inventory = loadTheInventory();
        System.out.println("We carry the following inventory: ");
        for (Product product : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f%n",
                    product.getId(),
                    product.getName(),
                    product.getPrice());
        }
    }
    public static ArrayList<Product> loadTheInventory() {
        ArrayList<Product> inventory = new ArrayList<>();
        inventory.add(new Product(0,"Apple",1.11));
        inventory.add(new Product(1,"Banana",2.23));
        inventory.add(new Product(2,"Apple",4.56));
        inventory.add(new Product(3,"Apple",5.1));
        inventory.add(new Product(4,"Apple",6.5));
        return inventory;
    }
}


