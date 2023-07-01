public class PPT183 {
    public boolean firstBadVersion(int n) {
        int left = 1;
        int right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (firstBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return false;
    }
}
