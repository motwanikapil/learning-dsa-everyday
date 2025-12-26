public class NumberOfOccurences {
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
	
    static int countFreq(int[] arr, int target) {
        int first = firstOccurence(arr, arr.length, target);
        if (first == -1) return 0;
        int last = lastOccurence(arr, arr.length, target);
        int count = last - first + 1;
        return count;
    }

    public static void main(String[] args) {
    	int[] arr = {1,1,2,2,2,2,3};
    	int target = 2;
    	System.out.println("Number of occurences of 2 is "+countFreq(arr, target));
    }
}