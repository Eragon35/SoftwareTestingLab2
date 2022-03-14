package tpo.trigonometric;

import tpo.AbstractFunction;

import static java.lang.Math.*;

public class CosCalculator extends AbstractFunction {
    private final SinCalculator sinCalculator;

    {
        getStubsTable().put(PI, cos(PI));
        getStubsTable().put(-PI, cos(-PI));
        getStubsTable().put(-PI / 2, cos(-PI / 2));
        getStubsTable().put(0.0, cos(0.0));
        getStubsTable().put(PI / 2, cos(PI / 2));
        getStubsTable().put(3 * PI / 4, cos(3 * PI / 4));
        getStubsTable().put(-3 * PI / 4, cos(-3 * PI / 4));
        getStubsTable().put( PI / 4, cos(PI / 4));
        getStubsTable().put(-PI / 4, cos(-PI / 4));
        getStubsTable().put(-PI / 6, cos(-PI / 6));
        getStubsTable().put(-PI / 3, cos(-PI / 3));
    }

    public CosCalculator(Double accuracy) {
        super(accuracy);
        this.sinCalculator = new SinCalculator(accuracy);
    }

    public Double calculateFunction(Double arg){
        return sinCalculator.calculateFunction(arg + PI / 2);
    }

    public static void main(String[] args) {
        System.out.println(PI / 4);
    }
}
