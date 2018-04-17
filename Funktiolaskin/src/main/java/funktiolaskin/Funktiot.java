package funktiolaskin;

import java.util.function.DoubleFunction;
import java.lang.Math;

public enum Funktiot {
    NELIO("x^2", (x) -> x * x),
    KUUTIO("x^3", (x) -> x * x * x),
    YKSPERX("1/x", (x) -> 1 / x),
    NELIOJUURI("\u221A", (x) -> Math.sqrt(x)),
    LNX("ln x", (x) -> Math.log(x)),
    LOGTEN("log10", (x) -> Math.log10(x)),
    SIN("sin", (x) -> Math.sin(x)),
    COS("cos", (x) -> Math.cos(x)),
    TAN("tan", (x) -> Math.tan(x));
    
    private final String symboli;
    private final DoubleFunction<Double> lasku;
    
    Funktiot(String symboli, DoubleFunction<Double> lasku) {
        this.symboli = symboli;
        this.lasku = lasku;
    }

    public double laske(double x) {
        return lasku.apply(x);
    }

    @Override
    public String toString() {
        return symboli;
    }
    
}
