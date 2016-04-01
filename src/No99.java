
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author v.marcenko
 */
public class No99 {

    public static Scanner sc;
    public static File f;
    public static final String path = "base_exp.txt";
    public static ArrayList<Double> base = new ArrayList<Double>();
    public static ArrayList<Double> exp = new ArrayList<Double>();
    public static int maxLineNumber = 0;

    public static void main(String[] args) {
        readFile();
        double maxNumber = 0;
        double tmpNumber = 0;
        for (int i = 0; i < base.size(); i++) {
            tmpNumber = exp.get(i) * Math.log(base.get(i));
            System.out.println(tmpNumber);
            if (tmpNumber > maxNumber) {
                maxNumber = tmpNumber;
                maxLineNumber = (i + 1);
            }
        }
        System.out.println("biggest value in line " + maxLineNumber);
    }

    public static void readFile() {
        File f = new File(path);
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] sA = s.split(",");
                base.add(Double.parseDouble(sA[0]));
                exp.add(Double.parseDouble(sA[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
