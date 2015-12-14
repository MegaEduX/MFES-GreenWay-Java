package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GenericEntry extends Entry {
    private Number val;
    private ProviderEntity ent;

    public GenericEntry(final Number value, final ProviderEntity entity) {
        cg_init_GenericEntry_1(value, entity);
    }

    public GenericEntry() {
    }

    public void cg_init_GenericEntry_1(final Number value,
        final ProviderEntity entity) {
        val = value;
        ent = entity;

        return;
    }

    public Number getValueToPay(final Vehicle v) {
        return val;
    }

    public ProviderEntity getProvider() {
        return ent;
    }

    public String toString() {
        return "GenericEntry{" + "val := " + Utils.toString(val) + ", ent := " +
        Utils.toString(ent) + "}";
    }
}
