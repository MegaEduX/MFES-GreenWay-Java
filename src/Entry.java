import org.overture.codegen.runtime.*;

import java.util.*;


@SuppressWarnings("all")
abstract public class Entry {
    public Entry() {
    }

    public abstract Number getValueToPay(final Vehicle v);

    public String toString() {
        return "Entry{}";
    }
}
