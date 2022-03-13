package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class CotCalculator extends AbstractFunction {
    private CosCalculator cosCalculator;
    private SinCalculator sinCalculator;

    {
        getStubsTable().put(PI, tan(PI));
        getStubsTable().put(-PI, tan(-PI));
        getStubsTable().put(-PI / 2, tan(-PI / 2));
        getStubsTable().put(0.0, tan(0.0));
        getStubsTable().put(PI / 2, tan(PI / 2));
        getStubsTable().put(PI, tan(PI));
        getStubsTable().put(3 * PI / 4, tan(3 * PI / 4));
        getStubsTable().put(-3 * PI / 4, tan(-3 * PI / 4));
        getStubsTable().put( PI / 4, tan(PI / 4));
        getStubsTable().put(-PI / 4, tan(-PI / 4));
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
