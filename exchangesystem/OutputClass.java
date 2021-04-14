package exchangesystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class OutputClass {
	public static String tempusdstr = ""; // usd ���� ������ �����ϱ� ���� string
	public static String tempeurstr = "";
	public static String tempjpystr = "";

	public void saveDATA(int inputchagetype) throws IOException {
		InputClass inputClass = new InputClass();
		RunExchangeClass runClass = new RunExchangeClass();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		FileWriter fw = new FileWriter("C:\\Users\\kmj\\Desktop\\ExchangeSystemOutput.csv", true); // ���� �ٿ�����

		int inputmoney = inputClass.inputmoney; // InputClass�κ��� ȯ���� ��û �ݾ�
		String type; // ȯ�� ����
		String text; 

		if (inputchagetype == 1) { // ���� �޴����ù�ȣ�� 1�� ���
			type = "USD"; // ȯ�� Ÿ���� USD
			int array[] = runClass.outusdresult(inputmoney); // inputmoney�� ���ڷ� outusdresult �޼ҵ� ȣ���Ͽ� return���� �迭�� array�� ����

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

	public int[] writeUSD(int outputUSD100, int outputUSD50, int outputUSD10, int outputUSD5, int outputUSD2, // ���� ������ �����ϱ� ���� �޼ҵ�
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

	private void printResultUSD(int returnRealUSD, int outputUSD100, int outputUSD50, int outputUSD10, int outputUSD5, // ���� ������ �޾ƿ� �ֿܼ� ����ϴ� �޼ҵ�
			int outputUSD2, int outputUSD1) {
		System.out.println(returnRealUSD + " doller");
		System.out.println("100 �޷� ���� " + outputUSD100 + " �� ");
		System.out.println("50 �޷� ����" + outputUSD50 + " �� ");
		System.out.println("10 �޷� ���� " + outputUSD10 + " �� ");
		System.out.println("5 �޷� ���� " + outputUSD5 + " �� ");
		System.out.println("2 �޷� ���� " + outputUSD2 + " �� ");
		System.out.println("1 �޷� ���� " + outputUSD1 + " �� ");

	}

	private void printResultEUR(int returnRealEUR, int outputEUR500, int outputEUR100, int outputEUR50, int outputEUR20,
			int outputEUR10, int outputEUR5, int outputEUR2, int outputEUR1) {
		System.out.println(returnRealEUR + " EUR");
		System.out.println("500 ���� ����" + outputEUR500 + " ��");
		System.out.println("100 ���� ����" + outputEUR100 + " ��");
		System.out.println("50 ���� ����" + outputEUR50 + " ��");
		System.out.println("10 ���� ����" + outputEUR10 + " ��");
		System.out.println("5 ���� ����" + outputEUR5 + " ��");
		System.out.println("2 ���� ����" + outputEUR2 + " ��");
		System.out.println("1 ���� ����" + outputEUR1 + " ��");

	}

	private void printResultJPY(int returnRealJPY, int outputJPY10000, int outputJPY5000, int outputJPY1000,
			int outputJPY500, int outputJPY100) {
		System.out.println(returnRealJPY + " JPY");
		System.out.println("10000�� ����" + outputJPY10000 + " ��");
		System.out.println("5000�� ����" + outputJPY5000 + " ��");
		System.out.println("1000�� ����" + outputJPY1000 + " ��");
		System.out.println("500�� ����" + outputJPY500 + " ��");
		System.out.println("100�� ����" + outputJPY100 + " ��");
	}

	private void printResultWon(int charge, int returnWon1000, int returnWon500, int returnWon100, int returnWon50, // �Ž����� �������� �޾ƿ� ����ϴ� �޼ҵ�
			int returnWon10) {
		System.out.println("\n�ܵ� = " + charge + " �� ");
		System.out.println("1000 �� ���� " + returnWon1000 + " �� ");
		System.out.println("500 �� ���� " + returnWon500 + " �� ");
		System.out.println("100 �� ���� " + returnWon100 + " �� ");
		System.out.println("50 �� ���� " + returnWon50 + " �� ");
		System.out.println("10 �� ���� " + returnWon10 + " �� ");
	}

	public void outputResultUSD(int returnRealUSD) { // ȯ���� ��ȭ�� ���� ���ڷ� �޾Ƶ鿩 ȯ����ȭ�� ������ ����� ������ ������ ���
		int outputUSD100, outputUSD50, outputUSD10;
		int outputUSD5, outputUSD2, outputUSD1;

		outputUSD100 = (returnRealUSD / ConstValueClass.CHANGE_USD_100);
		outputUSD50 = ((returnRealUSD % ConstValueClass.CHANGE_USD_100)) / 50;
		outputUSD10 = (((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) / 10;
		outputUSD5 = ((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) / 5;
		outputUSD2 = (((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) % 5) / 2;
		outputUSD1 = ((((((returnRealUSD % ConstValueClass.CHANGE_USD_100)) % 50) % 10) % 5) % 2);

		printResultUSD(returnRealUSD, outputUSD100, outputUSD50, outputUSD10, outputUSD5, outputUSD2, outputUSD1);
		int temp[] = writeUSD(outputUSD100, outputUSD50, outputUSD10, outputUSD5, outputUSD2, outputUSD1); // ���󰳼��� �迭�� ����
		for (int i = 0; i < temp.length; i++) { // ���󰳼��� ���������� tempusdstr�� ,�� �԰� ���� (�������� , �� ���̱�)
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

	public void printErrorMessage(int errorCode) { // �����޽��� ��� �޼ҵ�
		switch (errorCode) { // �����ڵ尡 1~3�� ���
		case ConstValueClass.ERR_BALANCE_USD: // �����ڵ尡 1�� ���
			System.out.println("���� �޷� : " + ConstValueClass.BALANCE_USD); // ���� �޷��� ���
			System.out.print("�޷� ");
			break;
		case ConstValueClass.ERR_BALANCE_EUR:
			System.out.println("���� ���� : " + ConstValueClass.BALANCE_EUR);
			System.out.print("���� ");
			break;
		case ConstValueClass.ERR_BALANCE_JPY:
			System.out.println("���� ��ȭ : " + ConstValueClass.BALANCE_JPY);
			System.out.print("��ȭ ");
			break;
		}
		System.out.println("���� �ܾ��� �����մϴ�."); // (�޷�,����,��ȭ) �����ܾ��� �����մϴ� ���
	}

	public void printRemainUSD(double usd) { // ȯ�� ������ ���� �޷����� ȯ���䱸�ݾ��� �� ������ ���
		System.out.println("���� �޷��� : " + usd);
	}

	public void printRemainEUR(double eur) {
		System.out.println("���� ���δ� : " + eur);
	}

	public void printRemainJPY(double jpy) {
		System.out.println("���� ��ȭ�� : " + jpy);
	}

}
