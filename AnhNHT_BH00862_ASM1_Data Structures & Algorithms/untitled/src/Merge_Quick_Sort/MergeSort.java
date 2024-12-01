package Merge_Quick_Sort;

public class MergeSort {
    public static void merge(int[] arr, int left, int mid, int right) {
        // This function merges two subarrays: arr[left..mid] and arr[mid+1..right].

        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays to hold the two subarrays.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data into these temporary arrays from the original array.
        for (int i = 0; i < n1; i++) L[i] = arr[left + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        // Merge the two sorted subarrays back into the original array.
        int i = 0, j = 0; // Initial indices for L[] and R[].
        int k = left; // Initial index for the merged array.
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of L[] and R[] if any exist.
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void sort(int[] arr, int left, int right) {
        // This function recursively divides the array into two halves and sorts them.
        if (left < right) {
            // Find the middle point to divide the array.
            int mid = left + (right - left) / 2;

            // Recursively sort the two halves.
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Merge the sorted halves.
            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 7, 6, 5, 4, 2, 1};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}


