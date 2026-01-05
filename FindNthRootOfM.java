class FindNthRootOfM {
	// static long func(int mid, int n) {
	// 	long ans = 1;
	// 	while (n > 0) {
	// 		if (n % 2 == 1) {
	// 			ans = ans * mid;
	// 			n = n - 1;
	// 		} else {
	// 			mid = mid * mid;
	// 			n = n / 2;
	// 		}
	// 	}
	// 	return (int) ans;
	// }

	static int func(int mid, int n, int m) {
		long ans = 1;
		for (int i = 1; i <= n ; i++) {
			ans = ans * mid;
			if (ans > m) return 2;
		}
		if (ans == m) return 1;
		return 0;
	}

	static int nthRoot(int n, int m) {
		int low = 1, high = m;

		while (low <= high) {
			int mid = (low + high) / 2;
			long midN = func(mid, n, m);
			if (midN == 1) {
				return mid;
			} else if (midN == 0) low = mid + 1;
			else high = mid - 1;
		}

		return -1;
	}

	public static void main(String[] args) {
		System.out.println("3rd root of 27 is : "+nthRoot(3, 27));
	}

}