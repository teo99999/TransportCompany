package com.company;

import java.util.Comparator;

public class Driver {
    private String name;
    private double salary;
    private int numTransportsByDriver;
    private Qualification qualification;


    public Driver(String name, Qualification qualification) {
        this.name = name;
        this.qualification = qualification;
        this.salary = 0;
        this.numTransportsByDriver = 0;
    }

    public Driver(double salary) {
        this.salary = salary;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary += salary;
    }

    public int getNumTransportsByDriver() {
        return numTransportsByDriver;
    }

    public void setNumTransportsByDriver(int numTransportsByDriver) {
        this.numTransportsByDriver += numTransportsByDriver;
    }

    // part of task 7

    public static Comparator<Driver> ComparatorByQualification = new Comparator<Driver>() {
        @Override
        public int compare(Driver d1, Driver d2) {
            return Integer.compare(d1.qualification.getNum(), d2.qualification.getNum());
        }
    };

    public static Comparator<Driver> ComparatorBySalary = new Comparator<Driver>() {
        @Override
        public int compare(Driver d1, Driver d2) {
            return Double.compare(d1.salary, d2.salary);
        }
    };


    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", qualification=" + qualification +
                '}';
    }
}
