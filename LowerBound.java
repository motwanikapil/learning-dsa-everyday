class LowerBound {
	static int lowerBound(int[] arr, int n, int x) {
		int low = 0, high = n-1;
		int ans = n;
		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] >= x) {
				ans = mid;
				high = mid - 1; // searching for even lower index
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,3,5,8,8,10,10,11};

		System.out.println("Lower bound "+lowerBound(arr, arr.length, 9));
	}
}