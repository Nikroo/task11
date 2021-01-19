package by.itacademy.order;

import by.itacademy.purchase.Purchase;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private int id;
    //private LocalDate date;
    private final Map<Integer, Purchase> purchases = new LinkedHashMap<>();

    public Order() {
        this.id++;
        //this.date = date;
    }

    public int getId() {
        return id;
    }

    public void addPurchase(Purchase purchase){
        purchases.put(purchase.getId(), purchase);
        System.out.println(purchase.getId());
    }

    public void showPurchases(){
        for (Map.Entry<Integer, Purchase> integerPurchaseEntry : purchases.entrySet()) {
            System.out.println(integerPurchaseEntry.getValue());
        }
    }



}
