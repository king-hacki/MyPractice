package item_37_enumMap_instied_ordinal_and_array;

import java.util.HashSet;
import java.util.Set;

public class BadExampleWithOrdinal {

    //  organized our garde into 3 Set by lifeTime
    // Using ordinal() to index into an array - DON'T DO THIS!
    public static void main(String[] args) {

        //  create array with 3 Set for each lifeTime
        Set<Plant> [] plantsByLifeTime = (Set<Plant>[]) new Set[Plant.LifeTime.values().length];

        //  init Set to HashSet
        for (int i = 0; i < plantsByLifeTime.length; i++)
            plantsByLifeTime[i] = new HashSet<>();

        //  now we get Plant form garden array and by ordinals() method which return index,
        //  add into the appropriate plantsByLifeCycle index
        for (Plant plant : Garden.garden)
            plantsByLifeTime[plant.lifeTime.ordinal()].add(plant);     //  bad approach

        //  and print
        //  problem can occur here

        //  when you access an array that is indexed by an enum’s ordi- nal,
        //  it is your responsibility to use the correct int value
        //  (Joshua)
        for (int i = 0; i < plantsByLifeTime.length; i++)
            System.out.printf("%s: %s%n", Plant.LifeTime.values()[i], plantsByLifeTime[i]);

    }

}
