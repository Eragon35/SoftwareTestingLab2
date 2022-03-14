package tpo;

import tpo.logarithmic.LogarithmicCalculator;
import tpo.trigonometric.TrigonometricCalculator;

public class SystemSolver {
    private final TrigonometricCalculator trigonometricCalculator;
    private final LogarithmicCalculator logarithmicCalculator;

    public SystemSolver(TrigonometricCalculator trigonometricCalculator, LogarithmicCalculator logarithmicCalculator) {
        this.trigonometricCalculator = trigonometricCalculator;
        this.logarithmicCalculator = logarithmicCalculator;
    }

    public Double calculate(Double x) {
        if (x <= 0) return trigonometricCalculator.calculateFunction(x);
        else return logarithmicCalculator.calculateFunction(x);
    }
}
