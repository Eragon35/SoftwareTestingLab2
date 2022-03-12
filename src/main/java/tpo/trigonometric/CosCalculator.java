package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class CosCalculator extends AbstractFunction {
    private SinCalculator sinCalculator;

    {
        //todo: add more constants
        getStubsTable().put(PI, cos(PI));
    }

    public CosCalculator(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }

    public Double calculateFunction(Double arg){
        return sinCalculator.calculateFunction(arg + PI / 2);
    }
}
