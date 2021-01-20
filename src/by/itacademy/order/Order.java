package by.itacademy.order;

import by.itacademy.purchase.Purchase;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private static int id;
    private LocalDate date;
    private final Map<Integer, Purchase> purchases = new LinkedHashMap<>();

    public Order(LocalDate date) {
        this.id++;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Map<Integer, Purchase> getPurchases() {
        return purchases;
    }

/*    public StringBuilder getPurchases() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, Purchase> entry : purchases.entrySet()) {
            sb.append(entry.getKey()).append("; ");
        }
        return sb;
    }*/

    public void addPurchase(Purchase purchase){
        purchases.put(purchase.getId(), purchase);
        System.out.println(purchase.getId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "OrdersDate=" + date +
                ", purchases=" + purchases +
                '}';
    }
}
