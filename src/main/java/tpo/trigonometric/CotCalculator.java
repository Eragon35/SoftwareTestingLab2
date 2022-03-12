package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class CotCalculator extends AbstractFunction {
    private CosCalculator cosCalculator;
    private SinCalculator sinCalculator;

    {
        //todo: add more constants
        getStubsTable().put(PI, tan(PI));
    }

    public CotCalculator(Double accuracy) {
        super(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }

    public Double calculateFunction(Double arg){
        return cosCalculator.calculateFunction(arg) / sinCalculator.calculateFunction(arg);
    }
}
