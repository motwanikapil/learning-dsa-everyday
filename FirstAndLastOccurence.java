import java.util.Arrays;
public class FirstAndLastOccurence {
	static int lowerBound(int[] arr, int n, int x) {
		int low = 0, high = n-1;
		int ans = n;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] >= x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}
	static int upperBound(int[] arr, int n, int x) {
		int low = 0, high = n-1;
		int ans = n;

		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > x) {
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return ans;
	}

	// if not using lower bound and upper bound

	static int firstOccurence(int[] arr, int n, int x) {
		int low = 0, high = n-1;
		int first = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x) {
				first = mid;
				high = mid - 1;
			} else if (arr[mid] < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return first;
	}

	static int lastOccurence(int[] arr, int n, int x) {
		int low = 0, high = n-1;
		int last = -1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] == x) {
				last = mid;
				low = mid + 1;
			} else if (arr[mid] < x) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return last;
	}

	static int[] firstAndLastOccurence(int[] arr, int n , int x) {
		int lb = lowerBound(arr, arr.length, x);
		if (lb == n || arr[lb] != x) return new int[]{-1, -1};
		int ub = upperBound(arr, arr.length, x);
		return new int[]{lb, ub-1};
	}
	public static void main(String[] args) {
		int[] arr = {2,4,6,8,8,8,11,13};
		System.out.println("first and last occurence : "+Arrays.toString(firstAndLastOccurence(arr, arr.length, 8)));
	}
}