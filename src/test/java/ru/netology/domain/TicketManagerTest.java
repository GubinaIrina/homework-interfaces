package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);

    @Test
    void findAllIfExists() {
        String from = "Домодедово";
        String to = "Самара";
        TicketOffer first = new TicketOffer(1, 5749, "Домодедово", "Самара", 110);
        TicketOffer second = new TicketOffer(3, 5762, "Домодедово", "Екатеринбург", 150);
        TicketOffer third = new TicketOffer(4, 2540, "Внуково", "Пулково", 85);

        manager.add(first);
        manager.add(second);
        manager.add(third);

        TicketOffer[] expected = new TicketOffer[]{first};
        TicketOffer[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    void nonExistentFind() {
        String from = "Внуково";
        String to = "Самара";
        TicketOffer first = new TicketOffer(1, 5749, "Домодедово", "Самара", 110);
        TicketOffer second = new TicketOffer(3, 5762, "Домодедово", "Екатеринбург", 150);
        TicketOffer third = new TicketOffer(4, 2540, "Внуково", "Пулково", 85);

        manager.add(first);
        manager.add(second);
        manager.add(third);


        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAll() {
        String from = "Домодедово";
        String to = "Самара";
        TicketOffer first = new TicketOffer(1, 5749, "Домодедово", "Самара", 110);
        TicketOffer second = new TicketOffer(2, 5392, "Домодедово", "Самара", 115);
        TicketOffer third = new TicketOffer(3, 5762, "Домодедово", "Екатеринбург", 150);
        TicketOffer four = new TicketOffer(4, 2540, "Внуково", "Пулково", 85);
        TicketOffer five = new TicketOffer(5, 5541, "Домодедово", "Самара", 125);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);

        TicketOffer[] expected = new TicketOffer[]{second, five, first};
        TicketOffer[] actual = manager.findAll(from, to);

        assertArrayEquals(expected, actual);
    }

    @Test
    void nonExistentFindWithComparator() {
        String from = "Внуково";
        String to = "Самара";
        TicketOffer first = new TicketOffer(1, 5749, "Домодедово", "Самара", 110);
        TicketOffer second = new TicketOffer(2, 5392, "Домодедово", "Самара", 115);
        TicketOffer third = new TicketOffer(3, 5762, "Домодедово", "Екатеринбург", 150);
        TicketOffer four = new TicketOffer(4, 2540, "Внуково", "Пулково", 85);
        TicketOffer five = new TicketOffer(5, 5541, "Домодедово", "Самара", 125);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);

        Comparator comparator = new TicketOfferByTravelTimeAscComparator();

        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = manager.findAllWithComparator(from, to, comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void findAllFindWithComparator() {
        String from = "Внуково";
        String to = "Самара";
        TicketOffer first = new TicketOffer(1, 5749, "Домодедово", "Самара", 110);
        TicketOffer second = new TicketOffer(2, 5392, "Домодедово", "Самара", 115);
        TicketOffer third = new TicketOffer(3, 5762, "Домодедово", "Екатеринбург", 150);
        TicketOffer four = new TicketOffer(4, 2540, "Внуково", "Пулково", 85);
        TicketOffer five = new TicketOffer(5, 5541, "Домодедово", "Самара", 125);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);
        manager.add(five);

        Comparator comparator = new TicketOfferByTravelTimeAscComparator();

        TicketOffer[] expected = new TicketOffer[0];
        TicketOffer[] actual = manager.findAllWithComparator(from, to, comparator);

        assertArrayEquals(expected, actual);
    }
}