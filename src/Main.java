import MFES.*;
import MFES.quotes.IIQuote;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static GreenWayManagement management = new GreenWayManagement();

    static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    static ArrayList<Device> devices = new ArrayList<Device>();

    public static void runTests() {
        try {
            TestGreenWaySystem test = new TestGreenWaySystem();

            test.testClient_Create();
            test.testClient_Debt();
            test.testClient_Devices();

            test.testDevice_Create();
            test.testDevice_History();

            test.testGenericEntry_Create();

            test.testGreenWayManagement_AddClient();
            test.testGreenWayManagement_AddProvider();
            test.testGreenWayManagement_RemoveClient();
            test.testGreenWayManagement_RemoveProvider();

            test.testHighway_CalculatePrice();
            test.testHighway_Create();

            test.testHighwayRouteEntry_Create();

            test.testPark_ChangeCost();
            test.testPark_Create();

            test.testRoute_Create();
            test.testRoute_PriceCalc();

            test.testVehicle_Create();
        } catch (Exception e) {
            System.out.println("Test exception: " + e);
        }
    }

    public static void adicionarCliente() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Nome: ");

            String nome = scanner.next();

            System.out.print("CC: ");

            String cc = scanner.next();

            System.out.print("NIF: ");

            String nif = scanner.next();

            System.out.print("NIB: ");

            String nib = scanner.next();

            Client cl = new Client(nome, Integer.valueOf(cc), Integer.valueOf(nif), Integer.valueOf(nib));

            management.addClient(cl);

            System.out.println("ID Client: " + (management.getClients().size() - 1));

            System.out.println("Success!");
        } catch (Exception e) {
            System.out.println("Error when adding a client!");
        }
    }

    public static void adicionarHighway() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Name: ");

            String nome = scanner.next();

            System.out.print("Price/KM: ");

            String rate = scanner.next();

            System.out.print("Length (KM): ");

            String length = scanner.next();

            Highway h = new Highway(nome, Integer.valueOf(rate), Integer.valueOf(length));

            management.addProvider(h);

            System.out.println("ID Highway: " + (management.getProviders().size() - 1));
        } catch (Exception e) {
            System.out.println("Error when adding a highway!");
        }
    }

    public static void adicionarVehicle() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Make: ");

            String marca = scanner.next();

            System.out.print("Plate: ");

            String plate = scanner.next();

            System.out.print("Class 2 auto-selected.");

            Vehicle v = new Vehicle(marca, plate, IIQuote.getInstance());

            vehicles.add(v);

            System.out.println("ID Vehicle: " + (vehicles.size() - 1));
        } catch (Exception e) {
            System.out.println("Error when adding a vehicle!");
        }
    }

    public static void adicionarDevice() {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Client ID: ");

            String cliID = scanner.next();

            Client c = (Client) management.getClients().toArray()[Integer.valueOf(cliID)];

            System.out.print("Vehicle ID: ");

            String vehID = scanner.next();

            Vehicle v = vehicles.get(Integer.valueOf(vehID));

            Device d = new Device("RandIdentifier", v, c);

            c.addDevice(d);

            devices.add(d);

            System.out.println("ID Device: " + (devices.size() - 1));
        } catch (Exception e) {
            System.out.println("Error when adding a device!");
        }
    }

    public static void chargeDevice() {
        try {
            MFES.Date dummyDate1 = new MFES.Date(1, 1, 1, 1, 1, 1);
            MFES.Date dummyDate2 = new MFES.Date(2, 2, 2, 2, 2, 2);

            Scanner scanner = new Scanner(System.in);

            System.out.print("Device ID: ");

            String devID = scanner.next();

            Device d = devices.get(Integer.valueOf(devID));

            System.out.print("Highway ID: ");

            String hwID = scanner.next();

            Highway h = (Highway) management.getProviders().toArray()[Integer.valueOf(hwID)];

            System.out.print("Kilometers: ");

            String km = scanner.next();

            HighwayRouteEntry e = new HighwayRouteEntry(h, Integer.valueOf(km), dummyDate1, dummyDate2);

            Route r = new Route();

            r.addHighwayEntry(e);

            d.addToHistory(r);

            System.out.println("To pay: " + r.getValueToPay(d.getVehicle()));

            int toPay = 0;

            for (Object ent : d.getHistory().toArray())
                toPay += ((Entry) ent).getValueToPay(d.getVehicle()).intValue();

            System.out.println("Total to pay for this device, so far: " + toPay);

        } catch (Exception e) {
            System.out.println("Error when charging a device!");

            System.out.println(e);
        }
    }

    public static void menu() {
        System.out.println("| -> Green Way Management");
        System.out.println("| ");
        System.out.println("| 1. Run Tests");
        System.out.println("| 2. Add Client");
        System.out.println("| 3. Add Highway");
        System.out.println("| 4. Add Vehicle");
        System.out.println("| 5. Add Device");
        System.out.println("| 6. Charge Device");
        System.out.println("| 0. Quit");

        System.out.println();

        System.out.print("Choice: ");

        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {
            case 1:

                runTests();

                System.out.println();

                System.out.println("All done!");

                break;

            case 2:

                System.out.println();

                adicionarCliente();

                break;

            case 3:

                System.out.println();

                adicionarHighway();

                break;

            case 4:

                System.out.println();

                adicionarVehicle();

                break;

            case 5:

                System.out.println();

                adicionarDevice();

                break;

            case 6:

                System.out.println();

                chargeDevice();

                break;

            case 0:

                System.exit(0);

                break;

            default:

                break;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        while (true)
            menu();
    }
}
