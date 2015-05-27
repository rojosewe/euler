import java.util.Scanner;


public class E6 {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E6 e = new E6();
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(e.solve(n));
	}

	private int solve(int n) {
		return (((n*(n+1))/2) * (n*(n+1))/2) - ((n * (n+1) * (2*n +1 )) / 6);
	}
}
