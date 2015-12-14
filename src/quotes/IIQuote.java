package quotes;

import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
public class IIQuote {
    private static int hc = 0;
    private static IIQuote instance = null;

    public IIQuote() {
        if (Utils.equals(hc, 0)) {
            hc = super.hashCode();
        }
    }

    public static IIQuote getInstance() {
        if (Utils.equals(instance, null)) {
            instance = new IIQuote();
        }

        return instance;
    }

    public int hashCode() {
        return hc;
    }

    public boolean equals(final Object obj) {
        return obj instanceof IIQuote;
    }

    public String toString() {
        return "<II>";
    }
}
