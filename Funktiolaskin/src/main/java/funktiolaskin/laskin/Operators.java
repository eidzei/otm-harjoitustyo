package funktiolaskin.laskin;

import java.util.function.BinaryOperator;


public enum Operators {
    DIVIDE("\u00F7", (x, y) -> x / y),
    MULTIPLY("*", (x, y) -> x * y),
    SUBTRACT("-", (x, y) -> x - y),
    ADD("+", (x, y) -> x + y);
    
    
    private final String symbol;
    private final BinaryOperator<Double> calculation;


    Operators(String symboli, BinaryOperator<Double> lasku) {
        this.symbol = symboli;
        this.calculation = lasku;
    }

    public double laske(double x, double y) {
        return calculation.apply(x, y);
    }

    @Override
    public String toString() {
        return symbol;
    }
}