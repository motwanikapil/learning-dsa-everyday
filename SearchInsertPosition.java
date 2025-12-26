class SearchInsertPosition {
	static int searchInsert(int[] arr, int x, int n) {
		int low = 0;
		int high = n-1;
		int ans = n;

		while (low <= high) {
			int mid = low + (high-low)/2;
			if (arr[mid] >= x) {
				ans = mid;
				high = mid-1;
			} else {
				low = mid + 1;
			}
		}

		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {1,2,4,7};
		int target = 6;

		System.out.println("Search insert position : "+searchInsert(arr, target, arr.length));
	}
}