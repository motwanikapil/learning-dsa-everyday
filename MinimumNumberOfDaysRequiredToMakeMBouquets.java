import java.util.Arrays;

class MinimumNumberOfDaysRequiredToMakeMBouquets {
	static int minVal(int[] arr) {
		return Arrays.stream(arr).min().getAsInt();
	}
	static int maxVal(int[] arr) {
		return Arrays.stream(arr).max().getAsInt();
	}
	static boolean possible(int[] arr, int day, int m, int k) {
		int cnt = 0;
		int noOfBoquet = 0;
		for (int i=0 ; i < arr.length; i++) {
			if (arr[i] <= day) {
				cnt++;
			} else {
				noOfBoquet += (cnt / k);
				cnt = 0;
			}
		}
		noOfBoquet += (cnt / k);
		return noOfBoquet >= m;
	}
	
}