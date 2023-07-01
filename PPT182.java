import java.util.Arrays;

class PT182 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0; // points to the region of elements less than the pivot (0)
        int mid = 0; // points to the region of elements equal to the pivot (1)
        int high = n - 1; // points to the region of elements greater than the pivot (2)

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

public class PPT182 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        PT182 solution = new PT182();
        solution.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
