package com.company;

public class Good {
    private double weight;

    public Good(double weight) {
        this.weight = weight;
    }

    public Good() {
    }

    @Override
    public String toString() {
        return "Good{" +
                "weight=" + weight +
                '}';
    }
}
