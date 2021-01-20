package by.itacademy.order;

import java.time.LocalDateTime;

public class Order {
    public static int count;
    private int id;
    private LocalDateTime date;

    public Order(LocalDateTime date) {
        this.id = count++;
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
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
