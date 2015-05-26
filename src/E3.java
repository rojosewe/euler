import java.util.Scanner;

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * 
 * What is the largest prime factor of the number 600851475143 ?
 * 
 * @author rojosewe
 * 
 */

public class E3 {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E3 e3 = new E3();
		long n = Long.parseLong(sc.nextLine());
		System.out.println(e3.solve(n));
	}

	private long solve(long n) {
		if (n < 3)
			return n;
		for (long i = n / 2; i > 1; i--) {
			if (n % i == 0) {
				if (isPrime(i));
					return i;
			}
		}

		return 1;
	}

	private boolean isPrime(long n) {
		if (n <= 3)
			return true;
		if (n % 2 == 0 || n % 3 == 0)
			return false;
		for (int i = 5; i * i <= n; i += 6) {
			if (n % i == 0 || n % (i + 2) == 0)
				return false;
		}
		return true;
	}
}
