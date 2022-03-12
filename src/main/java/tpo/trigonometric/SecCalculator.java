package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.PI;
import static java.lang.Math.cos;

public class SecCalculator extends AbstractFunction {
    private CosCalculator cosCalculator;

    {
        //todo: add more constants
        getStubsTable().put(PI, 1 / cos(PI));
    }

    public SecCalculator(Double accuracy) {
        super(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
    }

    public Double calculateFunction(Double arg){
        return 1 / cosCalculator.calculateFunction(arg);
    }
}
