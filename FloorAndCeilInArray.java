class FloorAndCeilInArray {
	// ceil is lower bound
	static int floor(int[] arr,int x, int n) {
		int ans = -1;
		int low = 0;
		int high = n-1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (arr[mid] <= x) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40 ,50};
		int x = 25;

		System.out.println("Floor of 25 in arr is : "+floor(arr, x, arr.length));
	}
}