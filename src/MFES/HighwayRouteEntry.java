package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class HighwayRouteEntry {
    private Highway hw;
    private Number km;
    private Date entryD;
    private Date exitD;

    public HighwayRouteEntry(final Highway highway, final Number kilometers,
        final Date entryDate, final Date exitDate) {
        cg_init_HighwayRouteEntry_1(highway, kilometers, entryDate, exitDate);
    }

    public HighwayRouteEntry() {
    }

    public void cg_init_HighwayRouteEntry_1(final Highway highway,
        final Number kilometers, final Date entryDate, final Date exitDate) {
        hw = highway;
        km = kilometers;
        entryD = entryDate;
        exitD = exitDate;

        return;
    }

    public Highway getHighway() {
        return hw;
    }

    public Number getKilometers() {
        return km;
    }

    public Date getEntryDate() {
        return entryD;
    }

    public Date getExitDate() {
        return exitD;
    }

    public String toString() {
        return "HighwayRouteEntry{" + "hw := " + Utils.toString(hw) +
        ", km := " + Utils.toString(km) + ", entryD := " +
        Utils.toString(entryD) + ", exitD := " + Utils.toString(exitD) + "}";
    }
}
