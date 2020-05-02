package item_37_enumMap_instied_ordinal_and_array;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toMap;

public class ExtendedExampleCascade {

    public static void main(String[] args) {
        System.out.println(Phase.Transition.from(Phase.SOLID, Phase.GAS)); }}

// Using a nested EnumMap to associate data with enum pairs
enum Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
        BOIL(LIQUID, GAS),   CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);

        final Phase from;
        final Phase to;

        Transition(Phase from, Phase to) {
            this.from = from;
            this.to = to;
        }

        private static final Map<Phase, Map<Phase, Transition>>
                m = Stream.of(values()).collect(groupingBy(
                        t -> t.from,                                    //  input elements to keys
                        () -> new EnumMap<>(Phase.class),               //  implementing the downstream reduction
                        toMap(                                          //  implementing the downstream reduction
                                t -> t.to,                              //  keyMapper
                                t -> t,                                 //  valueMapper
                                (x, y) -> y,                            //  mergeFunction...?
                                () -> new EnumMap<>(Phase.class))));    //  Supplier new empty Map

        public static Transition from(Phase from, Phase to) {
            return m.get(from).get(to);
        }

    }
}
