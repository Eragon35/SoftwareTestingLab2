package tpo;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public abstract class AbstractFunction {
    private Map<Double, Double> stubsTable = new HashMap<>();
    private Double accuracy;

    public AbstractFunction(Double accuracy) {
        this.accuracy = accuracy;
    }

    public Double calculateStub(Double stub) {
        return calculateFunction(stub);
    }

    public abstract Double calculateFunction(Double x);
}