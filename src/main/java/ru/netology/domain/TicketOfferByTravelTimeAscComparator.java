package ru.netology.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

@NoArgsConstructor
@Data
public class TicketOfferByTravelTimeAscComparator implements Comparator<TicketOffer> {
    @Override
    public int compare(TicketOffer o1, TicketOffer o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
