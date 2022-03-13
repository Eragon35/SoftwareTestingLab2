package logarithmic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tpo.logarithmic.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Log calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LogCalculatorUpToDown {
    private LnCalculator ln;
    private Log2Calculator log2;
    private Log3Calculator log3;
    private Log3Calculator log5;
    private Log10Calculator log10;
    private final double DELTA = 0.05;
    private final double ACCURACY = 0.001;

    @BeforeAll
    void init() {
        this.ln = new LnCalculator(ACCURACY);
        this.log2 = new Log2Calculator(ACCURACY);
        this.log3 = new Log3Calculator(ACCURACY);
        this.log5 = new Log3Calculator(ACCURACY);
        this.log10 = new Log10Calculator(ACCURACY);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "1.99, 0.992768", "2.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void log2Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log2.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "2.99, 0.996961", "3.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void log3Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log3.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "4.99, 0.998756", "5.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void log5Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log5.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "9.99, 0.999565", "10.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void log10Test(Double x, Double expectedResult) {
        assertEquals(expectedResult, log10.calculateFunction(x), DELTA);
    }
}
