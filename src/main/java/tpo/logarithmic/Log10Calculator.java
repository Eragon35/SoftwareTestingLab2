package tpo.logarithmic;

import tpo.AbstractFunction;

import static java.lang.Double.*;
import static java.lang.Math.*;


public class Log10Calculator extends AbstractFunction {
    private LnCalculator ln;
    {
        getStubsTable().put(POSITIVE_INFINITY, log10(POSITIVE_INFINITY));
        getStubsTable().put(10.0 - 0.01, log10(10.0 - 0.01));
        getStubsTable().put(10.0, log10(10.0));
        getStubsTable().put(10.0 + 0.01, log10(10.0 + 0.01));
        getStubsTable().put(0.0 - 0.01, log10(0.0 - 0.01));
        getStubsTable().put(0.0, log10(0.0));
        getStubsTable().put(0.0 + 0.01, log10(0.0 + 0.01));
        getStubsTable().put(1.0 - 0.01, log10(1.0 - 0.01));
        getStubsTable().put(1.0, log10(1.0));
        getStubsTable().put(1.0 + 0.01, log10(1.0 + 0.01));
    }

    public Log10Calculator(Double accuracy){
        super(accuracy);
        this.ln = new LnCalculator(accuracy);
    }

    @Override
    public Double calculateFunction(Double x) {
        return ln.calculateFunction(x) / ln.calculateFunction(2.0);
    }

    @Override
    public Double calculateStub(Double stub) {
        return stub / ln.getStubsTable().get(2.0);
    }
}
