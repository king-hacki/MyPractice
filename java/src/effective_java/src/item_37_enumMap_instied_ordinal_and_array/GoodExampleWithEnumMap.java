package item_37_enumMap_instied_ordinal_and_array;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;

public class GoodExampleWithEnumMap {

    public static void main(String[] args) {

        //  create EnumMap where key is enum and value is set
        Map<Plant.LifeTime, Set<Plant>> plantsByLifeTime = new EnumMap<>(Plant.LifeTime.class);

        //  init current map key - constant and  Sets by HashSet
        for (Plant.LifeTime lifeTime : Plant.LifeTime.values())
            plantsByLifeTime.put(lifeTime, new HashSet<>());

        //  now we get Plant form garden array and add to set by appropriate key lifeTime
        for (Plant plant : Garden.garden)
            plantsByLifeTime.get(plant.lifeTime).add(plant);

        System.out.println(plantsByLifeTime);

        //  stream-base approach but doesn't use EnumMap
        //  groupingBy grouping elements according to a classification function,
        //  and returning the results in a {@code Map}.
        System.out.println(Arrays.stream(Garden.garden)
                .collect(groupingBy(plant -> plant.lifeTime)));

        // Using a stream and an EnumMap to associate data with an enum
        System.out.println(Arrays.stream(Garden.garden)
                .collect(groupingBy(plant -> plant.lifeTime,
                        () -> new EnumMap<>(Plant.LifeTime.class), toSet())));
    }

}
