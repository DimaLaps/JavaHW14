package ru.netology.repository;

import ru.netology.manager.TicketManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AvioTicket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;


public class TicketRepositoryTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    private AvioTicket first = new AvioTicket(1, 3436, "SVO", "KUF", 31);
    private AvioTicket second = new AvioTicket(2, 2138, "KUF", "VKO", 64);
    private AvioTicket third = new AvioTicket(3, 1487, "KUF", "KZN", 36);
    private AvioTicket fourth = new AvioTicket(4, 8954, "DME", "VKO", 98);
    private AvioTicket fifth = new AvioTicket(5, 4779, "VKO", "KZN", 63);
    private AvioTicket sixth = new AvioTicket(6, 1636, "DME", "LED", 100);
    private AvioTicket seventh = new AvioTicket(7, 4990, "SVO", "KUF", 99);
    private AvioTicket eighth = new AvioTicket(8, 9000, "DME", "LED", 36);
    private AvioTicket ninth = new AvioTicket(9, 1687, "DME", "LED", 74);
    private AvioTicket tenth = new AvioTicket(10, 7777, "KUF", "VKO", 78);


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
    }

    @Test
    void shouldFindAllAndSort() {
        AvioTicket[] actual = repository.findAll();
        AvioTicket[] expected = new AvioTicket[]{third, sixth, ninth, second, first, fifth, seventh, tenth, fourth, eighth};
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}