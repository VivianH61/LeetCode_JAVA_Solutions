/**
 * Approach1: use heap O(nlogk)
 */
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // build hash map: number and its frequancy O(n)
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        for (int num : nums) {
            int freq = counter.getOrDefault(num, 0);
            counter.put(num, freq + 1);
        }
        // init a max-heap
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> counter.get(n1) - counter.get(n2));
        // keep k top frequent in the heap O(nlogk)
        for (int n: counter.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        // build an output array O(klogk)
        int[] topK = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            topK[i] = heap.poll();
        }
        return topK;
    }
}

/*Approach 2: quick select*/
import java.util.Random;
class Solution {
    HashMap<Integer, Integer> counter;
    int[] unique;
    public int[] topKFrequent(int[] nums, int k) {  
        counter = new HashMap();
        for (int num: nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int n = counter.size();
        unique = new int[n];
        int i = 0;
        for (int num : counter.keySet()) {
            unique[i++] = num;
        }
        quickselect(0, n - 1, n - k);
        return Arrays.copyOfRange(unique, n - k, n);
    }
    
    // select the k smallest
    public void quickselect(int left, int right, int k) {
        if (left == right) return;
        Random rand = new Random();
        int rand_idx = left + rand.nextInt(right - left);   
        swap(unique, rand_idx, right);
        int pivot_idx = partition(left, right);
        if (k == pivot_idx) {
            return;
        } else if (k < pivot_idx) {
            // go left
            quickselect(left, pivot_idx - 1, k);
        } else {
            // go right
            quickselect(pivot_idx + 1, right, k);
        }
    }
    
    public int partition(int left, int right) {
        int pivot = counter.get(unique[right]);
        int i = left;
        for (int j = left; j <= right; j++) {
            if (counter.get(unique[j]) < pivot) {
                swap(unique, i++, j);
            }
        }
        swap(unique, i, right);
        return i;
    }
    
    public void swap(int[] nums, int i, int j) {
        int prev = nums[i];
        nums[i] = nums[j];
        nums[j] = prev;
    }
}