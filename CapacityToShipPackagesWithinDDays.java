public class CapacityToShipPackagesWithinDDays {
    public boolean isPossible(int[] weights, int capacity, int days) {
        int usedDays = 1;
        int curr = 0;
        for (int wgt: weights) {
            if (curr + wgt > capacity) {
                usedDays++;
                curr = 0;
            }
            curr += wgt;
            if (usedDays > days) {
                return false;
            }
        }

        return true;
    }
    
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int w: weights) {
            low = Math.max(low , w);
            high += w;
        }
        while (low <= high) {
            int mid = (low + (high - low) / 2);
            if (isPossible(weights, mid, days)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}