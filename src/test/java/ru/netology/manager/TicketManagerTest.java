package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AvioTicket;
import ru.netology.repository.TicketRepository;


import static org.junit.jupiter.api.Assertions.*;


public class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private AvioTicket first = new AvioTicket(1, 3436, "SVO", "KUF", 31);
    private AvioTicket second = new AvioTicket(2, 2138, "KUF", "VKO", 64);
    private AvioTicket third = new AvioTicket(3, 1487, "KUF", "VKO", 36);
    private AvioTicket fourth = new AvioTicket(4, 8954, "SVO", "KUF", 98);
    private AvioTicket fifth = new AvioTicket(5, 4779, "VKO", "KZN", 63);
    private AvioTicket sixth = new AvioTicket(6, 1636, "DME", "LED", 100);
    private AvioTicket seventh = new AvioTicket(7, 4990, "SVO", "KUF", 99);
    private AvioTicket eighth = new AvioTicket(8, 9000, "DME", "LED", 36);
    private AvioTicket ninth = new AvioTicket(9, 1687, "SVO", "KUF", 74);
    private AvioTicket tenth = new AvioTicket(10, 7777, "KUF", "VKO", 78);
    private AvioTicket eleventh = new AvioTicket(11, 9730, "KUF", "VKO", 109);
    private AvioTicket twelfth = new AvioTicket(12, 854, "SVO", "KUF", 95);
    private AvioTicket thirteenth = new AvioTicket(13, 1321, "SVO", "KUF", 765);
    private AvioTicket fourteenth = new AvioTicket(14, 5725, "KUF", "VKO", 94);
    private AvioTicket fifteenth = new AvioTicket(15, 65176, "KUF", "VKO", 23);


    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);
        manager.add(twelfth);
        manager.add(thirteenth);
        manager.add(fourteenth);
        manager.add(fifteenth);
    }

    @Test
    void shouldFindTicket() {
        AvioTicket[] actual = manager.findAll("SVO", "KUF");
        AvioTicket[] expected = new AvioTicket[]{twelfth, thirteenth, ninth, first, seventh, fourth};
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldNotFindTicket() {
        AvioTicket[] actual = manager.findAll("DME", "KZN");
        AvioTicket[] expected = new AvioTicket[0];
        assertArrayEquals(actual, expected);
    }

    @Test
    void shouldFindTicketAndSortByPrice() {
        AvioTicket[] actual = manager.findAll("KUF", "VKO");
        AvioTicket[] expected = new AvioTicket[]{third, second, fourteenth, tenth, eleventh, fifteenth};
        assertArrayEquals(actual, expected);
    }
}