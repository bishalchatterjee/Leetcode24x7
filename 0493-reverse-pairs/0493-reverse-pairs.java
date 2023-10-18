class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int mergeSort(int[] arr, int low, int high) {
        if (low >= high) return 0; // Initialize countRevPairs to 0
        int mid = (low + high) / 2;
        int countRevPairs = 0; // Count reverse pairs in this merge

        countRevPairs += mergeSort(arr, low, mid);
        countRevPairs += mergeSort(arr, mid + 1, high);
        countRevPairs += countReversePairs(arr, low, mid, high);
        merge(arr, low, mid, high);

        return countRevPairs;
    }

    public static int countReversePairs(int[] arr, int low, int mid, int high) {
        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (right <= high && (long) arr[i] > 2 * (long) arr[right]) {
                right++;
            }
            count += right - (mid + 1);
        }

        return count;
    }
}
