import java.util.Scanner;

/**
 * The sum of the squares of the first ten natural numbers is,
 * 
 * 12 + 22 + ... + 102 = 385 The square of the sum of the first ten natural
 * numbers is,
 * 
 * (1 + 2 + ... + 10)2 = 552 = 3025 Hence the difference between the sum of the
 * squares of the first ten natural numbers and the square of the sum is 3025 −
 * 385 = 2640.
 * 
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 * @author Rodrigo Weffer
 * 
 */

public class E6 {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E6 e = new E6();
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(e.solve(n));
	}

	private int solve(int n) {
		return (((n * (n + 1)) / 2) * (n * (n + 1)) / 2)
				- ((n * (n + 1) * (2 * n + 1)) / 6);
	}
}
