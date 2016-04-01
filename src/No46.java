import java.util.*;

public class No46 {

	public static int cons = Integer.MAX_VALUE/100;
	public static boolean gestrichen[] = new boolean[cons];
	public static ArrayList<Integer> primes = new ArrayList<Integer>();

	public static void main(String[] args) {

		getAllPrimes();
		//System.out.println(primesToString());
		int number = getSearchedNumber();
		System.out.println("Smallest found Number: "+number);
	}

	/**
	 * Get all Prime numbers smaller than cons
	 */
	public static void getAllPrimes() {
		for(int i=0; i<gestrichen.length; i++) {
			gestrichen[i]=false;
		}

		for(int i=2; i<(int)Math.sqrt(cons)+2; i++) {
			if(!gestrichen[i-2]) {
				for(int j=(int)Math.pow(i, 2); j<cons+2; j=j+i) {
					gestrichen[j-2]=true;
				}
			}
		}

		for(int i=0; i<gestrichen.length; i++) {
			if(!gestrichen[i]) primes.add(i+2);
		}
	}

	/**
	 * @return String with all Primes
	 */
	public static String primesToString() {
		StringBuilder sb = new StringBuilder();
		for(int prime : primes) {
			sb.append(prime+"\n");
		}
		return sb.toString();
	}

	public static int getSearchedNumber() {
		int square = 1;
		int tmpSum = -1;
		boolean found = false;

		for(int i=2; i<cons; i++) {
			if((!primes.contains(i)) &&(i%2!=0)) {
				for(int j : primes) {
					//System.out.println("j: "+j);
					square=1;
					if(j>i) {
						break;
					}
					else {
						while(true) {
							tmpSum=j+2*(int)Math.pow(square, 2);
							//System.out.println("tmpSum: "+tmpSum);
							if(tmpSum>i) {
								break;
							}
							if(tmpSum==i) {
								found=true;
								System.out.println(i+"="+j+"+2*"+square+"^2");
								break;
							}
							square++;
						}
					}
					if(found) {
						break;
					}
				}

				if(!found) {
					return i;
				}
				else {
					found=false;
					tmpSum=-1;
					square=1;
				}
			}
		}
		return 0;
	}



}
