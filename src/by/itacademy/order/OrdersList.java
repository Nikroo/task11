package by.itacademy.order;

import by.itacademy.purchase.Purchase;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static by.itacademy.Constants.*;

public class OrdersList {

    private static Map<Integer, Order> orders = new LinkedHashMap<>();
    private static Order order;

    public static void addPurchases() {
        System.out.println("Enter purchase! Format: Name; dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        Scanner scanner = new Scanner(System.in);

        order = new Order(LocalDate.now());
        String s = "";

        while (!(s = scanner.nextLine()).equals("0")) {
            if (s.matches(ALL_SYMBOLS)) {
                String[] str = s.split(DELIMETER);
                String name = str[0];
                LocalDate date = LocalDate.parse(str[1], formatter);
                order.addPurchase(new Purchase(name, date));
                orders.put(order.getId(), order);
            }else{
                System.out.println("Letters and numbers only");
            }
        }
    }

    public static void showOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders");
        } else {
            for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
                //System.out.println("OrderID: " + entry.getKey() + " | " + entry.getValue());


            }
        }
    }


    public static void uploadToFile(String src) {

        StringBuilder sb = new StringBuilder();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(src)))
        {
            for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
                sb.append(entry.getKey()).append("; ").append(entry.getValue().getDate()).append("; ");
                for (Order value : orders.values()) {
                    sb.append(value.getPurchases());
                }
                sb.append("\n");
            }



            bw.write(String.valueOf(sb));
            System.out.println(SUCCESSFUL);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }




    }


}

// sdfsdf; 01-02-1988