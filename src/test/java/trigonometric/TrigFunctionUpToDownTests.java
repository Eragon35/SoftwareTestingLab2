package trigonometric;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import tpo.trigonometric.*;
import tpo.util.CsvWriter;

import static java.lang.Math.PI;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Trigonometric function")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TrigFunctionUpToDownTests {
    private TrigonometricCalculator trigonometricCalculator;
    private CosCalculator cosCalculator;
    private CotCalculator cotCalculator;
    private CscCalculator cscCalculator;
    private SecCalculator secCalculator;
    private SinCalculator sinCalculator;
    private CsvWriter logger = new CsvWriter("trigonometric/trig.csv", -15.0, 0.0, 0.5);
    private final double ACCURACY = 0.001;
    private final double DELTA = 0.05;


    @BeforeAll
    void init() {
        this.cosCalculator = new CosCalculator(ACCURACY);
        this.cotCalculator = new CotCalculator(ACCURACY);
        this.cscCalculator = new CscCalculator(ACCURACY);
        this.secCalculator = new SecCalculator(ACCURACY);
        this.sinCalculator = new SinCalculator(ACCURACY);
        this.trigonometricCalculator = new TrigonometricCalculator(ACCURACY,
                                                                    cosCalculator,
                                                                    cotCalculator,
                                                                    cscCalculator,
                                                                    secCalculator,
                                                                    sinCalculator);
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("sec(x) is a stub")
    void secCalculatorIsStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;

        double cosStub = cosCalculator.getStubsTable().get(x);
        double cotStub = cotCalculator.getStubsTable().get(x);
        double cscStub = cscCalculator.getStubsTable().get(x);
        double secStub = secCalculator.getStubsTable().get(x);


        try {
            double actualResult = trigonometricCalculator.calculateStub(x, cosStub, cotStub, cscStub, secStub);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("cos(x) is a stub; sec(x) isn't a stub")
    void cosCalculatorIsStub(Double numerator, Double denominator, Double expectedResult) {
        double x = numerator * PI / denominator;

        double cosStub = cosCalculator.getStubsTable().get(x);
        double cotStub = cotCalculator.getStubsTable().get(x);
        double cscStub = cscCalculator.getStubsTable().get(x);
        double secStub = secCalculator.getStubsTable().get(x);

        try {
            double actualResult = trigonometricCalculator.calculateStub(x, cosStub, cotStub, cscStub, secStub);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest(name = "X = {0} * PI / {1}")
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("All calculators aren't stubs")
    void nothingIsStub(Double numerator, Double denominator, Double expectedResult) {
        try {
            double actualResult = trigonometricCalculator.calculateFunction(numerator * PI / denominator);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @Ignore
    @Test
    void log() {
        logger.log(cosCalculator);

        logger.setFilePath("trigonometric/sec-results.csv");
        logger.setLowerBorder(-5 * PI);
        logger.log(secCalculator);

        logger.setFilePath("trigonometric/function-results.csv");
        logger.log(trigonometricCalculator);
    }
}
