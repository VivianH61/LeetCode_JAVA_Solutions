/* Quicksort with randomnized partition */
import java.util.concurrent.ThreadLocalRandom;
class Solution {
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quicksort(int[] nums, int l, int r) {
        if (l >= r) return;
        int pivot = partition(nums, l, r);
        quicksort(nums, l, pivot - 1);
        quicksort(nums, pivot + 1, r);
    }
    
    private int partition(int[] nums, int l, int r) {
        int randomIndex = ThreadLocalRandom.current().nextInt(l, r + 1);
        int x = nums[randomIndex];
        swap(nums, randomIndex, r);
        int i = l;
        for (int j = l; j < r; j ++) {
            if (nums[j] <= x) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, r);
        return i;
    }
    
    private void swap(int[] A, int i, int j) {
        int prev = A[i];
        A[i] = A[j];
        A[j] = prev;
    }
}


/* Mergesort */
class Solution {
    public int[] sortArray(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
    
    public int[] mergeSort(int[] nums, int l, int r) {
        if (l == r) {
            return new int[]{nums[l]};
        }
        if (l > r) {
            return new int[]{};
        }
        int mid = l + (r - l) / 2;
        int[] A = mergeSort(nums, l, mid);
        int[] B = mergeSort(nums, mid + 1, r);
        return merge(A, B);
    }
        
    public int[] merge(int[] A, int[] B) {
        int[] res = new int[A.length + B.length];
        int i = 0, j = 0;
        int count = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                res[count++] = A[i++];
            } else {
                res[count++] = B[j++];
            }
        }
        while (i < A.length) {
            res[count++] = A[i++];
        }
        while (j < B.length) {
            res[count++] = B[j++];
        }
        return res;
    }
}


