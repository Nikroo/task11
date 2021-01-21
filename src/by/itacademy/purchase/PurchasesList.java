package by.itacademy.purchase;

import by.itacademy.order.Order;
import by.itacademy.order.OrdersList;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static by.itacademy.Constants.*;

public class PurchasesList {
    public static List<Purchase> purchases;

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
        OrdersList.addOrder(purchases);
    }

    public static void showPurchases() {
        if (OrdersList.orders.isEmpty()) {
            System.out.println(NO_ORDERS);
        } else {
            for(Order order : OrdersList.orders.keySet()){
                for (Purchase purchase : OrdersList.orders.get(order)){
                    System.out.println("  " + purchase);
                }
            }
        }
    }

    public static void removePurchase() {
        Scanner scanner = new Scanner(System.in);
        if (OrdersList.orders.isEmpty()) {
            System.out.println(NO_ORDERS);
        } else {
            System.out.println(CHOSE_PURCHASE_ID);
            int idForRemove = scanner.nextInt();
            purchases.removeIf(i -> i.getId()==idForRemove);

        }
    }

    public static void uploadToPurchaseFile(String src) {
        StringBuilder sb = new StringBuilder();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(src)))
        {
            if(!OrdersList.orders.isEmpty()) {
                for (Order order : OrdersList.orders.keySet()) {
                    for (Purchase purchase : OrdersList.orders.get(order)) {
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

    public static void downloadFromPurchaseFile(String src) {

        purchases = new ArrayList<>();

        File file = new File(src);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] str = line.split(DELIMETER);
            int id = Integer.parseInt(str[0]);
            String name = str[1];
            LocalDate date = LocalDate.parse(str[2]);
            purchases.add(new Purchase(name, date));
        }

    }


}
