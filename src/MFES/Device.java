package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class Device {
    private String id;
    private Vehicle vehicle;
    private Client owner;
    private VDMSeq history = SeqUtil.seq();

    public Device(final String dId, final Vehicle dVehicle, final Client dOwner) {
        cg_init_Device_1(dId, dVehicle, dOwner);
    }

    public Device() {
    }

    public void cg_init_Device_1(final String dId, final Vehicle dVehicle,
        final Client dOwner) {
        id = dId;
        vehicle = dVehicle;
        owner = dOwner;

        return;
    }

    public void addToHistory(final Entry dEntry) {
        history = SeqUtil.conc(SeqUtil.seq(dEntry), Utils.copy(history));
    }

    public VDMSeq getHistory() {
        return Utils.copy(history);
    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Client getOwner() {
        return owner;
    }

    public String toString() {
        return "Device{" + "id := " + Utils.toString(id) + ", vehicle := " +
        Utils.toString(vehicle) + ", owner := " + Utils.toString(owner) +
        ", history := " + Utils.toString(history) + "}";
    }
}
