package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int amount;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    public boolean matches(String from, String to) {
        if (getDepartureAirport().equals(from) & getArrivalAirport().equals(to)) {
            return true;
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOffer that = (TicketOffer) o;
        return id == that.id &&
                amount == that.amount &&
                travelTime == that.travelTime &&
                departureAirport.equals(that.departureAirport) &&
                arrivalAirport.equals(that.arrivalAirport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, departureAirport, arrivalAirport, travelTime);
    }

    @Override
    public String toString() {
        return "TicketOffer{" +
                "id=" + id +
                ", amount=" + amount +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", travelTime=" + travelTime +
                '}';
    }

    @Override
    public int compareTo(TicketOffer o) {
        TicketOffer p = (TicketOffer) o;
        return amount - p.amount;
    }
}
