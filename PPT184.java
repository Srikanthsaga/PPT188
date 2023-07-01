public class PPT184 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        
        // Find the maximum element in the array
        int maxNum = nums[0];
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        
        // Perform Radix Sort
        int exp = 1;
        int[] sortedNums = new int[nums.length];
        
        while (maxNum / exp > 0) {
            int[] count = new int[10];
            
            for (int num : nums) {
                int digit = (num / exp) % 10;
                count[digit]++;
            }
            
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            
            for (int i = nums.length - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                sortedNums[count[digit] - 1] = nums[i];
                count[digit]--;
            }
            
            System.arraycopy(sortedNums, 0, nums, 0, nums.length);
            
            exp *= 10;
        }
        
        // Calculate the maximum gap
        int maxGap = 0;
        for (int i = 1; i < nums.length; i++) {
            maxGap = Math.max(maxGap, nums[i] - nums[i - 1]);
        }
        
        return maxGap;
    }
}
