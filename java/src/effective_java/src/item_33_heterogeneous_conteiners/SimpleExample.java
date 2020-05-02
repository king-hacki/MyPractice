package item_33_heterogeneous_conteiners;

import java.util.*;

public class SimpleExample {

    public static void main(String[] args) {

        Favorites f = new Favorites();

        List<String> l = new ArrayList<>();
        f.putFavorite(List.class, l);
        f.putFavorite(String.class, "Java");
        f.putFavorite(Integer.class, 0xcafebabe);
        f.putFavorite(Class.class, Favorites.class);

        String favoriteString = f.getFavorite(String.class);
        int favoriteInteger = f.getFavorite(Integer.class);
        Class<?> favoriteClass = f.getFavorite(Class.class);

        List<String> ll = f.getFavorite(List.class);

        System.out.printf("%s %x %s %s%n", favoriteString, favoriteInteger, favoriteClass.getName(), ll);
    }

}

class Favorites {

    private final Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(Objects.requireNonNull(type), type.cast(instance));
    }

    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
//        return (T) favorites.get(type);       unchecked cast
    }
}