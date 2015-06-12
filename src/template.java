import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * 
 * @author Rodrigo Weffer
 * 
 */
public class template {

	public static void main(String... args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		template e = new template();
		System.out.println(e.solve(n));
	}

	private int solve(int n) {
		return 0;
	}
}