/* Approach: Dynamic Programming
For every position i, the rain water that it can trap is the min of the highest bar in the left and right side, minus its own height: min(L, R) - height[i] (if the result is negative, it mean that we can trap 0 water)
Use two arrays to memorize the maximun value from the right and right sides for every index
*/
class Solution {
    public int trap(int[] height) {
        // the max height in the left side of every index
        int[] leftMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        // the max height in the right of every index
        int[] rightMax = new int[height.length];
        rightMax[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }
        int totalWater = 0;
        for (int i = 1; i < height.length - 1; i++) {
            totalWater += Math.max(0, Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return totalWater;
    }
}