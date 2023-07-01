import java.util.Arrays;

public class 	PPT186 {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        
        // Sort the balloons based on the end point of each interval
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        
        int arrows = 1; // Initialize with 1 arrow (first balloon will always be burst)
        int prevEnd = points[0][1]; // End point of the first balloon
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon starts after the previous end point, we need an additional arrow
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }
        
        return arrows;
    }
}
