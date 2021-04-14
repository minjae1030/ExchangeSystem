package exchangesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OutputClass {
	public static String tempusdstr="";
	public static String tempeurstr="";
	public static String tempjpystr="";
	public void saveDATA(int inputchagetype) throws IOException {
		InputClass inputClass = new InputClass();
		RunExchangeClass runClass = new RunExchangeClass();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		FileWriter fw = new FileWriter("C:\\Users\\kmj\\Desktop\\ExchangeSystemOutput.csv", true);
		File file = new File("C:\\Users\\kmj\\Desktop\\ExchangeSystemOutput.csv");
		int inputmoney = inputClass.inputmoney; // InputClass로부터 환전할 요청 금액
		String type; // 환전 종류
		String text;
		String first = "환전종류,환전일 및 시간,요청금액,환전금액,거스름돈(원),보유외화\n";
		if(file.exists() == false) {
			fw.write(first);
		}
		if (inputchagetype == 1) {
			type = "USD";
			int array[] = runClass.outusdresult(inputmoney);
			
			text = type + "," + sdt.format(cal.getTime()) + "," + inputmoney + "," + array[0] + "," + array[1] + ","
					+ runClass.reaminUSDbalance + "," + tempusdstr + "\n";
			fw.write(text);

		} else if (inputchagetype == 2) {
			type = "EUR";
			int array[] = runClass.outeurresult(inputmoney);
			text = type + "," + sdt.format(cal.getTime()) + "," + inputmoney + "," + array[0] + "," + array[1] + ","
					+ runClass.remainEURbalance +"," + tempeurstr + "\n";
			fw.write(text);

		} else if (inputchagetype == 3) {
			type = "JPY";
			int array[] = runClass.outjpyresult(inputmoney);
			text = type + "," + sdt.format(cal.getTime()) + "," + inputmoney + "," + array[0] + "," + array[1] + ","
					+ runClass.remainJPYbalance + "," + tempjpystr + "\n";
			fw.write(text);

		} else {
		}

		fw.close();

	}

	public int[] writeUSD(int outputUSD100, int outputUSD50, int outputUSD10, int outputUSD5, int outputUSD2,
			int outputUSD1) {
		int[] array = { outputUSD100, outputUSD50, outputUSD10, outputUSD5, outputUSD2, outputUSD1 };
		return array;
	}

	public int[] writeEUR(int outputEUR500, int outputEUR100, int outputEUR50, int outputEUR20, int outputEUR10,
			int outputEUR5, int outputEUR2, int outputEUR1) {
		int[] array = { outputEUR500, outputEUR100, outputEUR50, outputEUR20, outputEUR10, outputEUR5, outputEUR2,
				outputEUR1 };
		return array;
	}
	
	public int[] writeJPY(int outputJPY10000, int outputJPY5000, int outputJPY1000,
			int outputJPY500, int outputJPY100) {
		int[] array = {outputJPY10000,  outputJPY5000, outputJPY1000,
				outputJPY500, outputJPY100};
		return array;
	}
	

	private void printResultUSD(int returnRealUSD, int outputUSD100, int outputUSD50, int outputUSD10, int outputUSD5,
			int outputUSD2, int outputUSD1) {
		System.out.println(returnRealUSD + " doller");
		System.out.println("100 달러 지폐 " + outputUSD100 + " 장 ");
		System.out.println("50 달러 지폐" + outputUSD50 + " 장 ");
		System.out.println("10 달러 지폐 " + outputUSD10 + " 장 ");
		System.out.println("5 달러 지폐 " + outputUSD5 + " 장 ");
		System.out.println("2 달러 동전 " + outputUSD2 + " 개 ");
		System.out.println("1 달러 동전 " + outputUSD1 + " 개 ");
		
	}

	private void printResultEUR(int returnRealEUR, int outputEUR500, int outputEUR100, int outputEUR50, int outputEUR20,
			int outputEUR10, int outputEUR5, int outputEUR2, int outputEUR1) {
		System.out.println(returnRealEUR + " EUR");
		System.out.println("500 유로 지폐" + outputEUR500 + " 장");
		System.out.println("100 유로 지폐" + outputEUR100 + " 장");
		System.out.println("50 유로 지폐" + outputEUR50 + " 장");
		System.out.println("10 유로 지폐" + outputEUR10 + " 장");
		System.out.println("5 유로 동전" + outputEUR5 + " 개");
		System.out.println("2 유로 동전" + outputEUR2 + " 개");
		System.out.println("1 유로 동전" + outputEUR1 + " 개");

	}

	private void printResultJPY(int returnRealJPY, int outputJPY10000, int outputJPY5000, int outputJPY1000,
			int outputJPY500, int outputJPY100) {
		System.out.println(returnRealJPY + " JPY");
		System.out.println("10000엔 지폐" + outputJPY10000 + " 장");
		System.out.println("5000엔 지폐" + outputJPY5000 + " 장");
		System.out.println("1000엔 지폐" + outputJPY1000 + " 장");
		System.out.println("500엔 동전" + outputJPY500 + " 개");
		System.out.println("100엔 동전" + outputJPY100 + " 개");
	}

	private void printResultWon(int charge, int returnWon1000, int returnWon500, int returnWon100, int returnWon50,
			int returnWon10) {
		System.out.println("\n잔돈 = " + charge + " 원 ");
		System.out.println("1000 원 지폐 " + returnWon1000 + " 장 ");
		System.out.println("500 원 동전 " + returnWon500 + " 개 ");
		System.out.println("100 원 동전 " + returnWon100 + " 개 ");
		System.out.println("50 원 동전 " + returnWon50 + " 개 ");
		System.out.println("10 원 동전 " + returnWon10 + " 개 ");
	}

	public void outputResultUSD(int returnRealUSD) {
		int outputUSD100, outputUSD50, outputUSD10;
		int outputUSD5, outputUSD2, outputUSD1;

		outputUSD100 = (returnRealUSD / ConstValueClass.CHANGE_USD_100);
		outputUSD50 = ((returnRealUSD % ConstValueClass.CHANGE_USD_100)) / 50;
		outputUSD10 = (((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) / 10;
		outputUSD5 = ((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) / 5;
		outputUSD2 = (((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) % 5) / 2;
		outputUSD1 = ((((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) % 5) % 2);

		printResultUSD(returnRealUSD, outputUSD100, outputUSD50, outputUSD10, outputUSD5, outputUSD2, outputUSD1);
		int temp[] = writeUSD(outputUSD100, outputUSD50, outputUSD10, outputUSD5, outputUSD2, outputUSD1);
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length-1) {
				tempusdstr += temp[i]+"";
			} else {
				tempusdstr += temp[i]+",";
			}
			
		}
	}

	public void outputResultEUR(int returnRealEUR) {
		int outputEUR500, outputEUR100, outputEUR50, outputEUR20;
		int outputEUR10, outputEUR5, outputEUR2, outputEUR1;

		outputEUR500 = (returnRealEUR / ConstValueClass.CHANGE_EUR_500);
		outputEUR100 = ((returnRealEUR % ConstValueClass.CHANGE_EUR_500)) / 100;
		outputEUR50 = ((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) / 50;
		outputEUR20 = (((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) / 20;
		outputEUR10 = ((((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) % 20) / 10;
		outputEUR5 = (((((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) % 20) % 10) / 5;
		outputEUR2 = ((((((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) % 20) % 10) % 5) / 2;
		outputEUR1 = (((((((returnRealEUR % ConstValueClass.CHANGE_EUR_500) % 100) % 50) % 20) % 10) % 5) % 2) / 1;

		printResultEUR(returnRealEUR, outputEUR500, outputEUR100, outputEUR50, outputEUR20, outputEUR10, outputEUR5,
				outputEUR2, outputEUR1);
		int temp[] = writeEUR(outputEUR500, outputEUR100, outputEUR50, outputEUR20, outputEUR10, outputEUR5,
				outputEUR2, outputEUR1);
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length-1) {
				tempeurstr += temp[i]+"";
			} else {
				tempeurstr += temp[i]+",";
			}
			
		}

	}

	public void outputResultJPY(int returnRealJPY) {
		int outputJPY10000, outputJPY5000, outputJPY1000, outputJPY500, outputJPY100;

		outputJPY10000 = (returnRealJPY / ConstValueClass.CHANGE_JPY_10000);
		outputJPY5000 = ((returnRealJPY % ConstValueClass.CHANGE_JPY_10000)) / 5000;
		outputJPY1000 = (((returnRealJPY % ConstValueClass.CHANGE_JPY_10000) % 5000)) / 1000;
		outputJPY500 = (((returnRealJPY % ConstValueClass.CHANGE_JPY_10000) % 5000) % 1000) / 500;
		outputJPY100 = ((((returnRealJPY % ConstValueClass.CHANGE_JPY_10000) % 5000) % 1000) % 500) / 100;

		printResultJPY(returnRealJPY, outputJPY10000, outputJPY5000, outputJPY1000, outputJPY500, outputJPY100);
		int temp [] = writeJPY(outputJPY10000, outputJPY5000, outputJPY1000, outputJPY500, outputJPY100);
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length-1) {
				tempjpystr += temp[i]+"";
			} else {
				tempjpystr += temp[i]+",";
			}
			
		}
	}

	public void outputResultWon(int charge) {
		int returnWon1000, returnWon500, returnWon100, returnWon50, returnWon10;
		returnWon1000 = charge / 1000;
		returnWon500 = (charge % 1000) / 500;
		returnWon100 = ((charge % 1000) % 500) / 100;
		returnWon50 = (((charge % 1000) % 500) % 100) / 50;
		returnWon10 = ((((charge % 1000) % 500) % 100) % 50) / 10;

		printResultWon(charge, returnWon1000, returnWon500, returnWon100, returnWon50, returnWon10);


	}

	public void printErrorMessage(int errorCode) {
		switch (errorCode) {
		case ConstValueClass.ERR_BALANCE_USD:
			System.out.println("보유 달러 : " + ConstValueClass.BALANCE_USD);
			System.out.print("달러 ");
			break;
		case ConstValueClass.ERR_BALANCE_EUR:
			System.out.println("보유 유로 : " + ConstValueClass.BALANCE_EUR);
			System.out.print("유로 ");
			break;
		case ConstValueClass.ERR_BALANCE_JPY:
			System.out.println("보유 앤화 : " + ConstValueClass.BALANCE_JPY);
			System.out.print("앤화 ");
			break;
		}
		System.out.println("보유 잔액이 부족합니다.");
	}

	public void printRemainUSD(double usd) {
		System.out.println("남은 달러는 : " + usd);
	}

	public void printRemainEUR(double eur) {
		System.out.println("남은 유로는 : " + eur);
	}

	public void printRemainJPY(double jpy) {
		System.out.println("남은 엔화는 : " + jpy);
	}

}
