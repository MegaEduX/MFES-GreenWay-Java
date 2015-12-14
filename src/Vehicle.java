import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Vehicle {
    private String make;
    private String plate;
    private Object cl;

    public Vehicle(final String vMake, final String vPlate, final Object vClass) {
        cg_init_Vehicle_1(vMake, vPlate, ((Object) vClass));
    }

    public Vehicle() {
    }

    public void cg_init_Vehicle_1(final String vMake, final String vPlate,
        final Object vClass) {
        make = vMake;
        plate = vPlate;
        cl = vClass;

        return;
    }

    public String getMake() {
        return make;
    }

    public String getPlate() {
        return plate;
    }

    public Object getVehicleClass() {
        return cl;
    }

    public String toString() {
        return "Vehicle{" + "make := " + Utils.toString(make) + ", plate := " +
        Utils.toString(plate) + ", cl := " + Utils.toString(cl) + "}";
    }
}
