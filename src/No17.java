import java.util.HashMap;


public class No17 {

	public static final HashMap<Integer, String> numberString = new HashMap<Integer, String>();
	public static int border = 1000;

	public static void main(String[] args) {
		init();
		int count = 0;
		for(int i=1; i<=border; i++) {
			count+=createWord(i).length();
		}
		System.out.println(count);

	}

	public static String createWord(int number) {

		int startMod = (int) Math.pow(10,(number+"").length()-1);
		int i;
		StringBuilder sb = new StringBuilder();

		while(number>0) {
			i=number/startMod;
			switch(startMod) {
			case 1: { 
				sb.append(numberString.get(i)); 
				break;
			}
			case 10: { 
				if(number<20) {
					sb.append(numberString.get(number));
					number=0; 
				}
				else {
					sb.append(numberString.get(i*startMod));
				}
				break;
			}
			case 100: { 
				sb.append(numberString.get(i)); 
				sb.append(numberString.get(100)); 
				if(number-startMod*i>0) sb.append(numberString.get(-1)); 
				break;
			}
			case 1000: { 
				sb.append(numberString.get(i)); 
				sb.append(numberString.get(1000)); 
				break;
			}
			default: break;
			}	
			number-=startMod*i;
			startMod/=10;
		}
		return sb.toString();		
	}

	public static void init() {
		numberString.put(1, "one");
		numberString.put(2, "two");
		numberString.put(3, "three");
		numberString.put(4, "four");
		numberString.put(5, "five");
		numberString.put(6, "six");
		numberString.put(7, "seven");
		numberString.put(8, "eight");
		numberString.put(9, "nine");
		numberString.put(10, "ten");
		numberString.put(11, "eleven");
		numberString.put(12, "twelve");
		numberString.put(13, "thirteen");
		numberString.put(14, "fourteen");
		numberString.put(15, "fifteen");
		numberString.put(16, "sixteen");
		numberString.put(17, "seventeen");
		numberString.put(18, "eighteen");
		numberString.put(19, "nineteen");
		numberString.put(20, "twenty");
		numberString.put(30, "thirty");
		numberString.put(40, "forty");
		numberString.put(50, "fifty");
		numberString.put(60, "sixty");
		numberString.put(70, "seventy");
		numberString.put(80, "eighty");
		numberString.put(90, "ninety");
		numberString.put(100, "hundred");
		numberString.put(1000, "thousand");
		numberString.put(-1,"and");		
	}


}
