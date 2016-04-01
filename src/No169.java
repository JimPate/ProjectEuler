
public class No169 {

	public static int count;
	
	public static void main(String[] args) {

		
	}
	
	public static void check(int num) {
		int exp = (int)Math.sqrt(num);
		int value = num;
		int tmp = 0;
		int count = 0;
		boolean end = false;
		while(!end) {
			tmp=(int)Math.pow(2, exp);
			value=value-tmp;
			if(value<tmp) {
				exp--;
			}
			if(tmp<0) {
				end=true;
			}
		}
	
	}
	
}
