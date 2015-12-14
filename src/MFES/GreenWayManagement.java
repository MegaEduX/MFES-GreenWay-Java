package MFES;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class GreenWayManagement {
    private VDMSet clients = SetUtil.set();
    private VDMSet providers = SetUtil.set();

    public GreenWayManagement() {
        cg_init_GreenWayManagement_1();
    }

    public void cg_init_GreenWayManagement_1() {
        return;
    }

    public void addClient(final Client gClient) {
        clients = SetUtil.union(SetUtil.set(gClient), Utils.copy(clients));
    }

    public void addProvider(final ProviderEntity gProvider) {
        providers = SetUtil.union(SetUtil.set(gProvider), Utils.copy(providers));
    }

    public void removeClient(final Client gClient) {
        clients = SetUtil.diff(Utils.copy(clients), SetUtil.set(gClient));
    }

    public void removeProvider(final ProviderEntity gProvider) {
        providers = SetUtil.diff(Utils.copy(providers), SetUtil.set(gProvider));
    }

    public VDMSet getClients() {
        return Utils.copy(clients);
    }

    public VDMSet getProviders() {
        return Utils.copy(providers);
    }

    public String toString() {
        return "GreenWayManagement{" + "clients := " + Utils.toString(clients) +
        ", providers := " + Utils.toString(providers) + "}";
    }
}
