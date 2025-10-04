package cli;

import algorithms.InsertionSort;
import metrics.PerformanceTracker;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;   // <-- добавь

public class BenchmarkRunner {
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000};
        Random rand = new Random(7);

        System.out.println("Insertion Sort Benchmark\n");

        try (FileWriter writer = new FileWriter("benchmark_results.csv")) {
            writer.write("n,time_ms,comparisons,swaps,array_accesses\n");

            for (int n : sizes) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = rand.nextInt(10000);
                }

                PerformanceTracker tracker = new PerformanceTracker();
                tracker.start();
                InsertionSort.sort(arr, tracker);
                tracker.stop();

                double time = tracker.getElapsedTimeMs();
                long cmp = tracker.getComparisons();
                long swp = tracker.getSwaps();
                long acc = tracker.getArrayAccesses();

                // консоль
                System.out.printf(Locale.US,
                        "n=%d | time=%.3f ms | cmp=%d | swp=%d | acc=%d%n",
                        n, time, cmp, swp, acc);

                // CSV (точка как разделитель)
                writer.write(String.format(Locale.US,
                        "%d,%.3f,%d,%d,%d%n", n, time, cmp, swp, acc));
            }

            System.out.println("\n Results saved to benchmark_results.csv");

        } catch (IOException e) {
            System.out.println("Error writing CSV: " + e.getMessage());
        }
    }
}
