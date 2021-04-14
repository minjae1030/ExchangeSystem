package exchangesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OutputClass {
	public static String tempusdstr = ""; // usd 지폐 개수를 저장하기 위한 string
	public static String tempeurstr = "";
	public static String tempjpystr = "";

	public void saveDATA(int inputchagetype) throws IOException {
		InputClass inputClass = new InputClass();
		RunExchangeClass runClass = new RunExchangeClass();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		FileWriter fw = new FileWriter("C:\\Users\\kmj\\Desktop\\ExchangeSystemOutput.csv", true); // 파일 붙여쓰기

		int inputmoney = inputClass.inputmoney; // InputClass로부터 환전할 요청 금액
		String type; // 환전 종류
		String text; 

		if (inputchagetype == 1) { // 만약 메뉴선택번호가 1일 경우
			type = "USD"; // 환전 타입은 USD
			int array[] = runClass.outusdresult(inputmoney); // inputmoney를 인자로 outusdresult 메소드 호출하여 return받은 배열을 array에 저장

			text = type + "," + sdt.format(cal.getTime()) + "," + inputmoney + "," + array[0] + "," + array[1] + ","
					+ runClass.reaminUSDbalance + "," + tempusdstr + "\n";
			fw.write(text);

		} else if (inputchagetype == 2) {
			type = "EUR";
			int array[] = runClass.outeurresult(inputmoney);
			text = type + "," + sdt.format(cal.getTime()) + "," + inputmoney + "," + array[0] + "," + array[1] + ","
					+ runClass.remainEURbalance + "," + tempeurstr + "\n";
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

	public int[] writeUSD(int outputUSD100, int outputUSD50, int outputUSD10, int outputUSD5, int outputUSD2, // 지폐 개수를 저장하기 위한 메소드
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

	public int[] writeJPY(int outputJPY10000, int outputJPY5000, int outputJPY1000, int outputJPY500,
			int outputJPY100) {
		int[] array = { outputJPY10000, outputJPY5000, outputJPY1000, outputJPY500, outputJPY100 };
		return array;
	}

	private void printResultUSD(int returnRealUSD, int outputUSD100, int outputUSD50, int outputUSD10, int outputUSD5, // 지폐 개수를 받아와 콘솔에 출력하는 메소드
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

	private void printResultWon(int charge, int returnWon1000, int returnWon500, int returnWon100, int returnWon50, // 거스름돈 원단위를 받아와 출력하는 메소드
			int returnWon10) {
		System.out.println("\n잔돈 = " + charge + " 원 ");
		System.out.println("1000 원 지폐 " + returnWon1000 + " 장 ");
		System.out.println("500 원 동전 " + returnWon500 + " 개 ");
		System.out.println("100 원 동전 " + returnWon100 + " 개 ");
		System.out.println("50 원 동전 " + returnWon50 + " 개 ");
		System.out.println("10 원 동전 " + returnWon10 + " 개 ");
	}

	public void outputResultUSD(int returnRealUSD) { // 환전한 외화와 지폐를 인자로 받아들여 환전외화를 몇장의 지폐로 돌려줄 것인지 계산
		int outputUSD100, outputUSD50, outputUSD10;
		int outputUSD5, outputUSD2, outputUSD1;

		outputUSD100 = (returnRealUSD / ConstValueClass.CHANGE_USD_100);
		outputUSD50 = ((returnRealUSD % ConstValueClass.CHANGE_USD_100)) / 50;
		outputUSD10 = (((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) / 10;
		outputUSD5 = ((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) / 5;
		outputUSD2 = (((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) % 5) / 2;
		outputUSD1 = ((((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) % 5) % 2);

		printResultUSD(returnRealUSD, outputUSD100, outputUSD50, outputUSD10, outputUSD5, outputUSD2, outputUSD1);
		int temp[] = writeUSD(outputUSD100, outputUSD50, outputUSD10, outputUSD5, outputUSD2, outputUSD1); // 지폐개수를 배열에 저장
		for (int i = 0; i < temp.length; i++) { // 지폐개수를 전역변수인 tempusdstr에 ,와 함게 저장 (마지막엔 , 안 붙이기)
			if (i == temp.length - 1) {
				tempusdstr += temp[i] + "";
			} else {
				tempusdstr += temp[i] + ",";
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
		int temp[] = writeEUR(outputEUR500, outputEUR100, outputEUR50, outputEUR20, outputEUR10, outputEUR5, outputEUR2,
				outputEUR1);
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length - 1) {
				tempeurstr += temp[i] + "";
			} else {
				tempeurstr += temp[i] + ",";
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
		int temp[] = writeJPY(outputJPY10000, outputJPY5000, outputJPY1000, outputJPY500, outputJPY100);
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length - 1) {
				tempjpystr += temp[i] + "";
			} else {
				tempjpystr += temp[i] + ",";
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

	public void printErrorMessage(int errorCode) { // 에러메시지 출력 메소드
		switch (errorCode) { // 에러코드가 1~3일 경우
		case ConstValueClass.ERR_BALANCE_USD: // 에러코드가 1일 경우
			System.out.println("보유 달러 : " + ConstValueClass.BALANCE_USD); // 보유 달러를 출력
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
		System.out.println("보유 잔액이 부족합니다."); // (달러,유로,엔화) 보유잔액이 부족합니다 출력
	}

	public void printRemainUSD(double usd) { // 환전 성공시 보유 달러에서 환전요구금액을 뺀 나머지 출력
		System.out.println("남은 달러는 : " + usd);
	}

	public void printRemainEUR(double eur) {
		System.out.println("남은 유로는 : " + eur);
	}

	public void printRemainJPY(double jpy) {
		System.out.println("남은 엔화는 : " + jpy);
	}

}
