package ru.netology.domain;

import lombok.Data;
import ru.netology.repository.TicketRepository;

@Data
public class TicketManager {
    private TicketRepository repository;
    private int id;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(TicketOffer item) {
        repository.save(item);
    }

    public TicketOffer[] findAll(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer item : repository.findAll()) {
            if (item.matches(from, to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        return result;
    }

    public void removeById(int id) {
        if (repository.findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        repository.removeById(id);
    }
}
