package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            boolean isSorted = true;

            int key = arr[i];
            tracker.incArrayAccesses(1);

            int j = i - 1;

            tracker.incComparisons();
            if (arr[j] <= key) {
                tracker.incArrayAccesses(1);
                continue;
            }

            while (j >= 0 && arr[j] > key) {
                tracker.incComparisons();
                tracker.incArrayAccesses(1);

                arr[j + 1] = arr[j];
                tracker.incArrayAccesses(1);
                tracker.incSwaps();
                j--;
                isSorted = false;
            }

            arr[j + 1] = key;
            tracker.incArrayAccesses(1);


            if (isSorted && i == n - 1) break;
        }
    }
}
