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
    private final CsvWriter logger = new CsvWriter("trigonometric/cos-results.csv", -15.0, 0.0, 0.5);
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

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("all are stubs")
    void allAreStubs(Double x, Double expectedResult) {

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

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("cos(x) is a stub; all other aren't a stub")
    void cosCalculatorIsStub(Double x, Double expectedResult) {
        double cosStub = cosCalculator.getStubsTable().get(x);
        double cot = cotCalculator.calculateFunction(x);
        double csc = cscCalculator.calculateFunction(x);
        double sec = secCalculator.calculateFunction(x);

        try {
            double actualResult = trigonometricCalculator.calculateStub(x, cosStub, cot, csc, sec);
            System.out.println(actualResult);
            assertEquals(expectedResult, actualResult, DELTA);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/trigonometric/trig.csv")
    @DisplayName("All calculators aren't stubs")
    void nothingIsStub(Double x, Double expectedResult) {
        try {
            double actualResult = trigonometricCalculator.calculateFunction(x);
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
