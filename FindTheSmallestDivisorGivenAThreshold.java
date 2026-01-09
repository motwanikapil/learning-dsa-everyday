public class FindTheSmallestDivisorGivenAThreshold {
	public int sumOfDividedNumbers(int[] nums, int divisor, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;
            if (sum > threshold) return sum;
        }
        return sum;
    }
    public int getMaxVal(int[] nums) {
         int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        // System.out.println(sumOfDividedNumbers(nums, 5));
        int low = 1, high = getMaxVal(nums);
        int ans = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sumOfDividedNumbers(nums, mid, threshold) <= threshold) {
                ans = Math.min(mid, ans);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}