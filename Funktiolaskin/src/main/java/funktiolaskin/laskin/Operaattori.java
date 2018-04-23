package funktiolaskin.laskin;

import java.util.function.BinaryOperator;


public enum Operaattori {
    JAKO("\u00F7", (x, y) -> x / y),
    KERTO("*", (x, y) -> x * y),
    VAHENNYS("-", (x, y) -> x - y),
    LISAYS("+", (x, y) -> x + y);
    
    
    private final String symboli;
    private final BinaryOperator<Double> lasku;


    Operaattori(String symboli, BinaryOperator<Double> lasku) {
        this.symboli = symboli;
        this.lasku = lasku;
    }

    public double laske(double x, double y) {
        return lasku.apply(x, y);
    }

    @Override
    public String toString() {
        return symboli;
    }
}