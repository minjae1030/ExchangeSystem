package exchangesystem;

import java.util.Scanner;

public class InputClass {
	public Scanner sc = null;
	public static int inputmoney; // file write에서 사용할 inputmoney

	public InputClass() {
		sc = new Scanner(System.in);
	}

	public int inputFromConsoleWon() { // 요구금액 입력받는 메소드
		int moneyKOR;
		System.out.println("원화 입력 : ");
		moneyKOR = sc.nextInt();
		inputmoney = moneyKOR; // file wirte에서 사용하기 위하여 전역변수에 값 저장
		return moneyKOR;
	}

	public int inputFromConsoleType() { // 메뉴선택 입력받는 메소드
		int inputChangeType;
		System.out.println("Which money do you want?\n" + "1.USD\n\n" + "2.EUR\n\n" + "3.JPY\n\n" + "0.Exit");
		inputChangeType = sc.nextInt();
		
		return inputChangeType;
	}
}
