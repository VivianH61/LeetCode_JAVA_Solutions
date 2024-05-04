/* Quicksort with randomnized partition */
import java.util.concurrent.ThreadLocalRandom;
class Solution {
    public void quicksort(int[]nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int randomIndex = ThreadLocalRandom.current().nextInt(left, right + 1);
        int x = nums[randomIndex];
        swap(nums, randomIndex, right);
        int i = left;
        for (int j = left; j < right; j ++) {
            if (nums[j] < x) {
                swap(nums, i, j);
                i ++;
            } 
        }
        swap(nums, i, right);
        quicksort(nums, left, i - 1);
        quicksort(nums, i + 1, right);
    }

    public void swap(int[] nums, int i, int j) {
        int prev_i = nums[i];
        nums[i] = nums[j];
        nums[j] = prev_i;
    }

    
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
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


