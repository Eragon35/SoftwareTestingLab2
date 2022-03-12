package tpo;

import tpo.trigonometric.TrigonometricCalculator;

public class SystemSolver {
    private TrigonometricCalculator trigonometricCalculator;

    public SystemSolver(TrigonometricCalculator trigonometricCalculator) {
        this.trigonometricCalculator = trigonometricCalculator;
    }

    public Double calculate(Double x) {
        if (x <= 0) return trigonometricCalculator.calculateFunction(x);
        else return 0.0;
    }
}
