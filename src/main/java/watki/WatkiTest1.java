package watki;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WatkiTest1 {
    public static void main(String[] args) throws Exception {
        System.out.println("thread: " + Thread.currentThread().getName() + " ");
        ExecutorService executorService = Executors.newFixedThreadPool(8);


        for (int i = 0; i < 14; i++) {
            Integer ii = i;
            executorService.submit(() -> {
                //zadanie do wykonania
                try {
                    System.out.println("worker pracuje");
                    System.out.println("thread: " + Thread.currentThread().getName() + " zaczyna zadanie " + ii);
                    Thread.sleep(50);
                    System.out.println("thread " + Thread.currentThread().getName() + " kończy");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        System.out.println("Main czeka");
        Thread.sleep(100);

        //do wątków: http://tutorials.jenkov.com/java-concurrency/index.html

    }

}
