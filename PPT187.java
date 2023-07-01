import java.util.Arrays;

public class PPT187 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Initialize dp array with 1 as the minimum subsequence length
        
        int maxLength = 1; // Initialize the maximum length to 1
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // If nums[i] is greater than nums[j], it can be included in the subsequence
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        
        return maxLength;
    }
}
