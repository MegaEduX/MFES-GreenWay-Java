package MFES.quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class IVQuote {
    private static int hc = 0;
    private static IVQuote instance = null;

    public IVQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static IVQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new IVQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof IVQuote;
    }

    public String toString() {
        return "<IV>";
    }
}
