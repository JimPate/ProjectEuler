
import java.math.BigInteger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v.marcenko
 */
public class No206 {
    
    
    public static final double minNumber = 1020304050607080900.0;
    public static final double maxNumber = 1929394959697989990.0;
    public static final double startNumberRoot =Math.sqrt(minNumber);
    public static final double endNumberRoot = Math.sqrt(maxNumber);
    public static double number;
    
    public static void main(String agrs[]) {
        number = startNumberRoot;
        while(number<endNumberRoot) {
            if(hasForm(Math.pow(number,2))) {
                break;
            }
            number++;
        }
        System.out.println("Number: "+number);
    }
    
    public static boolean hasForm(double number) {
        char[] num = (number+"").toCharArray();
        return ((num[0]=='1') && (num[2]=='2') && (num[4]=='3') &&
                (num[6]=='4') && (num[8]=='5') && (num[10]=='6') &&
                (num[12]=='7') && (num[14]=='8') && (num[16]=='9') &&
                (num[18]=='0'));
    }
    
}
