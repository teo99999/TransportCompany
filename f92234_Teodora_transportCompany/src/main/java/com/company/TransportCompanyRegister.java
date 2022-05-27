package com.company;

import java.util.ArrayList;
import java.util.List;

public class TransportCompanyRegister {
    private List<TransportCompany> register;

    public TransportCompanyRegister() {
        this.register = new ArrayList<>();
    }

    // task 1 add and remove company

    public void addCompany(TransportCompany transportCompany){
        this.register.add(transportCompany);
    }


    public void removeCompany(TransportCompany transportCompany){
        this.register.remove(transportCompany);
        transportCompany.setIncome(0);
        transportCompany.getClients().clear();
        transportCompany.getDrivers().clear();
        transportCompany.getVehicles().clear();

    }

    public void showCompanies(){
        register.forEach(
                (company -> {
                    System.out.println(company);
                })
        );
    }

    public List<TransportCompany> getRegister() {
        return register;
    }
}
