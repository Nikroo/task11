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
    private static Order order;

    public static void addPurchases() {
        System.out.println("Enter purchase! Format: Name; dd-MM-yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
                System.out.println("Letters and numbers only");
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


    public static void uploadToFile(String src) {

        StringBuilder sb = new StringBuilder();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(src)))
        {
/*            for (Map.Entry<Integer, Order> entry : orders.entrySet()) {
                sb.append(entry.getKey()).append("; ").append(entry.getValue().getDate()).append("; ");
                for (Order value : orders.values()) {
                    sb.append(value.getPurchases());
                }
                sb.append("\n");
            }*/



            bw.write(String.valueOf(sb));
            System.out.println(SUCCESSFUL);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }




    }


}

// sdfsdf; 01-02-1988