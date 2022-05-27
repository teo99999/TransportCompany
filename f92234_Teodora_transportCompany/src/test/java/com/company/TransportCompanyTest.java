package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class TransportCompanyTest {
    private TransportCompany transportCompany;
    private Transport t1 = new Transport();
    private Transport t2 = new Transport();
    private Good good = new Good();

    @BeforeEach
    void init(){
       Map<Transport, Double> map =  new HashMap<>();
       map.put(t1, 50.0);
       map.put(t2, 50.0);
        transportCompany = new TransportCompany(map);


    }

    @Test
    @DisplayName("Test income")
    void showIncome() {
        double expected = 100.0;
        double actual = transportCompany.showIncome();
        assertEquals(expected, actual);
    }



    @Test
    @DisplayName("Test income if zero")
    void showIncomeZero(){
        TransportCompany tr1 = new TransportCompany("No name");
        double expected = 0.0;
        double actual = tr1.showIncome();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test if income is enough")
    void enoughIncome(){
    assertTrue(transportCompany.enoughIncome(50));
    }
}