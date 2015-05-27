import java.util.Scanner;


public class E5 {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E5 e = new E5();
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(e.solve(n));
	}

	private int solve(int n) {
		
		int prod = 1;
		for(int i = 2; i < n; i++){
			boolean max = true;
			for(int j = n-1; j > i; j--){
				max &= mcd(i, j) == 1;
			}
			if(max)
				prod *= i;
		}
		
		return prod;
	}

	private int mcd(int i, int j) {
		if(j == 0)
			return i;
		else
			return mcd(j, i % j);
	}

}
