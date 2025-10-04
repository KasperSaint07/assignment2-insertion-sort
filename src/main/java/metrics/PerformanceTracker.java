package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public void incComparisons() {
        comparisons++;
    }

    public void incSwaps() {
        swaps++;
    }

    public void incArrayAccesses(int count) {
        arrayAccesses += count;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public double getElapsedTimeMs() {
        return (endTime - startTime) / 1_000_000.0;
    }

    public void printResults() {
        System.out.println("Comparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
        System.out.println("Array accesses: " + arrayAccesses);
        System.out.println("Execution time (ms): " + getElapsedTimeMs());
    }
}
