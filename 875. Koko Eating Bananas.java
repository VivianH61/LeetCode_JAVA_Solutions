/*
the min value of k is 1
the max value of k is the largest pile
use binary search to find the min k
time complexity O(nlog(max_pile))
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 0;
        for (int pile : piles) {
            if (pile > r) {
                r = pile;
            }
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canEatAll(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (canEatAll(piles, h, l)) {
            return l;
        }
        return -1;
    }
    
    public boolean canEatAll(int[] piles, int h, int k) {
        int time = 0;
        for (int pile : piles) {
            time += pile / k;
            if (pile % k != 0) time ++;
        }
        return (time <= h);
    }
}