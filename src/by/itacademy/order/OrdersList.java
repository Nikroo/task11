package by.itacademy.order;

import by.itacademy.purchase.Purchase;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static by.itacademy.Constants.*;

public class OrdersList {

    private static List<Purchase> purchases;
    private static Map<Order, List<Purchase>> orders = new HashMap<>();

    public static void addPurchases() {
        System.out.println(ENTER_PURCHASES);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);

        Scanner scanner = new Scanner(System.in);

        String s = "";
        purchases = new ArrayList<>();

        while (!(s = scanner.nextLine()).equals("0")) {
            if (s.matches(ALL_SYMBOLS)) {
                String[] str = s.split(DELIMETER);
                String name = str[0];
                LocalDate date = LocalDate.parse(str[1], formatter);
                purchases.add(new Purchase(name, date));
            }else{
                System.out.println(LETTERS_NUMBERS_SYMBOLS);
            }
        }
        orders.put(new Order(LocalDateTime.now()), purchases);
    }

    public static void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders");
        } else {

            for(Order order : orders.keySet()){
                System.out.println(order + ":");
                for (Purchase purchase : orders.get(order)){
                    System.out.println("  " + purchase);
                }
            }
        }
    }

    public static void showPurchases() {
        if (orders.isEmpty()) {
            System.out.println("No orders");
        } else {
            for(Order order : orders.keySet()){
                for (Purchase purchase : orders.get(order)){
                    System.out.println("  " + purchase);
                }
            }
        }
    }

    public static void removeOrder() {
        Scanner scanner = new Scanner(System.in);
        if (orders.isEmpty()) {
            System.out.println(NO_ORDERS);
        } else {
            System.out.println(CHOSE_ORDER_ID);
            int idForRemove = scanner.nextInt();
            Iterator<Map.Entry<Order, List<Purchase>>> entryIterator = orders.entrySet().iterator();
            while (entryIterator.hasNext()) {
                Map.Entry<Order, List<Purchase>> entry = entryIterator.next();
                Order key = entry.getKey();
                if (key.getId() == idForRemove) {
                    System.out.println(REMOVE + key);
                    entryIterator.remove();
                }
            }
        }
    }

    public static void removePurchase() {
        Scanner scanner = new Scanner(System.in);
        if (orders.isEmpty()) {
            System.out.println(NO_ORDERS);
        } else {
            System.out.println(CHOSE_PURCHASE_ID);
            int idForRemove = scanner.nextInt();
            for(Order order : orders.keySet()){
                orders.get(order).remove(idForRemove);
            }
        }
    }

    public static void uploadToOrderFile(String src) {

        StringBuilder sb = new StringBuilder();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(src)))
        {
            if (orders.isEmpty()) {
                System.out.println(NO_ORDERS);
            } else {
                for(Order order : orders.keySet()){
                    sb.append(order.getId())
                            .append("; ")
                            .append(order.getDate())
                            .append("; ");
                    for (Purchase purchase : orders.get(order)){
                        sb.append(purchase.getId()).append("; ");
                    }
                    sb.append("\n");
                }
            }
            bw.write(String.valueOf(sb));
            System.out.println(SUCCESSFUL);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void uploadToPurchaseFile(String src) {

        StringBuilder sb = new StringBuilder();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(src)))
        {
            if(!orders.isEmpty()) {
                for (Order order : orders.keySet()) {
                    for (Purchase purchase : orders.get(order)) {
                        sb.append(purchase.getId())
                                .append("; ")
                                .append(purchase.getName())
                                .append("; ")
                                .append(purchase.getDate())
                                .append("; ");
                        sb.append("\n");
                    }
                }
            }
            bw.write(String.valueOf(sb));
            System.out.println(SUCCESSFUL);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
