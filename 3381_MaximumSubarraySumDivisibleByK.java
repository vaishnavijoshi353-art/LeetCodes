/**
 * 3381. Maximum Subarray Sum With Length Divisible by K
 *
 * Approach:
 * - Use Prefix Sum to track cumulative sums.
 * - Use modulo (index % k) to ensure subarray length is divisible by k.
 * - Store the minimum prefix sum for each modulo.
 * - Maximize the result using prefix - minPrefix[mod].
 *
 * Time: O(n)
 * Space: O(k)
 */

class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix = 0;
        long result = Long.MIN_VALUE;

        long[] minPrefix = new long[k];

        // Initialize with max values
        for (int i = 0; i < k; i++) {
            minPrefix[i] = Long.MAX_VALUE;
        }

        // Base case
        minPrefix[0] = 0;

        for (int i = 0; i < n; i++) {
            prefix += nums[i];

            int mod = (i + 1) % k;

            if (minPrefix[mod] != Long.MAX_VALUE) {
                result = Math.max(result, prefix - minPrefix[mod]);
            }

            minPrefix[mod] = Math.min(minPrefix[mod], prefix);
        }

        return result;
    }
}
