package ru.netology.AviaSoulsTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Сургут", "Канибадам", 5000, 11, 19);
    Ticket ticket2 = new Ticket("Псков", "Норильск", 3400, 7, 15);
    Ticket ticket3 = new Ticket("Мурманск", "Сочи", 4500, 17, 23);
    Ticket ticket4 = new Ticket("Москва", "Париж", 3700, 4, 14);
    Ticket ticket5 = new Ticket("Липецк", "Ржев", 2500, 8, 12);
    Ticket ticket6 = new Ticket("Париж", "Москва", 3800, 10, 18);
    Ticket ticket7 = new Ticket("Северодвинск", "Североморск", 2500, 15, 19);


    @BeforeEach
    public void addNewTicket() {
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
    }

    @Test
    public void shouldFindMinPrice() {
        int expected = 1;
        int actual = ticket1.compareTo(ticket5);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMaxPrice() {
        int expected = -1;
        int actual = ticket7.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEqualPrice() {
        int expected = 0;
        int actual = ticket5.compareTo(ticket7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindEqualTime() {
        int expected = 0;
        int actual = timeComparator.compare(ticket1, ticket6);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMinTime() {
        int expected = -1;
        int actual = timeComparator.compare(ticket2, ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFindMaxTime() {
        int expected = 1;
        int actual = timeComparator.compare(ticket3, ticket5);

        Assertions.assertEquals(expected, actual);
    }
}