public class SearchAlgorithms {
    
    public static int sequentialSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int x) {
        return binarySearch(arr, 0, arr.length - 1, x);
    }

    private static int binarySearch(int[] arr, int start, int end, int x) {
        if (end < start) {
            return -1;
        }
        int mid = (start + end) / 2;
        // If the element is present at the middle itself
        if (arr[mid] == x) {
            return mid;
        }
        if (x < arr[mid]) {
            return binarySearch(arr, start, mid - 1, x);
        }
        // else the element can only be present in right subarray
        return binarySearch(arr, mid + 1, end, x);
    }
}
