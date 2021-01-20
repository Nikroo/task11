package by.itacademy.order;

import by.itacademy.purchase.Purchase;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private static int id;
    private LocalDateTime date;

    public Order(LocalDateTime date) {
        id++;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "date=" + date +
                '}';
    }
}
