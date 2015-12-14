package MFES;

import org.overture.codegen.runtime.*;


@SuppressWarnings("all")
public class TestGreenWaySystem extends MyTestCase {
    public TestGreenWaySystem() {
    }

    public void testClient_Create() {
        Client c = new Client("Joao", 1234567L, 201206113L, 0L);
        super.assertEqual("Joao", c.getName());
        super.assertEqual(1234567L, c.getCc());
        super.assertEqual(201206113L, c.getNif());
        super.assertEqual(0L, c.getNib());
        super.assertEqual(0L, c.getDebt());
        super.assertEqual(SetUtil.set(), c.getDevices());
    }

    public void testClient_Debt() {
        Client c = new Client("Joao", 1234567L, 201206113L, 0L);
        c.addToDebt(3241L);
        super.assertEqual(3241L, c.getDebt());
        c.payDebt(3200L);
        super.assertEqual(41L, c.getDebt());
    }

    public void testClient_Devices() {
        Client c = new Client("Joao", 1234567L, 201206113L, 0L);
        Vehicle v = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IIQuote.getInstance());
        Device d = new Device("Dispositivo1", v, c);
        c.addDevice(d);
        super.assertEqual(SetUtil.set(d), c.getDevices());
    }

    public void testDevice_Create() {
        Client c = new Client("Joao", 1234567L, 201206113L, 0L);
        Vehicle v = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IIQuote.getInstance());
        Device d = new Device("Dispositivo1", v, c);
        super.assertEqual("Dispositivo1", d.getId());
        super.assertEqual(v, d.getVehicle());
        super.assertEqual(c, d.getOwner());
    }

    public void testDevice_History() {
        Client c = new Client("Joao", 1234567L, 201206113L, 0L);
        Vehicle v = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IIQuote.getInstance());
        Device d = new Device("Dispositivo1", v, c);
        Park p = new Park("Aliados", "Avenida dos Aliados", 2L);
        GenericEntry mcDrive = new GenericEntry(500L, p);
        d.addToHistory(mcDrive);
        super.assertEqual(SeqUtil.seq(mcDrive), d.getHistory());
    }

    public void testGenericEntry_Create() {
        Vehicle v = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IIQuote.getInstance());
        Park p = new Park("Aliados", "Avenida dos Aliados", 2L);
        GenericEntry g = new GenericEntry(500L, p);
        super.assertEqual(500L, g.getValueToPay(v));
        super.assertEqual(p, g.getProvider());
    }

    public void testGreenWayManagement_AddClient() {
        GreenWayManagement m = new GreenWayManagement();
        Client c = new Client("Joao", 1234567L, 201206113L, 0L);
        Client d = new Client("Joaquim", 1234567L, 201206113L, 0L);
        m.addClient(c);
        m.addClient(d);
        super.assertEqual(SetUtil.set(c, d), m.getClients());
    }

    public void testGreenWayManagement_RemoveClient() {
        GreenWayManagement m = new GreenWayManagement();
        Client c = new Client("Joao", 1234567L, 201206113L, 0L);
        Client d = new Client("Joaquim", 1234567L, 201206113L, 0L);
        m.addClient(c);
        m.addClient(d);
        m.removeClient(c);
        super.assertEqual(SetUtil.set(d), m.getClients());
    }

    public void testGreenWayManagement_AddProvider() {
        GreenWayManagement m = new GreenWayManagement();
        Park p = new Park("Parque Ciloauto", "Rua Augusto Freitas", 2L);
        Highway h = new Highway("A41", 50L, 20L);
        m.addProvider(p);
        m.addProvider(h);
        super.assertEqual(SetUtil.set(p, h), m.getProviders());
    }

    public void testGreenWayManagement_RemoveProvider() {
        GreenWayManagement m = new GreenWayManagement();
        Park p = new Park("Parque Ciloauto", "Rua Augusto Freitas", 2L);
        Highway h = new Highway("A41", 50L, 20L);
        m.addProvider(p);
        m.addProvider(h);
        m.removeProvider(p);
        super.assertEqual(SetUtil.set(h), m.getProviders());
    }

    public void testHighway_Create() {
        Highway h = new Highway("A41", 50L, 20L);
        super.assertEqual("A41", h.getName());
        super.assertEqual(50L, h.getBaseRate());
        super.assertEqual(20L, h.getLength());
    }

    public void testHighway_CalculatePrice() {
        Highway h = new Highway("A41", 50L, 20L);
        Vehicle v1 = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IQuote.getInstance());
        Vehicle v2 = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IIQuote.getInstance());
        super.assertEqual(50L * 20L * 1L, h.calculatePrice(v1, 20L));
        super.assertEqual(50L * 20L * 2L, h.calculatePrice(v2, 20L));
    }

    public void testHighwayRouteEntry_Create() {
        Date entryDate = new Date(12L, 51L, 0L, 12L, 12L, 2012L);
        Date exitDate = new Date(13L, 0L, 0L, 12L, 12L, 2012L);
        Highway hw = new Highway("A42", 12.3, 20L);
        HighwayRouteEntry hre = new HighwayRouteEntry(hw, 7.0, entryDate,
                exitDate);
        super.assertEqual(hw, hre.getHighway());
        super.assertEqual(7.0, hre.getKilometers());
        super.assertEqual(entryDate, hre.getEntryDate());
        super.assertEqual(exitDate, hre.getExitDate());
    }

    public void testPark_Create() {
        Park p = new Park("Aliados", "Avenida dos Aliados", 2L);
        super.assertEqual(2L, p.getCostPerMinute());
        super.assertEqual("Aliados", p.getName());
        super.assertEqual("Avenida dos Aliados", p.getAddress());
    }

    public void testPark_ChangeCost() {
        Park p = new Park("Aliados", "Avenida dos Aliados", 2L);
        p.setCostPerMinute(5L);
        super.assertEqual(5L, p.getCostPerMinute());
    }

    public void testRoute_Create() {
        Date entryDate = new Date(12L, 51L, 0L, 12L, 12L, 2012L);
        Date exitDate = new Date(13L, 0L, 0L, 12L, 12L, 2012L);
        Highway hw = new Highway("A42", 12.3, 20L);
        HighwayRouteEntry hre = new HighwayRouteEntry(hw, 7.0, entryDate,
                exitDate);
        Route route = new Route();
        route.addHighwayEntry(hre);
        super.assertEqual(SeqUtil.seq(hre), route.getEntries());
    }

    public void testRoute_PriceCalc() {
        Vehicle v = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IIQuote.getInstance());
        Date entryDate = new Date(12L, 51L, 0L, 12L, 12L, 2012L);
        Date exitDate = new Date(13L, 0L, 0L, 12L, 12L, 2012L);
        Highway hw = new Highway("A42", 20L, 12.3);
        HighwayRouteEntry hre = new HighwayRouteEntry(hw, 7.0, entryDate,
                exitDate);
        Route route = new Route();
        route.addHighwayEntry(hre);
        super.assertEqual(280L, route.getValueToPay(v));
    }

    public void testVehicle_Create() {
        Vehicle v = new Vehicle("?", "1-1-1-1-",
                MFES.quotes.IIQuote.getInstance());
        super.assertEqual("?", v.getMake());
        super.assertEqual("1-1-1-1-", v.getPlate());
        super.assertEqual(MFES.quotes.IIQuote.getInstance(),
            ((Object) v.getVehicleClass()));
    }

    public String toString() {
        return "TestGreenWaySystem{}";
    }
}
