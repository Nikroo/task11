package by.itacademy.order;

import by.itacademy.purchase.Purchase;
import by.itacademy.purchase.PurchasesList;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

import static by.itacademy.Constants.*;
import static by.itacademy.purchase.PurchasesList.downloadFromPurchaseFile;
import static by.itacademy.purchase.PurchasesList.purchases;

public class OrdersList {

    public static Map<Order, List<Purchase>> orders = new HashMap<>();

    public static void addOrder(List<Purchase> purchases) {
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

    public static void downloadFromFiles(String src) {

        File file = new File(src);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        downloadFromPurchaseFile(SRC_PURCHASE_FILE);

        while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] str = line.split(DELIMETER);
                int id = Integer.parseInt(str[0]);
                LocalDateTime date = LocalDateTime.parse(str[1]);
                if(true) {
                    orders.put(new Order(date), purchases);
                }
            }
    }


}
