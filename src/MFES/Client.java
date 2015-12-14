package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Client {
    private String name;
    private Number cc;
    private Number nif;
    private Number nib;
    private Number debt;
    private VDMSet devices = SetUtil.set();

    public Client(final String cName, final Number cCC, final Number cNif,
        final Number cNib) {
        cg_init_Client_1(cName, cCC, cNif, cNib);
    }

    public Client() {
    }

    public void cg_init_Client_1(final String cName, final Number cCC,
        final Number cNif, final Number cNib) {
        name = cName;
        cc = cCC;
        nif = cNif;
        nib = cNib;
        debt = 0L;

        return;
    }

    public void addToDebt(final Number value) {
        debt = debt.longValue() + value.doubleValue();
    }

    public void payDebt(final Number value) {
        debt = debt.longValue() - value.longValue();
    }

    public void addDevice(final Device cDevice) {
        devices = SetUtil.union(SetUtil.set(cDevice), Utils.copy(devices));
    }

    public String getName() {
        return name;
    }

    public Number getCc() {
        return cc;
    }

    public Number getNif() {
        return nif;
    }

    public Number getNib() {
        return nib;
    }

    public Number getDebt() {
        return debt;
    }

    public VDMSet getDevices() {
        return Utils.copy(devices);
    }

    public String toString() {
        return "Client{" + "name := " + Utils.toString(name) + ", cc := " +
        Utils.toString(cc) + ", nif := " + Utils.toString(nif) + ", nib := " +
        Utils.toString(nib) + ", debt := " + Utils.toString(debt) +
        ", devices := " + Utils.toString(devices) + "}";
    }
}
