package exchangesystem;

import java.util.Scanner;

public class InputClass {
	public Scanner sc = null;
	public static int inputmoney; // file write���� ����� inputmoney

	public InputClass() {
		sc = new Scanner(System.in);
	}

	public int inputFromConsoleWon() { // �䱸�ݾ� �Է¹޴� �޼ҵ�
		int moneyKOR;
		System.out.println("��ȭ �Է� : ");
		moneyKOR = sc.nextInt();
		inputmoney = moneyKOR; // file wirte���� ����ϱ� ���Ͽ� ���������� �� ����
		return moneyKOR;
	}

	public int inputFromConsoleType() { // �޴����� �Է¹޴� �޼ҵ�
		int inputChangeType;
		System.out.println("Which money do you want?\n" + "1.USD\n\n" + "2.EUR\n\n" + "3.JPY\n\n" + "0.Exit");
		inputChangeType = sc.nextInt();
		
		return inputChangeType;
	}
}
