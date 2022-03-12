import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import tpo.SystemSolver;
import tpo.trigonometric.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("System solver tests")
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
                )
        );
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/system-data.csv")
    void systemSolverTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, systemSolver.calculate(x), DELTA);
    }

}
