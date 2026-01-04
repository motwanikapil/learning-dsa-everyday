public class SearchInRotatedSortedWithDuplicates {
	static int search(int[] arr, int n, int target) {		
		int low = 0;
		int high = n-1;

		while (low <= high ) {
			int mid = (low + high) / 2;
			if (arr[mid] == target) return mid;

			if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
				low++;
				high--;
				continue;
			}

			if (arr[low] <= arr[mid]) {
				if (arr[low] <= target && target <= arr[mid]) {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			} else {
				if (arr[mid] <= target && target <= arr[high]) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		int[] arr = {3,1,2,3,3,3,3};
		int target = 2;
		System.out.println("search index : "+search(arr, arr.length, target));
	}
}