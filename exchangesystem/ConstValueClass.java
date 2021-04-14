package exchangesystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConstValueClass {
	public static final double EX_USD = 1133.9;
	public static final double EX_EUR = 1333.16;
	public static final double EX_JPY = 10.3;

	public static final int CHANGE_TYPE_USD = 1;
	public static final int CHANGE_TYPE_EUR = 2;
	public static final int CHANGE_TYPE_JPY = 3;

	public static final int CHANGE_USD_100 = 100;
	public static final int CHANGE_EUR_500 = 500;
	public static final int CHANGE_JPY_10000 = 10000;

	public static double BALANCE_USD = 1000;
	public static double BALANCE_EUR = 1000;
	public static double BALANCE_JPY = 5000;

	public static final int ERR_BALANCE_USD = 1;
	public static final int ERR_BALANCE_EUR = 2;
	public static final int ERR_BALANCE_JPY = 3;
	
	public void setBalance () throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\kmj\\Desktop\\ExchangeSystemOutput.txt"));
		String line;
		String line_arr [] = null;
		String temp = "";
		 while ((line = reader.readLine()) != null) {
			 line_arr = line.split("\n");
	         }
		 for (int i = 0; i < line_arr.length; i++) {
			 if (i == line_arr.length -1) {
		
			 }
		 }
	}
	
}
	

	
