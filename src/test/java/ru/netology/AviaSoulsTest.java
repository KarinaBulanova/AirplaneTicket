package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortByPriceCompareTo() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("москва", "петрозаводск", 8000, 12, 00);
        Ticket ticket2 = new Ticket("москва", "петрозаводск", 5000, 12, 00);
        Ticket ticket3 = new Ticket("петрозаводск", "сочи", 8500, 12, 00);
        Ticket ticket4 = new Ticket("москва", "петрозаводск", 6000, 12, 00);
        Ticket ticket5 = new Ticket("москва", "сочи", 3000, 12, 00);
        Ticket ticket6 = new Ticket("москва", "петрозаводск", 7500, 12, 00);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] actual = manager.search("москва", "петрозаводск");
        Ticket[] expected = {ticket2, ticket4, ticket6, ticket1};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortByPriceCompareToOneTicket() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("москва", "петрозаводск", 8000, 12, 00);
        Ticket ticket2 = new Ticket("москва", "петрозаводск", 5000, 12, 00);
        Ticket ticket3 = new Ticket("петрозаводск", "сочи", 8500, 12, 00);
        Ticket ticket4 = new Ticket("москва", "петрозаводск", 6000, 12, 00);
        Ticket ticket5 = new Ticket("москва", "сочи", 3000, 12, 00);
        Ticket ticket6 = new Ticket("москва", "петрозаводск", 7500, 12, 00);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] actual = manager.search("москва", "сочи");
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortByPriceCompareToNoTicketsFound() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("москва", "петрозаводск", 8000, 12, 00);
        Ticket ticket2 = new Ticket("москва", "петрозаводск", 5000, 12, 00);
        Ticket ticket3 = new Ticket("петрозаводск", "сочи", 8500, 12, 00);
        Ticket ticket4 = new Ticket("москва", "петрозаводск", 6000, 12, 00);
        Ticket ticket5 = new Ticket("москва", "сочи", 3000, 12, 00);
        Ticket ticket6 = new Ticket("москва", "петрозаводск", 7500, 12, 00);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Ticket[] actual = manager.search("сочи", "петрозаводск");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSortingTicketsByTimeComparator() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("москва", "петрозаводск", 8000, 2, 5);
        Ticket ticket2 = new Ticket("москва", "петрозаводск", 5000, 2, 6);
        Ticket ticket3 = new Ticket("петрозаводск", "сочи", 8500, 6, 10);
        Ticket ticket4 = new Ticket("москва", "петрозаводск", 6000, 3, 9);
        Ticket ticket5 = new Ticket("москва", "сочи", 3000, 3, 7);
        Ticket ticket6 = new Ticket("москва", "петрозаводск", 7500, 5, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.searchAndSortBy("москва", "петрозаводск", comparator);
        Ticket[] expected = {ticket1, ticket2, ticket6, ticket4};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testSortingTicketsByTimeComparatorOneTicket() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("москва", "петрозаводск", 8000, 2, 5);
        Ticket ticket2 = new Ticket("москва", "петрозаводск", 5000, 2, 6);
        Ticket ticket3 = new Ticket("петрозаводск", "сочи", 8500, 6, 10);
        Ticket ticket4 = new Ticket("москва", "петрозаводск", 6000, 3, 9);
        Ticket ticket5 = new Ticket("москва", "сочи", 3000, 3, 7);
        Ticket ticket6 = new Ticket("москва", "петрозаводск", 7500, 5, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.searchAndSortBy("москва", "сочи", comparator);
        Ticket[] expected = {ticket5};

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testSortingTicketsByTimeComparatorNoTicketsFound() {

        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("москва", "петрозаводск", 8000, 2, 5);
        Ticket ticket2 = new Ticket("москва", "петрозаводск", 5000, 2, 6);
        Ticket ticket3 = new Ticket("петрозаводск", "сочи", 8500, 6, 10);
        Ticket ticket4 = new Ticket("москва", "петрозаводск", 6000, 3, 9);
        Ticket ticket5 = new Ticket("москва", "сочи", 3000, 3, 7);
        Ticket ticket6 = new Ticket("москва", "петрозаводск", 7500, 5, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);


        Comparator<Ticket> comparator = new TicketTimeComparator();


        Ticket[] actual = manager.searchAndSortBy("москва", "уфа", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }

}
