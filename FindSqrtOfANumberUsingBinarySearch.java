class FindSqrtOfANumberUsingBinarySearch {
	static int floorSqrt(int n) {
		int low = 1, high = n;
		while (low <= high) {
			long mid = (low + high) / 2;
			long val = (mid * mid);
			if (val <= n) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return high;
	}
}