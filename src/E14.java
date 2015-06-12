import java.io.IOException;

/**
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even) n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following
 * sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1 It can be seen that this sequence
 * (starting at 13 and finishing at 1) contains 10 terms. Although it has not
 * been proved yet (Collatz Problem), it is thought that all starting numbers
 * finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * 
 * @author Rodrigo Weffer
 * 
 */
public class E14 {

	public static void main(String... args) throws IOException {
		E14 e = new E14();
		System.out.println(e.solve());
	}
	
	int[] prev;
	
	private int collatz(long n){
		int count = 1;
		while(n > 1){
			if(n < prev.length && prev[(int)n] > 0)
				return count + prev[(int)n];
			count++;
			if(n % 2 == 0)
				n /= 2;
			else
				n = 3*n + 1;
		}
		return count;
	}

	private int solve() {
		int n = 1000000;
		prev = new int[n];
		int max = 0;
		int idx = 0;
		for(int i = 0; i < n; i++){
			int c = collatz(i);
			
			if(max < c){
				max = c;
				idx = i;
			}
		}
		
		return idx;
	}
}