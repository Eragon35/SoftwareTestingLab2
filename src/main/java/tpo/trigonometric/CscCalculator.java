package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class CscCalculator extends AbstractFunction {
    private SinCalculator sinCalculator;
    {
        //todo: add more constants
        getStubsTable().put(PI, 1/sin(PI));
    }

    public CscCalculator(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }

    public Double calculateFunction(Double arg){
        return 1 / sinCalculator.calculateFunction(arg);
    }
}
