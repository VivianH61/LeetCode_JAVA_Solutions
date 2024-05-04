/*
 * @lc app=leetcode id=441 lang=java
 *
 * [441] Arranging Coins
 */

// @lc code=start
/*
for k complete stairs, the total coins are coins(k) = (1 + k) * k / 2
find the k that coins(k) <= n && coins(k + 1) > n
binary search
corner case: l == r, we know that for k < l, coins(k) < n and for k > r, coins(k) > n
if coins(mid) < n: l = mid + 1, here, r meets the constraints that coins(r) <= n && coins(r + 1) > n
if coins(mid) > n: r = mid - 1, here, r also meets the constraints
 */
class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if ((long) mid * (mid + 1) <= (long) 2 * n) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

// @lc code=end

