import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PPT181 {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Initialize the merged list
        List<int[]> merged = new ArrayList<>();

        // Iterate through each interval
        for (int[] interval : intervals) {
            // Check if the merged list is empty or if the current interval does not overlap
            // with the last interval in the merged list
            if (merged.isEmpty() || interval[0] > merged.get(merged.size() - 1)[1]) {
                merged.add(interval);
            } else {
                // Update the end time of the last interval in the merged list
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }

        // Convert the merged list to an array
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }

        return result;
    }
}
