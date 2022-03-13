package tpo;

import tpo.logarithmic.LogarithmicCalculator;
import tpo.trigonometric.TrigonometricCalculator;

public class SystemSolver {
    private TrigonometricCalculator trigonometricCalculator;
    private LogarithmicCalculator logarithmicCalculator;

    public SystemSolver(TrigonometricCalculator trigonometricCalculator, LogarithmicCalculator logarithmicCalculator) {
        this.trigonometricCalculator = trigonometricCalculator;
        this.logarithmicCalculator = logarithmicCalculator;
    }

    public Double calculate(Double x) {
        if (x <= 0) return trigonometricCalculator.calculateFunction(x);
        else return 0.0;
    }
}
