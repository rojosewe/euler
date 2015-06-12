import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 * 
 * @author Rodrigo Weffer
 * 
 *         Solution : 1366
 * 
 */
public class E17 {

	public static void main(String... args) throws IOException {
		Scanner sc = new Scanner(System.in);
		E17 e = new E17();
		System.out.println(e.solve());
	}

	private int solve() {
		int singles = "onetwothreefourfivesixseveneightnine".length();
		int teens = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen".length();
		int decs = "twentythirtyfortyfiftysixtyseventyeightyninety".length();
		int hundreds = "hundred".length();
		int thousand = "thousand".length();
		int and = "and".length();
		//1-9
		int sum = singles;
		//10-19
		sum += teens;
		//20-99
		sum += decs * 10;
		sum += 8 * singles;
		
		//101-999
		sum += (99 * (hundreds + and) + sum) * 9 + singles * 100;
		
		//100, 200, 300, 400, 500, 600, 700, 800, 900
		sum +=  and + hundreds * 9;
		
		//1000
		sum += thousand;
		 
		
		return sum;
	}
}