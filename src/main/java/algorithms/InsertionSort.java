package algorithms;

import metrics.PerformanceTracker;

public class InsertionSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) return;

        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            tracker.incArrayAccesses(1);

            int j = i - 1;

            tracker.incComparisons();
            tracker.incArrayAccesses(1);
            if (arr[j] <= key) {
                continue;
            }


            while (j >= 0) {
                tracker.incComparisons();
                tracker.incArrayAccesses(1);
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    tracker.incArrayAccesses(2);
                    tracker.incSwaps();
                    j--;
                } else {
                    break;
                }
            }

            arr[j + 1] = key;
            tracker.incArrayAccesses(1);
        }
    }
}
