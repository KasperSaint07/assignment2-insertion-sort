package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000};
        Random rand = new Random();

        System.out.println("Insertion Sort Benchmark\n");

        for (int n : sizes) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = rand.nextInt(10000);
            }

            PerformanceTracker tracker = new PerformanceTracker();
            tracker.start();
            InsertionSort.sort(arr, tracker);
            tracker.stop();

            System.out.printf("n=%d | time=%.3f ms | cmp=%d | swp=%d | acc=%d%n",
                    n, tracker.getElapsedTimeMs(),
                    tracker.getComparisons(),
                    tracker.getSwaps(),
                    tracker.getArrayAccesses());
        }
    }
}
