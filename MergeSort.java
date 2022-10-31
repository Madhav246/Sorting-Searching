public class Solution {
    public static void merge(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;

        int len1 = mid - start + 1;
        int len2 = end - mid;

        int[] arr1 = new int[len1];
        int[] arr2 = new int[len2];

        //Copying Array 
        int k = start;
        for (int i = 0; i < len1; i++) {
            arr1[i] = arr[k++];
        }

        k = mid + 1;
        for (int i = 0; i < len2; i++) {
            arr2[i] = arr[k++];
        }

        //Merging two arrays
        int i = 0;
        int j = 0;
        k = start;

        while (i < len1 && j < len2) {
            if (arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            }   
            else {
                arr[k++] = arr2[j++];
            }
        }

        while (i < len1) {
            arr[k++] = arr1[i++];
        }
        while (j < len2) {
            arr[k++] = arr2[j++];
        }
    }

    public static void solve(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }  
        int mid = start + (end - start) / 2;

        solve(arr, start, mid);
        solve(arr, mid + 1, end);
        merge(arr, start, end);
    }

    public static void mergeSort(int[] arr, int n) {
        solve(arr, 0, n - 1);
    } 
}


