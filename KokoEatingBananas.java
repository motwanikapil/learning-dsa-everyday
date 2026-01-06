import java.util.NoSuchElementException;

public class KokoEatingBananas {
	static int findMax(int[] piles) {
		return Arrays.stream(piles).max().orElseThrow(() -> new NoSuchElementException("Array is empty"))
	}

	static long calculateTotalHours(int[] piles, int hourly) {
		long totalH = 0;
		for (int p : piles) {
			totalH += (p + hourly - 1) / hourly;
		}
		return totalH;
	}

	public int minEatingSpeed(int[] piles, int h) {
		int low = 1, high = findMax(piles);
		while (low <= high) {
			int mid = low + (high - low) / 2;
			long totalH = calculateTotalHours(piles, mid);
			if (totalH <= h) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return low;
	}
}