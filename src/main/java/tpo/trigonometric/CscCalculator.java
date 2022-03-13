package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class CscCalculator extends AbstractFunction {
    private SinCalculator sinCalculator;
    {
        getStubsTable().put(PI, 1 / sin(PI));
        getStubsTable().put(-PI, 1 / sin(-PI));
        getStubsTable().put(-PI / 2, 1 / sin(-PI / 2));
        getStubsTable().put(0.0, 1 / sin(0.0));
        getStubsTable().put(PI / 2, 1 / sin(PI / 2));
        getStubsTable().put(PI, 1 / sin(PI));
        getStubsTable().put(3 * PI / 4, 1 / sin(3 * PI / 4));
        getStubsTable().put(-3 * PI / 4, 1 / sin(-3 * PI / 4));
        getStubsTable().put( PI / 4, 1 / sin(PI / 4));
        getStubsTable().put(-PI / 4, 1 / sin(-PI / 4));
    }

    public CscCalculator(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }

    public Double calculateFunction(Double arg){
        return 1 / sinCalculator.calculateFunction(arg);
    }
}
