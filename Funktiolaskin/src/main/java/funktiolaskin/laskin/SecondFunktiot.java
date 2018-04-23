package funktiolaskin.laskin;

import java.util.function.DoubleFunction;

public enum SecondFunktiot {
    ASIN("sin\u207B\u00B9", (x) -> Math.asin(x)),
    ACOS("cos\u207B\u00B9", (x) -> Math.acos(x)),
    ATAN("tan\u207B\u00B9", (x) -> Math.atan(x)),
    TWOTOX("2\u02E3", (x) -> Math.pow(2, x)),
    ETOX("e\u02E3", (x) -> Math.pow(Math.E, x)),
    TENTOX("10\u02E3", (x) -> Math.pow(10, x)),
    EXPM1("e\u02E3-1", (x) -> Math.expm1(x)),
    SINH("sinh", (x) -> Math.sinh(x)),
    COSH("cosh", (x) -> Math.cosh(x)),
    TANH("tanh", (x) -> Math.tanh(x));
    
    private final String symboli;
    private final DoubleFunction<Double> lasku;
    
    SecondFunktiot(String symboli, DoubleFunction<Double> lasku) {
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
