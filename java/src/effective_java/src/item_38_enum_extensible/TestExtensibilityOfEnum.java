package item_38_enum_extensible;

public class TestExtensibilityOfEnum {

    public static void main(String[] args) {
        float a = 10;
        double b = 20;
        test(BasicOperation.class, a, b);
        test(ComplexOperation.class, a, b);
    }

    private static <T extends Enum<T> & Operation>
    void test (Class<T> opEnumType, double a, double b) {
        for (Operation operation : opEnumType.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", a, operation, b, operation.apply(a, b));
    }

}

interface Operation {
    double apply(double a, double b);
}

enum BasicOperation implements Operation{
    PLUS("+") {
        @Override
        public double apply(double a, double b) {
            return a + b;
        }
    },

    MINUS("-") {
        @Override
        public double apply(double a, double b) {
            return a - b;
        }
    };

    private final String symbol;
    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}

enum ComplexOperation implements Operation {

    PLUS("^") {
        @Override
        public double apply(double a, double b) {
            return Math.pow(a, b);
        }
    },

    MINUS("%") {
        @Override
        public double apply(double a, double b) {
            return a % b;
        }
    };

    private final String symbol;
    ComplexOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

}