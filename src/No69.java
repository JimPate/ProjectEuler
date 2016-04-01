import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class No69 {

	public static int n = 10;
	public static int nMax;
	public static double maxValue = -1;

	public static void main(String[] args) {
		getN();
		System.out.println(nMax);
	}

	public static int getPhi(int n) {

		int phi = 0;
		if(isPrime(n)) return n-1;

		for(int i=1; i<n; i++) {
			if(n%i!=0) {
				phi++;
				if(n/((double)phi)<maxValue) break;
			}
		}
		return phi;
	}


	public static void getN() {
		Scanner sc;
		int n,phi;
		double tmp;
		try {
			sc = new Scanner(new File("phi.txt"));
			while(sc.hasNext()) {
				n=sc.nextInt();
				phi=sc.nextInt();
				tmp=n/((double)phi);
				if(tmp>maxValue) {
					maxValue=tmp;
					nMax=n;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
