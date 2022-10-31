public class Solution {
    public static int partition(List <Integer> arr, int start, int end) {
        int pivot = arr.get(start);
        int count = 0;

        //Find correct position of pivot :
        for (int i = start + 1; i <= end; i++) {
            if (arr.get(i) <= pivot) {
                count++;
            }
        }

        //Place Pivot at right position
        int pivotIndex = start + count;
        Collections.swap(arr, pivotIndex, start);

        //handle right and left part i..e left part < pivot
        //right part > pivot.
        int i = start;
        int j = end;

        while (i < pivotIndex && j > pivotIndex) {
            while (arr.get(i) <= pivot) {
                i++;
            }
            
            while (arr.get(j) > pivot) {
                j--;
            }
            
            if (i < pivotIndex && j > pivotIndex) {
                Collections.swap(arr, i, j);
                i++;
                j--;
            }
        }   
        return pivotIndex;
    }

    public static void solve(List <Integer> arr, int start, int end) {
        if (start >= end) {
            return;
        }

        //Doing partition :
        int p = partition(arr, start, end);

        //Sort left and right part :
        solve(arr, start, p - 1);
        solve(arr, p + 1, end);
    }

    public static List <Integer> quickSort(List <Integer> arr) {
        solve(arr, 0, arr.size() - 1);
        return arr;
    } 
}

