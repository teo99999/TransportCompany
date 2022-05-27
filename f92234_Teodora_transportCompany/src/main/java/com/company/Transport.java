package com.company;

import java.util.Comparator;

public class Transport {
    private String startPoint;
    private String destination;
    private String dateDepart;
    private String dateArrival;
    private Driver driver;

    public Transport(String startPoint, String destination, String dateDepart, String dateArrival, Driver driver) {
        this.startPoint = startPoint;
        this.destination = destination;
        this.dateDepart = dateDepart;
        this.dateArrival = dateArrival;
        this.driver = driver;
    }

    public Transport() {
    }

    public Driver getDriver() {
        return driver;
    }

    public String getDestination() {
        return destination;
    }

    // part of task 7

    public static Comparator<Transport> destinationComparator = new Comparator<Transport>() {
        @Override
        public int compare(Transport t1, Transport t2) {
            return t1.getDestination().compareTo(t2.getDestination());
        }
    };

    @Override
    public String toString() {
        return "Transport{" +
                "startPoint='" + startPoint + '\'' +
                ", destination='" + destination + '\'' +
                ", dateDepart='" + dateDepart + '\'' +
                ", dateArrival='" + dateArrival + '\'' +
                ", driver=" + driver +
                '}';
    }
}
