package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceSimpleExample {

    public static void main(String[] args) {

        ExecutorService executorService = null;

        try {
            executorService = Executors.newSingleThreadExecutor();
            System.out.println("begin");
            executorService.execute(() -> System.out.println("printing zoo inventory"));
            executorService.execute(() -> {
                for (int i = 0; i < 3; i++)
                    System.out.println("Printing record : " + i);
            });
            executorService.execute(() -> System.out.println("printing zoo inventory"));
            System.out.println("end");
        } finally {
            if (executorService != null) executorService.shutdown();
        }

    }

}