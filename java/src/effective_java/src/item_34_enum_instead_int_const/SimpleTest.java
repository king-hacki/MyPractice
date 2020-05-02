package item_34_enum_instead_int_const;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleTest {

    public static void main(String[] args) {

        double x = 10.0;
        double y = 20.0;

        for (Operation operation : Operation.values())
            System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x, y));

        System.out.println(Operation.fromString("+").orElseThrow().apply(x, y));
    }

}

enum Operation {

    PLUS("+"){
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    } ;


    private final String symbol;
    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public abstract double apply(double x, double y);

    private final static Map<String, Operation> stringToEnum =
            Stream.of(values()).collect(Collectors.toMap(Object::toString, e -> e));

    public static Optional<Operation> fromString(String symbol) {
        return Optional.ofNullable(stringToEnum.get(symbol));
    }

}