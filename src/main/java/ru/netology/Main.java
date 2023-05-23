package ru.netology;

public class Main {
    public static void main(String[] args) {

        Ticket ticket1 = new Ticket(
                "москва",
                "петрозаводск",
                8000,
                12,
                17
        );

        Ticket ticket2 = new Ticket(
                "москва",
                "петрозаводск",
                5000,
                12,
                18
        );

        System.out.println(ticket1.compareTo(ticket2));
    }
}