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
public class TrigCalculatorUpToDownTests {
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
    @CsvSource(value = {"-3.14159265358979323846, -1",
            "-2.356194490192344928846, -0.70710678118",
            "-1.5707963267948966, 0.0",
            "-1.0471975511965976, 0.5",
            "-0.7853981633974483, 0.70710678118",
            "0.0, 1.0"})
    void cosTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cosCalculator.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"-2.356194490192344928846, 1.0",
            "-1.5707963267948966, 0.0",
            "-1.0471975511965976, -0.57735026919",
            "-0.7853981633974483, -1.0",
            "0.0, Infinity"})
    void cotTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cotCalculator.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"-2.356194490192344928846, -1.41421356237",
            "-1.5707963267948966, -1.0",
            "-1.0471975511965976, -1.15470053838",
            "-0.7853981633974483, -1.41421356237",
            "0.0, Infinity"})
    void cscTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, cscCalculator.calculateFunction(x), DELTA);
    }

    @ParameterizedTest
    @CsvSource(value = {"-3.14159265358979323846, -1",
            "-2.356194490192344928846, -1.41421356237",
            "-1.5707963267948966, Infinity",
            "-1.0471975511965976, 2.0",
            "-0.7853981633974483, 1.41421356237",
            "0.0, 1.0"})
    void secTest(Double x, Double expectedResult) {
        assertEquals(expectedResult, secCalculator.calculateFunction(x), DELTA);
    }
}
