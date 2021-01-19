package by.itacademy;

import by.itacademy.order.Order;
import by.itacademy.purchase.Purchase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static by.itacademy.Constants.*;

public class Main {

    private static final Map<Integer, Order> orders = new LinkedHashMap<>();


    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = -1;
            while (inputNumber != 3) {
                System.out.println(MAIN_MENU);
                System.out.println(PURCHASES);
                System.out.println(ORDERS);
                System.out.println(EXIT);
                inputNumber = scanner.nextInt();

                if (inputNumber == 1) {
                    purchasesMenu();
                    break;
                }

                if (inputNumber == 2) {
                    orderMenu();
                    break;
                }

                if (inputNumber == 3) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void purchasesMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = -1;
            while (inputNumber != 4) {
                System.out.println(PURCHASES_MENU);
                System.out.println(ADD_PURCHASES);
                System.out.println(REMOVE_PURCHASES);
                System.out.println(SHOW_PURCHASES);
                System.out.println(BACK);
                inputNumber = scanner.nextInt();

                if (inputNumber == 1) {
                    addPurchases();
                    break;
                }

                if (inputNumber == 2) {
                    System.out.println("Enter 2");
                }

                if (inputNumber == 3) {
                    if(orders.isEmpty()){
                        System.out.println("No orders");
                    }else{
                        for (Order value : orders.values()) {
                            value.showPurchases();
                        }
                    }
                }

                if (inputNumber == 0) {
                    mainMenu();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

}

    private static void addPurchases() {
        System.out.println("Enter purchase!");

        Purchase purchases;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try (Scanner scanner = new Scanner(System.in)) {
            Order order = new Order();
            String s;

            while (!(s = scanner.nextLine()).equals("exit")) {
                String[] str = s.split(DELIMETER);
                String name = str[0];
                LocalDate date = LocalDate.parse(str[1], formatter);
                order.addPurchase(new Purchase(name, date));
                orders.put(order.getId(), order);
            }

            order.showPurchases();

            purchasesMenu();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void orderMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int inputNumber = -1;
            while (inputNumber != 4) {
                System.out.println(ORDER_MENU);
                System.out.println(REMOVE_ORDER);
                System.out.println(SHOW_ORDER);
                System.out.println(BACK);
                inputNumber = scanner.nextInt();

                if (inputNumber == 1) {
                    System.out.println("Enter 1");
                }

                if (inputNumber == 2) {
                    System.out.println("Enter 2");
                }

                if (inputNumber == 0) {
                    mainMenu();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
