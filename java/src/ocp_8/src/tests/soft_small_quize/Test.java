package tests.soft_small_quize;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {


    public static void main(String[] args) {

        ExecutorService ex = Executors.newSingleThreadExecutor();
        List<String> sentence = Arrays.asList("Kill");
        ex.submit(() -> Files.write(Paths.get("Summary.txt"), sentence));
        ex.submit(() -> {
            Files.write(Paths.get("Summary.txt"), sentence);
        });

    }
}

