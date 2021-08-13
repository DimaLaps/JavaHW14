package ru.netology.repository;

import ru.netology.domain.AvioTicket;


public class TicketRepository {
    private AvioTicket[] items = new AvioTicket[0];

    public void save(AvioTicket item) {
        int length = items.length + 1;
        AvioTicket[] tmp = new AvioTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    // выдать все объекты
    public AvioTicket[] findAll() {
        return items;
    }

    // найти по id
    public AvioTicket findById(int id) {
        for (AvioTicket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    // удалить по id
    public void removeById(int id) {
        int length = items.length - 1;
        AvioTicket[] tmp = new AvioTicket[length];
        int index = 0;
        for (AvioTicket item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }
}