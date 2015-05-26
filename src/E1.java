import java.util.Scanner;

/**
 * Multiples of 3 and 5 Problem 1 If we list all the natural numbers below 10
 * that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
 * multiples is 23.
 * 
 * Find the sum of all the multiples of 3 or 5 below n.
 * 
 * @author rojosewe
 * 
 */
public class E1 {

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E1 e1 = new E1();
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(e1.solve(n));
	}

	/*
	 * It avoids going through non multiples, however the overhead of the
	 * conditionals makes it last longer.
	 */
	private int solve(int n) {
		int n3 = 3;
		int n5 = 5;
		int sum = 0;
		while (n3 < n || n5 < n) {
			if (n3 < n5) {
				sum += n3;
				n3 += 3;
			} else if (n3 > n5) {
				sum += n5;
				n5 += 5;
			} else {
				sum += n3;
				n5 += 5;
				n3 += 3;
			}
		}
		return sum;
	}

	private int naive(int n) {
		int sum = 0;
		for (int i = 3; i < n; i++) {
			if (i % 3 == 0 || i % 5 == 0)
				sum += i;
		}
		return sum;
	}
}
