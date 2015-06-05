import java.util.ArrayList;
import java.util.Scanner;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13. What is the 10 001st prime number?
 * 
 * @author Rodrigo Weffer
 * 
 */
public class E10 {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E10 e = new E10();
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(e.solve(n));
	}

	private long solve(int n) {
		ArrayList<Integer> primes = new ArrayList<Integer>(n);
		primes.add(2);
		primes.add(3);
		int i = 5;
		long sum = 0;
		while (i < n) {
			if (isPrime(primes, i)){
				primes.add(i);
				sum += i;
			}
			i += 2;
		}

		return sum + 5;
	}

	private boolean isPrime(ArrayList<Integer> primes, int x) {
		for (int prime : primes) {
			if (prime * prime > x)
				return true;
			if (x % prime == 0) {
				return false;
			}
		}
		return true;
	}

}
