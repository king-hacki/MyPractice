package item_37_enumMap_instied_ordinal_and_array;

public class Plant {

    enum LifeTime {START, MIDDLE, LATE, PRELIFE}

    final String name;
    final LifeTime lifeTime;

    Plant(String name, LifeTime lifeTime) {
        this.name = name;
        this.lifeTime = lifeTime;
    }

    @Override
    public String toString() {
        return name;
    }

}
