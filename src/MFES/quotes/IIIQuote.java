package MFES.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class IIIQuote {
    private static int hc = 0;
    private static IIIQuote instance = null;

    public IIIQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static IIIQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new IIIQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof IIIQuote;
    }

    public String toString() {
        return "<III>";
    }
}
