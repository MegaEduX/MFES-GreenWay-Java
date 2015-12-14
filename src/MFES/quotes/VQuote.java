package MFES.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class VQuote {
    private static int hc = 0;
    private static VQuote instance = null;

    public VQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static VQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new VQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof VQuote;
    }

    public String toString() {
        return "<V>";
    }
}
