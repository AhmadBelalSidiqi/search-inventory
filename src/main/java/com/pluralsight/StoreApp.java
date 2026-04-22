package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StoreApp {
    public static void main(String[] args) {

        ArrayList<Product> inventory = loadTheInventory();
        printTheInventory(inventory);
        inventory = loadTheInventoryFromTheFile();
        printTheInventory(inventory);




    }

    public static ArrayList<Product> loadTheInventoryFromTheFile() {
        ArrayList<Product> inventory = new ArrayList<>();
        String fileLocation = "src/main/resources/inventory.csv";
        try {
            FileReader fileReader = new FileReader(fileLocation);
            BufferedReader reader = new BufferedReader(fileReader);
            String currentLine ;

            while ((currentLine=reader.readLine())!=null) {
                String[] currentLineSpilt = currentLine.split("\\|");
                int id = Integer.parseInt(currentLineSpilt[0]);
                String name = currentLineSpilt[1];
                double price = Double.parseDouble(currentLineSpilt[0]);
                inventory.add(new Product(id,name,price));

            }


        } catch (FileNotFoundException e) {
            System.err.println("File not found:"+fileLocation);
        } catch (IOException e) {
            System.err.println("IO Exception");
        }


        return inventory;
    }

    public static void printTheInventory(ArrayList<Product> inventory) {
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


