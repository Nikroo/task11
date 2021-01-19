package by.itacademy.purchase;

import java.time.LocalDate;

public class Purchase {
    private int id;
    private String name;
    private LocalDate date;

    public Purchase(String name, LocalDate date) {
        this.id++;
        this.name = name;
        this.date = date;
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
