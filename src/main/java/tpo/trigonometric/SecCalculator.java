package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class SecCalculator extends AbstractFunction {
    private final CosCalculator cosCalculator;

    {
        getStubsTable().put(PI, 1 / cos(PI));
        getStubsTable().put(-PI, 1 / cos(-PI));
        getStubsTable().put(-PI / 2, 1 / cos(-PI / 2));
        getStubsTable().put(0.0, 1 / cos(0.0));
        getStubsTable().put(PI / 2, 1 / cos(PI / 2));
        getStubsTable().put(3 * PI / 4, 1 / cos(3 * PI / 4));
        getStubsTable().put(-3 * PI / 4, 1 / cos(-3 * PI / 4));
        getStubsTable().put( PI / 4, 1 / cos(PI / 4));
        getStubsTable().put(-PI / 4, 1 / cos(-PI / 4));
        getStubsTable().put(-PI / 6, 1 / cos(-PI / 6));
        getStubsTable().put(-PI / 3, 1 / cos(-PI / 3));
    }

    public SecCalculator(Double accuracy) {
        super(accuracy);
        this.cosCalculator = new CosCalculator(accuracy);
    }

    public Double calculateFunction(Double arg){
        return 1 / cosCalculator.calculateFunction(arg);
    }
}
