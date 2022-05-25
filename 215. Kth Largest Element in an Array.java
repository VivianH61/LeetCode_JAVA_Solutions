/* Approach 1: quickSelect
time: average O(n), worst O(n^2)
space: O(1)
*/
import java.util.concurrent.ThreadLocalRandom;
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        quickSelect(nums, 0, n - 1, k);
        return nums[k - 1];
    }
    
    public void quickSelect(int[] nums, int l, int r, int k) {
        int pivot = partition(nums, l, r);
        // if pivot == k - 1, do nothing, nums[pivot] is the result
        if (pivot > k - 1) {
            quickSelect(nums, l, pivot - 1, k);
        } else if (pivot < k - 1) {
            quickSelect(nums, pivot + 1, r, k);
        }
    }
    
    public int partition(int[] nums, int l, int r) {
        int randomIndex = ThreadLocalRandom.current().nextInt(l, r + 1);
        int x = nums[randomIndex];
        swap(nums, randomIndex, r);
        int i = l;
        for (int j = l; j < r; j ++) {
            if (nums[j] >= x) {
                swap(nums, i++, j);
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


/*
Approach 2: Heap
maintain a k-sized heap 
time: O(nlogk) space: k
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        // init a min heap (the root is the min value)
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll(); // remove the min element in the heap
            }
        }
        return heap.poll();
    }
}