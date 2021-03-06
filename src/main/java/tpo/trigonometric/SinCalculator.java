package tpo.trigonometric;

import lombok.Data;
import tpo.AbstractFunction;

import static java.lang.Math.*;

@Data
public class SinCalculator extends AbstractFunction {
    {
        getStubsTable().put(PI, sin(PI));
        getStubsTable().put(-PI, sin(-PI));
        getStubsTable().put(-PI / 2, sin(-PI / 2));
        getStubsTable().put(0.0, sin(0.0));
        getStubsTable().put(PI / 2, sin(PI / 2));
        getStubsTable().put(3 * PI / 4, sin(3 * PI / 4));
        getStubsTable().put(-3 * PI / 4, sin(-3 * PI / 4));
        getStubsTable().put( PI / 4, sin(PI / 4));
        getStubsTable().put(-PI / 4, sin(-PI / 4));
        getStubsTable().put(-PI / 6, sin(-PI / 6));
        getStubsTable().put(-PI / 3, sin(-PI / 3));
    }

    public SinCalculator(Double accuracy) {
        super(accuracy);
    }

    public Double calculateFunction(Double arg){
        double result = 0.0;
        double last;
        int i = 0;
        do {
            last = result;
            result += pow(-1, i) * pow(arg, 2 * i + 1) / factorial(2 * i + 1);
            i++;
        } while (abs(result - last) >= getAccuracy());
        return result;
    }

    public long factorial(int limit) {
        if (limit < -0.001) throw new IllegalArgumentException("Факториал должен быть больше 0");
        else return localFactorial(limit, 2, 1);
    }

    private long localFactorial(int limit, int curr, long ans){
        if (curr <= limit) return localFactorial(limit, curr + 1, ans * curr);
        else return ans;
    }
}
