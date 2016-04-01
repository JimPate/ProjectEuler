import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class No19 {


	public static void main(String[] args) {
		
		int count = 0;
		
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar c1 = Calendar.getInstance();
	    Calendar c2 = Calendar.getInstance();
	    c1.set(1901, 0 , 1); 
	    c2.set(2000,11, 31);

	    while(c1.compareTo(c2)<0) {
	    	if((c1.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) && (c1.get(Calendar.DAY_OF_MONTH)==1)) {
	    		count++;
	    	}
	    	c1.add(Calendar.DATE,1);
	    }
	    System.out.println(count);
	}

}
