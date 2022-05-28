/*
Clarification: 
1. is x guaranteed to be in the arr? no
2. are there duplicate numbers?
3. what if k is larger than the array length
4. for two elements that are equally close to x, which to include? include the smaller element
*/

/*
Approach 1: Binary search + two pointer expand O(logn + k)
(1) Use binary search to find the element that is closest to x (which is also the smallest element among all elements 
that are equally close to x). -> O(logn)
(2) expand from the cloest element. -> O(k)
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = findClosestElement(arr, x);
        int minEle = arr[l];
        System.out.println(minEle);
        int r = l;
        for (int i = 0; i < k - 1; i ++) {
            if (l == 0) 
                r ++;
            else if (r == arr.length - 1 || Math.abs(arr[l - 1] - x) <= Math.abs(arr[r + 1] - x))
                l --;
            else
                r ++;
        }
        ArrayList<Integer> topK = new ArrayList<Integer>();
        for (int i = l; i < r + 1; i ++) {
            topK.add(arr[i]);
        }
        return topK;
    }
    
    // using binary search to find the element that is closest to x
    // as arr is incresing, obviously, minus every element in arr with x, it is a increasing array or an increasing and then decresing array
    public int findClosestElement(int[] nums, int x) {
        int l = 0, r = nums.length - 1;
        int minIdx = -1, minDiff = Integer.MAX_VALUE;
        while (l <= r) {
            int mid = (l + r) / 2;
            if ((Math.abs(nums[mid] - x) < minDiff) || 
                (Math.abs(nums[mid] - x) == minDiff && nums[mid] < nums[minIdx])){
                minIdx = mid;
                minDiff = Math.abs(nums[mid] - x);
            }
            if (nums[mid] < x) l = mid + 1;
            else if (nums[mid] >= x) r = mid - 1;
        }
        return minIdx;
    }
}


/*
Approach 2: Binary search to find the left bound O(log(n - k) + k)
What if the k is very large? the Approach 1 is not that efficient. 
As the k element must be continuous in the array, we only need to find the left bound and right bound of the k elements.
search the left bound in [0, length - k]
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while (l < r) {
            int mid = (l + r) / 2;
            if (x - arr[mid] <= arr[mid + k] - x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        ArrayList<Integer> topK = new ArrayList<Integer>();
        for (int i = l; i < l + k; i ++) {
            topK.add(arr[i]);
        }
        return topK;
    }

}

/* 
Approach 3: sort with custom comparator
Time complexity: O(nlogn + klogk)
Space complexity: O(n)
*/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // convert arr to list to make use of Collections.sort()
        List<Integer> sortedArr = new ArrayList<Integer>();
        for (int num : arr) {
            sortedArr.add(num);
        }
        // sort using custom comparater
        Collections.sort(sortedArr, (num1, num2) -> Math.abs(num1 - x) - Math.abs(num2 - x));
        sortedArr = sortedArr.subList(0, k);
        // sort again to have output in ascending order
        Collections.sort(sortedArr);
        return sortedArr;
    }
}