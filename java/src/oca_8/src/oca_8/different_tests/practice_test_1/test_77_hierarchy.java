package oca_8.different_tests.practice_test_1;

public class test_77_hierarchy {
    public static void main(String[] args) throws Exception {
        Game game = new Soccer();
        game.play();
    }
}

class Game {
    public void play() throws Exception {
        System.out.println("Playing...");
    }
}

class Soccer extends Game {
    public void play() {
        System.out.println("Playing soccer ...");
    }
}
