import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 215 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 21000?
 * 
 * @author Rodrigo Weffer
 * 
 * Solution : 1366
 * 
 */
public class E16 {

	public static void main(String... args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		E16 e = new E16();
		System.out.println(e.solve(n));
	}

	private String solve(int n) {
		BigInteger x = new BigInteger("2").pow(n);
		Integer sum = 0;
		for(char t  : x.toString().toCharArray()){
			sum += Character.getNumericValue(t); 
		}
		return sum.toString();
	}
}