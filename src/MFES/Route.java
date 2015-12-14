package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Route extends Entry {
    private VDMSeq entries = SeqUtil.seq();

    public Route() {
        cg_init_Route_1();
    }

    public void cg_init_Route_1() {
        return;
    }

    public void addHighwayEntry(final HighwayRouteEntry entry) {
        entries = SeqUtil.conc(Utils.copy(entries), SeqUtil.seq(entry));
    }

    public VDMSeq getEntries() {
        return Utils.copy(entries);
    }

    public Number getValueToPay(final Vehicle v) {
        Number value = 0.0;

        for (Iterator iterator_1 = entries.iterator(); iterator_1.hasNext();) {
            HighwayRouteEntry e = (HighwayRouteEntry) iterator_1.next();
            value = value.longValue() +
                e.getHighway().calculatePrice(v, e.getKilometers()).longValue();
        }

        return value;
    }

    public String toString() {
        return "Route{" + "entries := " + Utils.toString(entries) + "}";
    }
}
