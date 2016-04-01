
public class No57 {


	public static void main(String[] args) {
		System.out.println("Wurzel 2 ist ungefähr: ");
		double wurzel;
		for(int i=1; i<100; i++) {
			wurzel=(wurzelZwei(i)+1);
			System.out.println("mit n="+i+"   : "+wurzel);
			System.out.println("mit einer Abweichung von: "+Math.abs(Math.sqrt(2)-wurzel));
		}
	}
	
	public static double wurzelZwei(int n) {
		if(n==0) {
			return 0;
		}
		return 1/(2+wurzelZwei(n-1));
	}

}
