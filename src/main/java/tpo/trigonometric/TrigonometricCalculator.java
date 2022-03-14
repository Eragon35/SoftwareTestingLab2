package tpo.trigonometric;

import tpo.AbstractFunction;

public class TrigonometricCalculator extends AbstractFunction {
    private final CosCalculator cosCalculator;
    private final CotCalculator cotCalculator;
    private final CscCalculator cscCalculator;
    private final SecCalculator secCalculator;
    private final SinCalculator sinCalculator;

    public TrigonometricCalculator(Double accuracy,
                                   CosCalculator cosCalculator,
                                   CotCalculator cotCalculator,
                                   CscCalculator cscCalculator,
                                   SecCalculator secCalculator,
                                   SinCalculator sinCalculator) {
        super(accuracy);
        this.cosCalculator = cosCalculator;
        this.cotCalculator = cotCalculator;
        this.cscCalculator = cscCalculator;
        this.secCalculator = secCalculator;
        this.sinCalculator = sinCalculator;
    }

    public Double calculateFunction(Double x) {
        if (x > 0.0) throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        double cos = cosCalculator.calculateFunction(x);
        double cot = cotCalculator.calculateFunction(x);
        double csc = cscCalculator.calculateFunction(x);
        double sec = secCalculator.calculateFunction(x);
        double sin = sinCalculator.calculateFunction(x);
        return (cot / sec - csc) * (sec * sec) * (cos + sec);
    }

    public Double calculateStub(Double x, Double cos, Double cot, Double csc, Double sec){
        if (x > 0.0) throw new IllegalArgumentException("X должен быть меньше или равен нулю");
        System.out.println(cos + " " + cot + " " + csc + " " + sec);
        return (cot / sec - csc) * (sec * sec) * (cos + sec);
    }
}
