import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Starting in the top left corner of a 2×2 grid, and only being able to move to
 * the right and down, there are exactly 6 routes to the bottom right corner.
 * 
 * 
 * How many such routes are there through a 20×20 grid?
 * 
 * @author Rodrigo Weffer
 * 
 */
public class E15 {

	public static void main(String... args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		E15 e = new E15();
		System.out.println(e.combinatorials(n));
	}
	
	private BigInteger combinatorials(int n) {
		BigInteger combs = BigInteger.ONE;
		BigInteger p = BigInteger.ONE;

		for(int i = 2*n; i > n; i--){
			combs = combs.multiply(BigInteger.valueOf(i));
		}
		
		for(int i = n; i > 1; i--){
			p = p.multiply(BigInteger.valueOf(i));
		}
		
		return combs.divide(p);
	}

	private int btrak(int size) {
		int paths = 0;
		paths = travel(size, 0,0);
		return paths;
	}

	private int travel(int n, int i, int j) {
		int count = 0;
		if(i == n && j == n)
			return 1;
		if(i < n){
			count += travel(n, i + 1, j);
		}
		if(j < n){
			count += travel(n, i, j + 1);
		}
		return count;
	}
}