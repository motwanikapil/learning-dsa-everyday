import java.util.HashMap;
import java.util.HashSet;

public class NumberOfCenteredSubarrays {
	static void printArr(int[] arr) {
		for(int num : arr) {
			System.out.print(num+" ");
		}
	}
	static int centeredSubarrays(int[] nums) {
		 int[] nexorviant = nums;

    int n = nexorviant.length;
    int count = 0;

    for (int i = 0; i < n; i++) {
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for (int j = i; j < n; j++) {
            sum += nexorviant[j];
            set.add(nexorviant[j]);

            if (set.contains(sum)) {
                count++;
            }
        }
    }
    return count;
	}
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1};
		System.out.println("centered "+centeredSubarrays(nums));
	}
}