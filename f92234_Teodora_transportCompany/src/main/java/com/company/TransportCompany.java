package com.company;

import java.io.*;
import java.util.*;

public class TransportCompany {
    private String name;
    private int numOfTransportsByCompany;
    private double income;
    private Set<Client> clients;
    private Set<Driver> drivers;
    private Set<Vehicle> vehicles;
    private Map<Transport, Double> mapPrices;
    private Map<Client, Boolean> mapIsObligationPaid;
    private Map<Transport, Client> clientTransports;
    private Map<Transport, Good> goodTransports;

    public TransportCompany(String name) {
        this.name = name;
        this.numOfTransportsByCompany = 0;
        this.income = 0;
        this.clients = new HashSet<>();
        this.drivers = new HashSet<>();
        this.vehicles = new HashSet<>();
        this.mapPrices = new HashMap<>();
        this.mapIsObligationPaid = new HashMap<>();
        this.clientTransports = new HashMap<>();
        this.goodTransports = new HashMap<>();
    }

    public TransportCompany(Map<Transport, Double> mapPrices) {
        this.mapPrices = mapPrices;
    }

    public TransportCompany() {
    }


    public Map<Transport, Double> getMapPrices() {
        return mapPrices;
    }

    public double getIncome() {
        return income;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Set<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    // task 2

    // add clients
    public void addClients(Client client){
        this.clients.add(client);
    }

    // remove clients

    public void removeClients(Client client){
        this.clients.remove(client);
    }

    // task 3

    // add vehicles

    public void addVehicles(Vehicle vehicle){
        this.vehicles.add(vehicle);
    }

    // remove vehicles

    public void removeVehicle(Vehicle vehicle){
        this.vehicles.remove(vehicle);
    }

    // task 4

    // add drivers

    public void addDrivers(Driver driver){
        this.drivers.add(driver);
    }

    // remove drivers

    public void removeDriver(Driver driver){
        this.drivers.remove(driver);
    }

    public void showDrivers(){
        drivers.forEach(
                (driver -> {
                    System.out.println(driver);
                })
        );
    }

    public void showClients(){
        clients.forEach(
                (client -> {
                    System.out.println(client);
                })
        );
    }

    public void showVehicles(){
        vehicles.forEach(
                (vehicle -> {
                    System.out.println(vehicle);
                })
        );
    }

    public void addPricesToTransports(Transport tr, double price){
        this.mapPrices.put(tr, price);
    }


    // task 6 save info for paid obligations

    public void addClientToMapObligations(Client client, Boolean isPaid){
        this.mapIsObligationPaid.put(client, isPaid);
    }

    public void showIfObligationsArePaid(){
        this.mapIsObligationPaid.forEach(
                ((client, aBoolean) -> {
                    System.out.println(client);
                    System.out.println("Are the obligations paid: ");
                    System.out.println(aBoolean);
                })
        );
    }


    // task 8 save data for transport in file

    public static void writeTransportIntoFile(String outputFileName, Transport transport){
        FileWriter fout=null;
        try{
            fout=new FileWriter(new File(outputFileName),true);
            if(transport!=null){
                fout.append(transport.toString()+System.lineSeparator());
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found "+e);

        } catch (IOException e) {
            System.out.println("IOException "+e);
        } finally{
            try{
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e){
                System.out.println("IOException "+e);
            }
        }
    }

    public static List<String> readTransportsFromFile(String inputFileName){
        List<String> listOfTransports =new ArrayList<>();
        try(FileReader fis=new FileReader(new File(inputFileName))){
            BufferedReader bufferedReader=new BufferedReader(fis);
            String line;
            while((line=bufferedReader.readLine())!=null){
                listOfTransports.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return listOfTransports;
    }


    // task 9

    // make transports and increase number of transports by company and driver

    public void makeTransportWithClient(Client client, Transport transport){
        clientTransports.put(transport, client);
        System.out.println("|||||||||||||||||||");
        System.out.println("Transporting... ");
        System.out.println(client);
        System.out.println(transport);
        System.out.println("Company: " + this.name);
        System.out.println("|||||||||||||||||||");

        transport.getDriver().setNumTransportsByDriver(1);
        this.numOfTransportsByCompany++;

    }

    public void makeTransportWithGood(Good good, Transport transport){
        goodTransports.put(transport, good);
        System.out.println("|||||||||||||||||||");
        System.out.println("Transporting... ");
        System.out.println(good);
        System.out.println(transport);
        System.out.println("Company: " + this.name);
        System.out.println("|||||||||||||||||||");

        transport.getDriver().setNumTransportsByDriver(1);
        numOfTransportsByCompany++;


    }


    // set drivers income and then show it

    public void setIncomePerDrivers(){
        mapPrices.forEach(
                ((transport, price) -> {
                    transport.getDriver().setSalary(price);
                })
        );
    }

    public void showDriversWithIncome(){
        drivers.forEach(
                (driver -> {
                    System.out.println("*******************");
                    System.out.println(driver);
                    System.out.println("Transports count: " + driver.getNumTransportsByDriver());
                    System.out.println(driver.getSalary());
                    System.out.println("*******************");
                    System.out.println();
                })
        );
    }

    // show transports count

    public int showTransportsCnt(){
      return numOfTransportsByCompany;
    }



    // set and show income

    public double showIncome(){
        mapPrices.forEach(
                ((transport, price) -> {
                    this.income += price;
                })
        );
        return income;
    }

    // show drivers and transports by driver

    public void showDriversWithTransports(){
        drivers.forEach(
                (driver -> {
                    System.out.println("*******************");
                    System.out.println(driver);
                    System.out.println("Transports count: ");
                    System.out.println(driver.getNumTransportsByDriver());
                    System.out.println("*******************");
                })
        );
    }


    // part of task 7 comparators
    public static Comparator<TransportCompany> ComparatorByName = new Comparator<TransportCompany>() {
        @Override
        public int compare(TransportCompany tr1, TransportCompany tr2) {
            return tr1.name.compareTo(tr2.name);
        }

    };

    public static Comparator<TransportCompany> ComparatorByIncome = new Comparator<TransportCompany>() {
        @Override
        public int compare(TransportCompany tr1, TransportCompany tr2) {
            return Double.compare(tr1.income, tr2.income);
        }

    };

    public boolean enoughIncome(double minIncome) {
        return this.showIncome() >= minIncome;
    }

    @Override
    public String toString() {
        return "TransportCompany{" +
                "name='" + name + '\'' +
                ", numOfTransportsByCompany=" + numOfTransportsByCompany +
                ", income=" + income +
                '}';
    }
}
