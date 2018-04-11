package funktiolaskin;

import java.util.function.DoubleBinaryOperator;


public enum Operaattori {
    JAKO("\u00F7", (x, y) -> x / y),
    KERTO("x", (x, y) -> x * y),
    VAHENNYS("-", (x, y) -> x - y),
    LISAYS("+", (x, y) -> x + y);
    
    
    private final String symboli;
    private final DoubleBinaryOperator lasku;


    Operaattori(String symboli, DoubleBinaryOperator lasku) {
        this.symboli = symboli;
        this.lasku = lasku;
    }

    public double laske(double x, double y) {
        return lasku.applyAsDouble(x, y);
    }

    @Override
    public String toString() {
        return symboli;
    }
}