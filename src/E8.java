import java.util.Scanner;

/**
 * The four adjacent digits in the 1000-digit number that have the greatest
 * product are 9 × 9 × 8 × 9 = 5832.
 * 73167176531330624919225119674426574742355349194934
 * 96983520312774506326239578318016984801869478851843
 * 85861560789112949495459501737958331952853208805511
 * 12540698747158523863050715693290963295227443043557
 * 66896648950445244523161731856403098711121722383113
 * 62229893423380308135336276614282806444486645238749
 * 30358907296290491560440772390713810515859307960866
 * 70172427121883998797908792274921901699720888093776
 * 65727333001053367881220235421809751254540594752243
 * 52584907711670556013604839586446706324415722155397
 * 53697817977846174064955149290862569321978468622482
 * 83972241375657056057490261407972968652414535100474
 * 82166370484403199890008895243450658541227588666881
 * 16427171479924442928230863465674813919123162824586
 * 17866458359124566529476545682848912883142607690042
 * 24219022671055626321111109370544217506941658960408
 * 07198403850962455444362981230987879927244284909188
 * 84580156166097919133875499200524063689912560717606
 * 05886116467109405077541002256983155200055935729725
 * 71636269561882670428252483600823257530420752963450
 * 
 * Find the thirteen adjacent digits in the 1000-digit number that have the
 * greatest product. What is the value of this product?
 * 
 * @author Rodrigo Weffer
 * 
 */

public class E8 {
	static String sblock = "73167176531330624919225119674426574742355349194934"
			+ "96983520312774506326239578318016984801869478851843"
			+ "85861560789112949495459501737958331952853208805511"
			+ "12540698747158523863050715693290963295227443043557"
			+ "66896648950445244523161731856403098711121722383113"
			+ "62229893423380308135336276614282806444486645238749"
			+ "30358907296290491560440772390713810515859307960866"
			+ "70172427121883998797908792274921901699720888093776"
			+ "65727333001053367881220235421809751254540594752243"
			+ "52584907711670556013604839586446706324415722155397"
			+ "53697817977846174064955149290862569321978468622482"
			+ "83972241375657056057490261407972968652414535100474"
			+ "82166370484403199890008895243450658541227588666881"
			+ "16427171479924442928230863465674813919123162824586"
			+ "17866458359124566529476545682848912883142607690042"
			+ "24219022671055626321111109370544217506941658960408"
			+ "07198403850962455444362981230987879927244284909188"
			+ "84580156166097919133875499200524063689912560717606"
			+ "05886116467109405077541002256983155200055935729725"
			+ "71636269561882670428252483600823257530420752963450";

	public static void main(String... args) {
		Scanner sc = new Scanner(System.in);
		E8 e = new E8();
		int n = Integer.parseInt(sc.nextLine());
		char[] charArray = sblock.toCharArray();
		Integer[] block = new Integer[sblock.length()];
		for (int i = 0; i < block.length; i++) {
			block[i] = Character.getNumericValue(charArray[i]);
		}
		System.out.println(e.solve(n, block));
	}
	
	private long naive(int n, Integer[] block) {
		long max = 0;
		long prod = 1;
		for (int i = 0; i < block.length - n; i++) {
			prod = 1;
			for (int j = i; j < i + n; j++) {
				prod *= block[j];
			}
			max = Math.max(max, prod);
		}
		return max;
	}
	
	private long solve(int n, Integer[] block) {
		long prod = 1;
		long max = 0;
		int lastZero = 0;
		for (int i = 0; i < block.length; i++) {
			if(block[i] == 0){
				lastZero = 0;
				prod = 1;
			}else{
				prod *= block[i];
				if(lastZero >= n && block[i - n] != 0)
					prod /= block[i-n];
			}
			max = Math.max(max, prod);
			lastZero++;
			System.out.println("--------------------------");
		}
		
		return max;
	}

	private int kmpish(int n, Integer[] block) {
		int prev = 0 - n;
		int prod = 1;
		int max = 0;

		int[] zeroTrails = preprocess(block);

		for (int i = 0; i < block.length; i++) {
			if (block[i] != 0) {
				prod *= block[i];
				if (prev >= 0) {
					if (block[prev] != 0)
						prod /= block[prev];
					if(prod > max){
						System.out.println("max: " + max);
						print(block, i, n);
						max = prod;
					}
				}
			} else {
				prod = 1;
				if (zeroTrails[i] > n) {
					i += n - 1;
					prev += n - 1;
					for (int j = 0; j < n - 1; j++) {
						prod *= block[i - j];
					}
				} else {
					prev += zeroTrails[i];
					i += zeroTrails[i];
				}
			}
			prev++;
		}

		return max;
	}

	private void print(Integer[] block, int i, int n) {
		System.out.print("prod Sq.: ");
		for(int j = i - n + 1; j <= i; j++){
			System.out.print(block[j]);
		}
		System.out.println("");
	}

	private int[] preprocess(Integer[] block) {
		int[] zeroTrails = new int[block.length];
		int counter = 0;
		for (int i = block.length - 1; i >= 0; i--) {
			if (block[i] == 0) {
				zeroTrails[i] = counter;
				counter = -1;
			}
			counter++;
		}
		return zeroTrails;
	}
/*
 * 13
max: 0
prod Sq.: 1671765313306
max: 6
prod Sq.: 6717653133062
max: 12
prod Sq.: 7176531330624
max: 48
prod Sq.: 1765313306249
max: 432
prod Sq.: 6531330624919
max: 3888
prod Sq.: 5313306249192
max: 7776
prod Sq.: 3133062491922
max: 15552
prod Sq.: 1330624919225
max: 77760
prod Sq.: 0624919225119
max: 699840
prod Sq.: 6249192251196
max: 4199040
prod Sq.: 2491922511967
max: 4898880
prod Sq.: 4919225119674
max: 9797760
prod Sq.: 9225119674426
max: 13063680
prod Sq.: 2511967442657
max: 25401600
prod Sq.: 5119674426574
max: 50803200
prod Sq.: 1196744265747
max: 71124480
prod Sq.: 1967442657474
max: 284497920
prod Sq.: 9674426574742
max: 568995840
prod Sq.: 5349194934969
max: 1020366720
prod Sq.: 3491949349698
max: 1632586752
prod Sq.: 9194934969835
max: 2040733440
prod Sq.: 9781797784617
2091059712
2048385024
 */
}
