import java.util.HashSet;

class CountResiduePrefixes {
	public static int residuePrefixes(String s) {
		HashSet<Character> hs = new HashSet<>();
		int count = 0;

		for (int i=0 ; i < s.length() ; i++) {
			hs.add(s.charAt(i));
			if (hs.size() == ((i+1) % 3)) {
				count++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String s = "dd";
		System.out.println("residue "+residuePrefixes(s));
	}
}