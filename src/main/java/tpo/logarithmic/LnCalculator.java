package tpo.logarithmic;

import tpo.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.*;


public class LnCalculator extends AbstractFunction {
    {
        getStubsTable().put(E, log(Math.E));
    }

    public LnCalculator(double accuracy){ super(accuracy);}

    @Override
    public Double calculateFunction(Double x) {
        if (isNaN(x) || x < 0.0) { return NaN; }

        if (x == POSITIVE_INFINITY) { return POSITIVE_INFINITY; }

        if (x == 0.0) { return NEGATIVE_INFINITY; }

        double value = 0;
        double prevValue;
        int n = 1;
        int k = 1;
        if (Math.abs(x - 1) <= 1) {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, n) * Math.pow(x - 1, n)) / n);
                n++;
            } while (getAccuracy() <= Math.abs(value - prevValue));
        } else {
            do {
                prevValue = value;
                value -= ((Math.pow(-1, k) * Math.pow(x - 1, -k)) / k);
                k++;
            } while (getAccuracy() <= Math.abs(value - prevValue));
            value += this.calculateFunction(x - 1);
        }
        return value;
    }
}
