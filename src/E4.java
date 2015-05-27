import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class E4 {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E4 e = new E4();
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(e.solve(n));
	}

	/*
	 * The naive one, maybe patterns...
	 */
	private int solve(int n) {
		int largest = -1;
		for(int i = 999; i > 500; i--){
			for(int j = 999; j > 500; j--){
				Integer res = i*j;
				if(res < largest)
					break;
				if(isPalindrome(res)){
					largest = Math.max(res, largest);
				}
			}
		}
		return largest;
	}
	
	class Result implements Comparable<Result>{
		Integer i;
		Integer j;
		Integer prod;
		public Result(int i, int j, int prod) {
			super();
			this.i = i;
			this.j = j;
			this.prod = prod;
		}
		@Override
		public int compareTo(Result o) {
			return o.prod.compareTo(this.prod);
		}
		
		public String toString(){
			return prod + " = " + i + " * " + j;
		}
	}
	
	private int explorePatterns(int n) {
		LinkedList<Result> chain = new LinkedList<Result>();
		for(int i = 999; i > 500; i--){
			for(int j = 999; j > 500; j--){
				Integer res = i*j;
				if(isPalindrome(res)){
					Result result = new Result(i, j, res);
					chain.add(result);
				}
			}
		}
		
		Collections.sort(chain);
		System.out.println(chain);
		return 0;
	}

	private boolean isPalindrome(Integer res){
		if(res < 0)
			return false;
		boolean pal = true;
		int base = (int) Math.pow(10, Math.ceil(Math.log10(res)) - 1);
		while(res > 9){
			int last = res % ((res /10)*10);
			int first = res / base ;
			pal &= last == first;
			if(!pal)
				return false;
			res -= first * base;
			res /= 10;
			base /= 100;
		}
		return true;
	}

}
