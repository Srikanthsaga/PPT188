import java.util.Stack;

public class PPT188 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        
        Stack<Integer> stack = new Stack<>();
        int second = Integer.MIN_VALUE;  // Represents the potential "2" element
        
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;  // Found a valid 132 pattern
            }
            
            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                second = stack.pop();  // Update the potential "2" element
            }
            
            stack.push(nums[i]);
        }
        
        return false;  // No 132 pattern found
    }
}
