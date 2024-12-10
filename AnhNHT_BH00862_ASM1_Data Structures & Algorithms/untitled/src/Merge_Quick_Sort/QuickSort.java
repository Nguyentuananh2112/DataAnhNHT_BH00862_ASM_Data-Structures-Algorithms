package Merge_Quick_Sort;

public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        // This function takes the last element as a pivot and places the pivot at the correct
        // position in a sorted array. It also rearranges the array so that all elements smaller
        // than the pivot are on the left and all greater elements are on the right.

        int pivot = arr[high]; // Pivot is chosen as the last element in the array.
        int i = (low - 1); // Index of smaller element.

        for (int j = low; j < high; j++) {
            // If the current element is smaller than or equal to the pivot, swap it.
            if (arr[j] <= pivot) {
                i++;

                // Swap arr[i] and arr[j].
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap the pivot element with the element at index i+1, so that the pivot is in its correct position.
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return the index of the pivot.
    }

    public static void sort(int[] arr, int low, int high) {
        // This function recursively applies the partitioning method to sort the array.
        if (low < high) {
            // Find the partition index where the pivot is placed in the correct position.
            int pi = partition(arr, low, high);

            // Recursively sort the sub-arrays before and after the partition.
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 3, 7, 6, 5, 4, 2, 1};
        System.out.println("Original array: " + java.util.Arrays.toString(arr));
        sort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + java.util.Arrays.toString(arr));
    }
}


