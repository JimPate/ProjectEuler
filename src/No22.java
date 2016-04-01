import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;


public class No22 {

	public static Scanner sc;
	public static File f;
	public static final String path ="names.txt"; 
	public static LinkedList<String> names = new LinkedList<String>();
	public static int score;

	public static void main(String[] args) {
		readFile();
		score=0;
		for(int i=0; i<names.size(); i++) {
			score+=getNameValue(names.get(i))*(i+1);
		}
		System.out.println(score);
	}

	public static void readFile() {
		File f = new File(path);
		try {
			Scanner sc = new Scanner(f);
			String s = sc.nextLine();
			s=s.toUpperCase();
			s=s.replaceAll("\"", "");
			String [] sA = s.split(",");
			for(String name :sA){
				names.add(name);
			}
			Collections.sort(names);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static int getNameValue(String name) {
		int value = 0;
		for(int i=0; i<name.length(); i++) {
			value+=name.charAt(i)-'A'+1;
		}
		return value;
	}
}
