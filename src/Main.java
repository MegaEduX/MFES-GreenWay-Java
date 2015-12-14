import MFES.TestGreenWaySystem;

public class Main {

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

    public static void main(String[] args) {
        System.out.println("Running tests...");
	    runTests();
        System.out.println("Done!");
    }
}
