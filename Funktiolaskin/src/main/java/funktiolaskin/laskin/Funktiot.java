package funktiolaskin.laskin;

import java.util.function.DoubleFunction;
import java.lang.Math;

public enum Funktiot {
    NELIO("x\u00B2", (x) -> x * x),
    KUUTIO("x\u00B3", (x) -> x * x * x),
    YKSPERX("1/x", (x) -> 1 / x),
    NELIOJUURI("\u221A", (x) -> Math.sqrt(x)),
    KUUTIOJUURI("\u221B", (x) -> Math.cbrt(x)),
    LNX("ln", (x) -> Math.log(x)),
    LOGTEN("log\u2081\u2080", (x) -> Math.log10(x)),
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
