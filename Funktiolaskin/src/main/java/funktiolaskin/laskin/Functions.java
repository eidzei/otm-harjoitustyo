package funktiolaskin.laskin;

import java.util.function.DoubleFunction;
import java.lang.Math;

public enum Functions {
    SQUERE("x\u00B2", (x) -> x * x),
    CUBE("x\u00B3", (x) -> x * x * x),
    ONEPERX("1/x", (x) -> 1 / x),
    SQUEROROOT("\u221A", (x) -> Math.sqrt(x)),
    CUBICROOT("\u221B", (x) -> Math.cbrt(x)),
    LNX("ln", (x) -> Math.log(x)),
    LOGTEN("log\u2081\u2080", (x) -> Math.log10(x)),
    SIN("sin", (x) -> Math.sin(x)),
    COS("cos", (x) -> Math.cos(x)),
    TAN("tan", (x) -> Math.tan(x));
    
    private final String symbol;
    private final DoubleFunction<Double> calculation;
    
    Functions(String symbol, DoubleFunction<Double> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public double laske(double x) {
        return calculation.apply(x);
    }

    @Override
    public String toString() {
        return symbol;
    }
    
}
