class SngleElementInASortedArray {
	/*
	brute
	if (n == 1) return arr[0];

	O(n) time complexity
	
	for (i = 1 to n) {
		if (i == 0 && arr[i] != arr[i+1]) return arr[i];
		else if (i == n-1 && arr[i] != arr[i-1]) return arr[i];
		else if (arr[i] != arr[i+1] && arr[i] != arr[i-1]) return arr[i];
	}
	*/
	static int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		if (n == 1) return nums[0];
		if (nums[0] != nums[1]) return nums[0];
		if (nums[n-1] != nums[n-2]) return nums[n-1];

		int low = 1, high = n-1;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]) return nums[mid];
			else if ((mid % 2 == 1 && nums[mid] == nums[mid-1]) || (mid % 2 == 0 && nums[mid] == nums[mid+1])) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return -1;
	}
	public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,3,4,5,5,6,6};
		System.out.println("Ans : "+singleNonDuplicate(nums));
	}
}