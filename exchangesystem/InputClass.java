package exchangesystem;

import java.util.Scanner;

public class InputClass {
	public Scanner sc = null;
	public static int inputmoney;
	public int inputtype;

	public InputClass() {
		sc = new Scanner(System.in);
	}

	public int inputFromConsoleWon() {
		int moneyKOR;
		System.out.println("원화 입력 : ");
		moneyKOR = sc.nextInt();
		inputmoney = moneyKOR;
		return moneyKOR;
	}

	public int inputFromConsoleType() {
		int inputChangeType;
		System.out.println("Which money do you want?\n" + "1.USD\n\n" + "2.EUR\n\n" + "3.JPY\n\n" + "0.Exit");
		inputChangeType = sc.nextInt();
		inputtype = inputChangeType;
		return inputChangeType;
	}
}
