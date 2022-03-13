package trigonometric;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import tpo.trigonometric.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Trigonometric calculator")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigCalculatorUpToDownTest {
    private CosCalculator cosCalculator;
    private CotCalculator cotCalculator;
    private CscCalculator cscCalculator;
    private SecCalculator secCalculator;
    private SinCalculator sinCalculator;
    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;

    @BeforeAll
    void init() {
        this.cosCalculator = new CosCalculator(ACCURACY);
        this.cotCalculator = new CotCalculator(ACCURACY);
        this.cscCalculator = new CscCalculator(ACCURACY);
        this.secCalculator = new SecCalculator(ACCURACY);
        this.sinCalculator = new SinCalculator(ACCURACY);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "1.99, 0.992768", "2.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void cosTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cosCalculator.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "1.99, 0.992768", "2.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void cotTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cotCalculator.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "1.99, 0.992768", "2.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void cscTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cscCalculator.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "1.99, 0.992768", "2.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void secTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, secCalculator.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"Infinity, Infinity", "1.99, 0.992768", "2.0, 1.0", "-0.01, NaN", "0.0, -Infinity"})
    void sinTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, sinCalculator.calculateFunction(x), DELTA);
    }



}
