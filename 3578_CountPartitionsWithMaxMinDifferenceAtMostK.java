/**
 * LeetCode 3578 - Count Partitions With Max-Min Difference at Most K
 *
 * Approach:
 * - Try all subarrays starting from each index
 * - Maintain running minimum and maximum
 * - If (max - min <= k), count it as valid
 * - Break early when condition fails (optimization)
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Solution {
    public long countPartitions(int[] nums, int k) {
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n; i++) {
            int minVal = nums[i];
            int maxVal = nums[i];

            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);

                if (maxVal - minVal <= k) {
                    count++;
                } else {
                    break;
                }
            }
        }

        return count;
    }
}
