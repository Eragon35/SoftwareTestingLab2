package tpo.logarithmic;

import tpo.AbstractFunction;

import static java.lang.Math.*;


public class LogarithmicCalculator extends AbstractFunction {
    private final LnCalculator lnCalc;
    private final Log2Calculator log2Calc;
    private final Log3Calculator log3Calc;
    private final Log5Calculator log5Calc;
    private final Log10Calculator log10Calc;

    public LogarithmicCalculator(Double accuracy, LnCalculator ln, Log2Calculator log2, Log3Calculator log3, Log5Calculator log5, Log10Calculator log10) {
        super(accuracy);
        this.lnCalc = ln;
        this.log2Calc = log2;
        this.log3Calc = log3;
        this.log5Calc = log5;
        this.log10Calc = log10;
    }

    @Override
    public Double calculateFunction(Double x) {
        if (x <= 0.0) { throw new IllegalArgumentException("X должен быть больше нуля"); }
        double ln = lnCalc.calculateFunction(x);
        double log2 = log2Calc.calculateFunction(x);
        double log3 = log3Calc.calculateFunction(x);
        double log5 = log5Calc.calculateFunction(x);
        double log10 = log10Calc.calculateFunction(x);

        return (pow((ln/log2), 3) / log2) - (ln / ln) + ((log10 + pow(log2, 3))/ log3) + (log3 - pow(pow(log5, 2), 2));
    }

    public Double calculateStub(Double x, Double ln, Double log2, Double log3, Double log5, Double log10) {
        if (x <= 0.0) { throw new IllegalArgumentException("X должен быть больше нуля"); }
        return (pow((ln/log2), 3) / log2) - (ln / ln) + ((log10 + pow(log2, 3))/ log3) + (log3 - pow(pow(log5, 2), 2));
    }
}
