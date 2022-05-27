import com.company.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


public class Main {

    public static void main(String[] args){

        // use streams to sort drivers companies and transports !!!!

        // creating objects of classes

        Driver dr1 = new Driver("Stoyan", Qualification.INFLAMMABLE);
        Driver dr2 = new Driver("John", Qualification.MORETHAN12PERSON);
        Driver dr3 = new Driver("Rick", Qualification.SPECIALLOAD);
        Driver dr4 = new Driver("Rick", Qualification.MORETHAN12PERSON);



        Client cl1 = new Client("Ivan");
        Client cl2 = new Client("Pesho");
        Client cl3 = new Client("Mimi");
        Client cl4 = new Client("Niki");

        Good g1 = new Good(200);
        Good g2 = new Good(50);

        Vehicle v1 = new Vehicle(VehicleType.BUS);
        Vehicle v2 = new Vehicle(VehicleType.CAR);
        Vehicle v3 = new Vehicle(VehicleType.CAR);
        Vehicle v4 = new Vehicle(VehicleType.TRUCK);

        Transport t1 = new Transport("Sofia", "Burgas","25/06/21", "26/06/21", dr1);
        Transport t2 = new Transport("Obelya", "Mladost","30/06/21", "30/06/21", dr2);
        Transport t3 = new Transport("Pernik", "Vladaya","04/07/21", "04/07/21", dr3);

        TransportCompanyRegister register = new TransportCompanyRegister();

        TransportCompany dhl = new TransportCompany("DHL");
        TransportCompany yellow = new TransportCompany("Yellow");
        TransportCompany maxim = new TransportCompany("Maxim");

        // adding removing and showing results

        register.addCompany(dhl);
        register.addCompany(yellow);
        register.addCompany(maxim);

        dhl.addDrivers(dr1);
        dhl.addDrivers(dr2);
        dhl.addClients(cl1);
        dhl.addClients(cl2);
        dhl.addVehicles(v1);
        dhl.addVehicles(v2);

        yellow.addDrivers(dr3);
        yellow.addDrivers(dr4);
        yellow.addClients(cl3);
        yellow.addClients(cl4);
        yellow.addVehicles(v3);
        yellow.addVehicles(v4);

        maxim.addDrivers(dr1);
        maxim.addClients(cl1);
        maxim.addClients(cl4);
        maxim.addVehicles(v4);

        System.out.println("Drivers before removing: ");
        maxim.showDrivers();
        System.out.println("Clients before removing: ");
        maxim.showClients();
        System.out.println("Vehicles before removing: ");
        maxim.showVehicles();
        System.out.println();

        System.out.println("Drivers after removing: ");
        maxim.removeDriver(dr1);
        maxim.showDrivers();
        System.out.println("Clients after removing: ");
        maxim.removeClients(cl1);
        maxim.showClients();
        System.out.println("Vehicles after removing: ");
        maxim.removeVehicle(v4);
        maxim.showVehicles();
        System.out.println();

        System.out.println("Companies before removing: ");
        register.showCompanies();
        System.out.println("Companies after removing: ");
        register.removeCompany(maxim);
        register.showCompanies();
        System.out.println();

        // clients and obligations

        dhl.addClientToMapObligations(cl1, true);
        dhl.addClientToMapObligations(cl2, true);
        dhl.showIfObligationsArePaid();

        yellow.addClientToMapObligations(cl3, false);
        yellow.addClientToMapObligations(cl4, true);
        yellow.showIfObligationsArePaid();
        System.out.println();

        // make transports

        dhl.makeTransportWithGood(g1,t1);
        dhl.makeTransportWithGood(g2,t2);


        yellow.makeTransportWithClient(cl3, t3);

        // show transports cnt

            dhl.showTransportsCnt();
            yellow.showTransportsCnt();

        // get transport price

        dhl.addPricesToTransports(t1,300);
        dhl.addPricesToTransports(t2, 200);

        yellow.addPricesToTransports(t3,50);

        // set income by drivers

        dhl.setIncomePerDrivers();
        yellow.setIncomePerDrivers();


        // show drivers with income

        dhl.showDriversWithIncome();
        yellow.showDriversWithIncome();

        // show income

        System.out.println("DHL income: " + dhl.showIncome());
        System.out.println("Yellow income: " + yellow.showIncome());
        System.out.println();

        // write transport data into file
        String filename="files/TransportInfo.txt";
        TransportCompany.writeTransportIntoFile(filename, t1);
        TransportCompany.writeTransportIntoFile(filename, t2);
        TransportCompany.writeTransportIntoFile(filename, t3);

        // read data from file
        List<String> goodsFromFile=new ArrayList<>(TransportCompany.readTransportsFromFile(filename));

        System.out.println();
        System.out.println("Data from file: ");
        goodsFromFile.forEach(
                (line) -> {
                    System.out.println(line);
                }
        );
        System.out.println();

       // sort data for companies, drivers and transports

        // for companies by name and income

        Stream<TransportCompany> companyStream = register.getRegister().stream();
        System.out.println("Sorted companies by name: ");
        companyStream.sorted(TransportCompany.ComparatorByName)
                .forEach(System.out::println);

        companyStream = register.getRegister().stream();
        System.out.println("Sorted companies by income: ");
        companyStream.sorted(TransportCompany.ComparatorByIncome)
                .forEach(System.out::println);
        System.out.println();

        // for drivers by qualification and salary

        Stream<Driver> driversStream = dhl.getDrivers().stream();
        System.out.println("Sorted drivers by qualification: ");
        driversStream.sorted(Driver.ComparatorByQualification)
                .forEach(System.out::println);

        driversStream = dhl.getDrivers().stream();
        System.out.println("Sorted drivers by salary: ");
        driversStream.sorted(Driver.ComparatorBySalary)
                .forEach(System.out::println);
        System.out.println();

        // for transports

        Stream<Transport> transportsStream = dhl.getMapPrices().keySet().stream();
        System.out.println("Sorted transports by destination : ");
       transportsStream.sorted(Transport.destinationComparator)
                .forEach(System.out::println);




































    }
}
