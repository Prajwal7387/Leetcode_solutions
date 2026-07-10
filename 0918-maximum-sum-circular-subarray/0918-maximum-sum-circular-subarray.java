class Solution {
    public int maxSubarraySumCircular(int[] nums) {

        int totalSum = 0;

        int maxSum = nums[0];
        int curMax = 0;

        int minSum = nums[0];
        int curMin = 0;

        for (int num : nums) {

            // Maximum subarray sum (Kadane)
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);

            // Minimum subarray sum (Kadane)
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);

            totalSum += num;
        }

        // If all elements are negative
        if (maxSum < 0)
            return maxSum;

        // Maximum of normal subarray and circular subarray
        return Math.max(maxSum, totalSum - minSum);
    }
}