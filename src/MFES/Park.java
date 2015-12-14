package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Park extends ProviderEntity {
    private String name;
    private String address;
    private Number pricePerMinute = 0L;

    public Park(final String n, final String a, final Number ppm) {
        cg_init_Park_1(n, a, ppm);
    }

    public Park() {
    }

    public void cg_init_Park_1(final String n, final String a, final Number ppm) {
        name = n;
        address = a;
        pricePerMinute = ppm;

        return;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Number getCostPerMinute() {
        return pricePerMinute;
    }

    public void setCostPerMinute(final Number cpm) {
        pricePerMinute = cpm;
    }

    public String toString() {
        return "Park{" + "name := " + Utils.toString(name) + ", address := " +
        Utils.toString(address) + ", pricePerMinute := " +
        Utils.toString(pricePerMinute) + "}";
    }
}
