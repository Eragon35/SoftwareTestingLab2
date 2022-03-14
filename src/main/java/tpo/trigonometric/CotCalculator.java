package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class CotCalculator extends AbstractFunction {
    private final CosCalculator cosCalculator;
    private final SinCalculator sinCalculator;

    {
        getStubsTable().put(PI, 1 / tan(PI));
        getStubsTable().put(-PI, 1 / tan(-PI));
        getStubsTable().put(-PI / 2, 1 / tan(-PI / 2));
        getStubsTable().put(0.0, 1 / tan(0.0));
        getStubsTable().put(PI / 2, 1 / tan(PI / 2));
        getStubsTable().put(3 * PI / 4, 1 / tan(3 * PI / 4));
        getStubsTable().put(-3 * PI / 4, 1 / tan(-3 * PI / 4));
        getStubsTable().put( PI / 4, 1 / tan(PI / 4));
        getStubsTable().put(-PI / 4, 1 / tan(-PI / 4));
        getStubsTable().put(-PI / 6, 1 / tan(-PI / 6));
        getStubsTable().put(-PI / 3, 1 / tan(-PI / 3));
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
