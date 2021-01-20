package by.itacademy.purchase;

import java.time.LocalDate;

public class Purchase {
    private static int id;
    private String name;
    private LocalDate date;

    public Purchase(String name, LocalDate date) {
        this.id++;
        this.name = name;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return  "Name='" + name + '\'' +
                ", date=" + date;
    }
}
