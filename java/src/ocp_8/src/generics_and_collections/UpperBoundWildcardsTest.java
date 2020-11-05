package generics_and_collections;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpperBoundWildcardsTest {

    static void testUpperBoundWildcards(List<? extends Bird> birdList) {
        for (Bird b : birdList)
            b.display();
    }

    static List<? super Bird> test(List<? super Bird> sparrows) {
        sparrows.add(new Bird());
        return sparrows;
    }

    public static void main(String[] args) {

        List<? super IOException> exceptions1 = new ArrayList<Exception>();
//        exceptions1.add(new Exception());
        exceptions1.add(new IOException());
        exceptions1.add(new FileNotFoundException());

        List<? extends IOException> exceptions2 = new ArrayList<FileNotFoundException>();
//        exceptions2.add(new Exception());
//        exceptions2.add(new IOException());
//        exceptions2.add(new FileNotFoundException());

        List<? extends Bird> birds = new ArrayList<Sparrow>();
//        birds.add(new Bird());        CE don't know how to cast
//        birds.add(new Sparrow());     CE don't know how to cast

        List<? super Sparrow> sparrows1 = new ArrayList<>();
//        sparrows1.add(new Bird());        CE
        sparrows1.add(new Sparrow());

        List<Bird> birdList = new ArrayList<>();
        birdList.add(new Bird());
        birdList.add(new Bird());
        birdList.add(new Sparrow());

        List<Sparrow> sparrowList = new ArrayList<>();
        sparrowList.add(new Sparrow());
        sparrowList.add(new Sparrow());

        testUpperBoundWildcards(birdList);
        testUpperBoundWildcards(sparrowList);

    }
}

class Bird {
    void display() {
        System.out.println("Bird");
    }
}
class Sparrow extends Bird {
    void display() {
        System.out.println("Sparrow");
    }
}
