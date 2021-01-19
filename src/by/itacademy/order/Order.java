package by.itacademy.order;

import java.time.LocalDate;
import java.util.Arrays;

public class Order {
    private int id;
    private LocalDate date;
    private Order [] orders;

    public Order(LocalDate date, Order[] orders) {
        this.id++;
        this.date = date;
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", orders=" + Arrays.toString(orders) +
                '}';
    }
}
