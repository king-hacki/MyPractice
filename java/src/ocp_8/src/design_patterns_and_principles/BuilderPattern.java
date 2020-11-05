package design_patterns_and_principles;

import java.util.Arrays;
import java.util.List;

public class BuilderPattern {
    public static void main(String[] args) {
        AnimalBuilder animalBuilder = new AnimalBuilder();
        animalBuilder
                .setAge(2)
                .setSpeciesName("Name")
                .setFavoriteFood(Arrays.asList("1", "2", "3"))
                .build();

        System.out.println(animalBuilder);
    }
}

class AnimalBuilder {
    private String speciesName;
    private int age;
    private List<String> favoriteFood;

    public AnimalBuilder() {}
    public AnimalBuilder(String speciesName, int age, List<String> favoriteFood) {
        this.speciesName = speciesName;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    public AnimalBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public AnimalBuilder setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
        return this;
    }

    public AnimalBuilder setFavoriteFood(List<String> favoriteFood) {
        this.favoriteFood = favoriteFood;
        return this;
    }

    public AnimalBuilder build() {
        return new AnimalBuilder(speciesName, age, favoriteFood);
    }

    @Override
    public String toString() {
        return "AnimalBuilder{" +
                "speciesName='" + speciesName + '\'' +
                ", age=" + age +
                ", favoriteFood=" + favoriteFood +
                '}';
    }
}