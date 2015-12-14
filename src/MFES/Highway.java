package MFES;

import org.overture.codegen.runtime.*;


@SuppressWarnings("all")
public class Highway extends ProviderEntity {
    private String name;
    private Number baseRate;
    private Number length;

    public Highway(final String hName, final Number hBaseRate,
        final Number hLength) {
        cg_init_Highway_1(hName, hBaseRate, hLength);
    }

    public Highway() {
    }

    public void cg_init_Highway_1(final String hName, final Number hBaseRate,
        final Number hLength) {
        name = hName;
        baseRate = hBaseRate;
        length = hLength;

        return;
    }

    public String getName() {
        return name;
    }

    public Number getBaseRate() {
        return baseRate;
    }

    public Number getLength() {
        return length;
    }

    public Number calculatePrice(final Vehicle v, final Number l) {
        return MultiplierForClass(((Object) v.getVehicleClass())).doubleValue() * l.longValue() * baseRate.longValue();
    }

    public static Number MultiplierForClass(final Object cl) {
        Number casesExpResult_1 = null;

        Object quotePattern_1 = cl;
        Boolean success_1 = Utils.equals(quotePattern_1,
                MFES.quotes.IQuote.getInstance());

        if (!(success_1)) {
            Object quotePattern_2 = cl;
            success_1 = Utils.equals(quotePattern_2,
                    MFES.quotes.IIQuote.getInstance());

            if (!(success_1)) {
                Object quotePattern_3 = cl;
                success_1 = Utils.equals(quotePattern_3,
                        MFES.quotes.IIIQuote.getInstance());

                if (!(success_1)) {
                    Object quotePattern_4 = cl;
                    success_1 = Utils.equals(quotePattern_4,
                            MFES.quotes.IVQuote.getInstance());

                    if (!(success_1)) {
                        Object quotePattern_5 = cl;
                        success_1 = Utils.equals(quotePattern_5,
                                MFES.quotes.VQuote.getInstance());

                        if (success_1) {
                            casesExpResult_1 = 0.5;
                        }
                    } else {
                        casesExpResult_1 = 4L;
                    }
                } else {
                    casesExpResult_1 = 3L;
                }
            } else {
                casesExpResult_1 = 2L;
            }
        } else {
            casesExpResult_1 = 1L;
        }

        return casesExpResult_1;
    }

    public String toString() {
        return "Highway{" + "name := " + Utils.toString(name) +
        ", baseRate := " + Utils.toString(baseRate) + ", length := " +
        Utils.toString(length) + "}";
    }
}
