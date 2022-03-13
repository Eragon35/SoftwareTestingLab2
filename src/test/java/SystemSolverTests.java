import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tpo.SystemSolver;
import tpo.logarithmic.*;
import tpo.trigonometric.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("System solver tests")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SystemSolverTests {
    private SystemSolver systemSolver;
    private final Double ACCURACY = 0.001;
    private final Double DELTA = 0.05;

    @BeforeAll
    void init(){
        this.systemSolver = new SystemSolver(
                new TrigonometricCalculator(ACCURACY,
                        new CosCalculator(ACCURACY),
                        new CotCalculator(ACCURACY),
                        new CscCalculator(ACCURACY),
                        new SecCalculator(ACCURACY),
                        new SinCalculator(ACCURACY)
                ), new LogarithmicCalculator(ACCURACY,
                        new LnCalculator(ACCURACY),
                        new Log2Calculator(ACCURACY),
                        new Log3Calculator(ACCURACY),
                        new Log5Calculator(ACCURACY),
                        new Log10Calculator(ACCURACY)
                )
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/system.csv")
    void systemSolverTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, systemSolver.calculate(x), DELTA);
    }
}
