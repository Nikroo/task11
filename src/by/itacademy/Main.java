package by.itacademy;

import by.itacademy.order.OrdersList;


import java.util.Scanner;

import static by.itacademy.Constants.*;

public class Main {

    static public Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mainMenu();
    }

    private static void mainMenu() {

        try {
            int inputNumber = -1;
            while (inputNumber != 3) {

                System.out.println(MAIN_MENU);
                System.out.println(PURCHASES);
                System.out.println(ORDERS);
                System.out.println(EXIT);

                while (!scanner.hasNextInt()) {
                    System.out.println(TRY_YET);
                    scanner.next();
                }
                inputNumber = scanner.nextInt();


                if (inputNumber == 1) {
                    purchasesMenu();
                }
                if (inputNumber == 2) {
                    orderMenu();
                }
                if (inputNumber == 0) {
                    break;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static void purchasesMenu() {

        int inputNumber = -1;
        while (inputNumber != 0) {
            System.out.println(PURCHASES_MENU);
            System.out.println(ADD_PURCHASES);
            System.out.println(REMOVE_PURCHASES);
            System.out.println(SHOW_PURCHASES);
            System.out.println(UPLOAD_TO_FILE);
            System.out.println(BACK);
            while (!scanner.hasNextInt()) {
                System.out.println(TRY_YET);
                scanner.next();
            }
            inputNumber = scanner.nextInt();

            if (inputNumber == 1) {
                OrdersList.addPurchases();
            }
            if (inputNumber == 2) {
                OrdersList.removePurchase();
            }
            if (inputNumber == 3) {
                OrdersList.showPurchases();
            }
            if (inputNumber == 4) {
                OrdersList.uploadToPurchaseFile(SRC_PURCHASE_FILE);
            }
            if (inputNumber == 0) {
                break;
            }
        }
    }

    private static void orderMenu() {

        int inputNumber = -1;
        while (inputNumber != 4) {
            System.out.println(ORDER_MENU);
            System.out.println(REMOVE_ORDER);
            System.out.println(SHOW_ORDER);
            System.out.println(UPLOAD_TO_FILE);
            System.out.println(BACK);
            while (!scanner.hasNextInt()) {
                System.out.println(TRY_YET);
                scanner.next();
            }
            inputNumber = scanner.nextInt();

            if (inputNumber == 1) {
                OrdersList.removeOrder();
            }
            if (inputNumber == 2) {OrdersList.showOrders();
            }
            if (inputNumber == 3) {
                break;
            }
            if (inputNumber == 4) {
                OrdersList.uploadToOrderFile(SRC_ORDER_FILE);
            }
            if (inputNumber == 0) {
                break;
            }
        }
    }
}