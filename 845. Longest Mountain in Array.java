/* Approach: simulate climbing the mountain */
class Solution {
    public int longestMountain(int[] arr) {
        int i = 0, maxLen = 0;
        while (i < arr.length) {
            int base = i;
            // walk up
            while (i + 1 < arr.length && arr[i] < arr[i + 1]) i++;
            
            //check if peak is valid
            if (i == base) {
                i++;
                continue;
            }
            int peak = i;
            
            // walk down
            while (i + 1 < arr.length && arr[i] > arr[i + 1]) i++;
            
            // check if the end is valid
            if (i == peak) {
                i++;
                continue;
            }
            
            // update the answer
            maxLen = Math.max(maxLen, i - base + 1);
        }
        return maxLen;
    }
}