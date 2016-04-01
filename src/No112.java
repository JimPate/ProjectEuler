/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author v.marcenko
 */
public class No112 {

    public static final double startingNumber = 100;
    public static double currentNumber = startingNumber;
    public static double bouncyNumbers = 0;
    public static double proportion = 0;
    public static final double expectedProportion = 0.99;

    public static void main(String args[]) {
        while (proportion < expectedProportion) {
            if (isBouncy(currentNumber)) {
                bouncyNumbers++;
            }
            proportion = bouncyNumbers / currentNumber;
            currentNumber++;
        }
        System.out.println("proportion is " + proportion + " for number " + (currentNumber-1));
    }

    public static boolean isBouncy(Double number) {

        char[] num = (number + "").toCharArray();
        int eq = 0;
        boolean bigger = false;
        for (int i = 0; i < num.length - 3; i++) {
            if (eq == 0) {
                if (num[i] != num[i + 1]) {
                    eq = 1;
                    bigger = num[i] < num[i + 1];
                }
            }
            if ((eq == 1) && (bigger)) {
                if (num[i] > num[i + 1]) {
                    return true;
                }
            }
            if ((eq == 1) && (!bigger)) {
                if (num[i] < num[i + 1]) {
                    return true;
                }
            }
        }

        return false;
    }
}
