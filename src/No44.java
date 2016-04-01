import java.util.ArrayList;


public class No44 {

	public static ArrayList<Integer> numbers = new ArrayList<Integer>();
	public static final int nextNumbersCount = 10000000;	
	public static int n=1;
	public static int minD = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		createNextNumbers();
		isPentagonal();
	}

	public static void createNextNumbers() {
		System.out.println("creating new Numbers");
		for(int i=n; i<nextNumbersCount+n; i++) {
			numbers.add(i*(3*i-1)/2);
		}
		n+=nextNumbersCount;
	}

	
	public static String isPentagonal() {
		int sum;
		int diff;
		int pi,pj;
		
		for(int i=0; i<numbers.size(); i++) {
			for(int j=0; j<numbers.size(); j++) {
				pi=numbers.get(i);
				pj=numbers.get(j);
				sum=pi+pj;
				diff=(pi>pj)?pi-pj:pj-pi;
				if(numbers.get(numbers.size()-1)<sum) {
					createNextNumbers();
				}
				if((numbers.contains(diff))&&(numbers.contains(sum))) {
					System.out.println("pi: "+pi+", pj: "+pj);
					minD=(minD<diff)?minD:diff;
				}
			}
		}
		return "";
	}
	
}
