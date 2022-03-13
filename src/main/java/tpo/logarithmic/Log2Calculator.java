package tpo.logarithmic;

import tpo.AbstractFunction;

public class Log2Calculator extends AbstractFunction {
    private LnCalculator ln;
    {
        getStubsTable().put(2.0, 1.0);
    }

    public Log2Calculator(Double accuracy){
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
