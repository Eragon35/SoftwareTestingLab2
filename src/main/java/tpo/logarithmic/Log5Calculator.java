package tpo.logarithmic;

import tpo.AbstractFunction;

import static java.lang.Double.*;

public class Log5Calculator extends AbstractFunction {
    private final LnCalculator ln;
    {
        getStubsTable().put(POSITIVE_INFINITY, POSITIVE_INFINITY);
        getStubsTable().put(5.0 - 0.01, 0.998756);
        getStubsTable().put(5.0, 1.0);
        getStubsTable().put(5.0 + 0.01, 1.00124);
        getStubsTable().put(0.0 - 0.01, NaN);
        getStubsTable().put(0.0, NEGATIVE_INFINITY);
        getStubsTable().put(0.0 + 0.01, -2.861353);
        getStubsTable().put(1.0 - 0.01, -0.00624462);
        getStubsTable().put(1.0, 0.0);
        getStubsTable().put(1.0 + 0.01, 0.00618249);
    }

    public Log5Calculator(Double accuracy){
        super(accuracy);
        this.ln = new LnCalculator(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(5.0);
    }

    @Override
    public Double calculateStub(Double stub) {
        return stub / ln.getStubsTable().get(5.0);
    }
}
