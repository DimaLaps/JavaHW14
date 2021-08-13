package ru.netology.manager;

import ru.netology.domain.AvioTicket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager() {
    }

    public void add(AvioTicket infoTicket) {
        repository.save(infoTicket);
    }

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public AvioTicket[] findAll(String from, String to) {
        AvioTicket[] result = new AvioTicket[0];
        for (AvioTicket infoTicket : repository.findAll()) {
            if (infoTicket.matches(from, to)) {
                AvioTicket[] tmp = new AvioTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = infoTicket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}