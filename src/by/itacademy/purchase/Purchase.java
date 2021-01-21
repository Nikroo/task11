package by.itacademy.purchase;

import java.time.LocalDate;

public class Purchase {
    private static int count;
    private int id;
    private String name;
    private LocalDate date;

    public Purchase(String name, LocalDate date) {
        this.id = count++;
        this.name = name;
        this.date = date;
    }

    public Purchase(int id, String name, LocalDate date) {
        this.id = id;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
