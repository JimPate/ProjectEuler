
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public class No58 {

	public static int diagPrimeCount = 0;
	public static Set<Integer> numbers = new HashSet<Integer>();

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

		int n = 1;
		addNumber(n);
		double ratio = 1;
		while(ratio>0.1) {
			n=n+2;
			addNumber(n);
			ratio = ((double)diagPrimeCount)/((n*2)-1);
		}
		System.out.println(n);
		System.out.println("Duration in ms: " + (System.currentTimeMillis() - start));
	}

	public static void addNumber(int n) {
		if(n==1) {
			numbers.add(n*n);
		}
		else {
			int num = n*n;
			for(int i=0; i<4; i++) {
				numbers.add(num);
				if(isPrime(num)) { 
					diagPrimeCount++;
				}
				num=num-(n-1);
			}
		}
	}

	public static boolean isPrime(int number) {

		if (number < 2) {
			return false;
		} else if (number == 2) {
			return true;
		} else {

			/* Versuche number mit der Zahl 2 zu teilen! */

			if (number % 2 == 0) {
				return false;
			}

			/* Versuche number mit den ungeraden Zahlen
               von 3 bis sqrt(number) zu teilen! */

			for (int i = 3; i <= Math.sqrt(number); i = i + 2) {

				if (number % i == 0) { // Teilertest
					return false;
				}
			}
			return true;
		}
	}



}
