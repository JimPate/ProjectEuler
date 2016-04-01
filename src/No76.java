
public class No76 {

	static int[] numArray = new int[99];//{1,2,5,10,20,50,100,200};
	static int x = 100;
	static int countValue;
	static int l = numArray.length;

	public static void main(String[] args) {
		
		for(int i=0; i<l; i++) {
			numArray[i]=i+1;
		}
		for(int i=l-1; i>=0; i--) {
			count(i,x);
		}
		System.out.println(countValue);
	}

	public static void count(int pos, int value) {
		if(pos>=0) {
			int i = value/numArray[pos];
			int newValue;
			for(int j=i; j>0; j--) {
				newValue = value-numArray[pos]*j;
				if(newValue==0) {
					countValue++;
				}
				else {
					for(int k=pos-1; k>=0; k--) {
						count(k,newValue);
					}
				}
			}
		}
	}

}
