import java.util.Scanner;

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for
 * which,
 * 
 * a2 + b2 = c2 For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find
 * the product abc.
 * 
 * @author Rodrigo Weffer
 * 
 */
public class E9 {
	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E9 e = new E9();
		int n = Integer.parseInt(sc.nextLine());
		System.out.println(e.solve(n));
	}

	private int solve(int x) {
		for (int m = 1; m <= x; m++) {
			double n = ((x/2*m) - m);
			if (n % 1 == 0) {
				int a = (int) (2 * Math.pow(m, 2) * Math.pow(n, 2));
				int b = (int) (Math.pow(m, 2) - Math.pow(n, 2));	
				int c = (int) (Math.pow(m, 2) + Math.pow(n, 2));
				if (a > 0 && b > 0 && c > 0 && (a + b + c == x)	&& (Math.pow(a, 2) + Math.pow(b, 2) == Math.pow(c, 2))) {
					System.out.println("a = " + a);
					System.out.println("b = " + b);
					System.out.println("c = " + c);
					return a * b * c;
				}
			}
		}
		return 0;
	}

	/*
	 * I misread the problem, still kind of a cool solution to finding euclidean
	 * parts.
	 */
	private int niceTry(int n) {
		double a = 0;
		int c = n;
		for (int b = 2; b < 1000; b++) {
			a = Math.sqrt(c - (b * b));
			if (a % 1 == 0) {
				System.out.println(a + ", " + b);
				return (int) (a * b * Math.sqrt(c));
			}
		}
		return 0;
	}

}
