package exchangesystem;

import java.io.IOException;

public class Exchange {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int moneyKOR = 0; // 요구금액 초기화
		int inputChangeType = 0; // 메뉴선택 초기화
		InputClass inputClass = new InputClass();
		OutputClass out = new OutputClass();
		do {
			moneyKOR = inputClass.inputFromConsoleWon(); // inputclass의 inputFromConsoleWon()를 호출하여 입력받기
			inputChangeType = inputClass.inputFromConsoleType(); // inputclass의 inputFromConsoleType()을 호출하여 메뉴선택 입력받기
			RunExchangeClass runClass = new RunExchangeClass();
			switch (inputChangeType) {				 // inputchangetype이 1~3일 경우
				case ConstValueClass.CHANGE_TYPE_USD: // 1일 경우
					runClass.changeToUSD(moneyKOR); // input money를 인자로 RunExchangeClass의 changeToUSD 메소드를 호출하여 환전 및 지폐 개수, 거스름돈 반환
					out.saveDATA(inputChangeType); // 해당 정보를 CSV파일로 저장
					break;
				case ConstValueClass.CHANGE_TYPE_EUR:
					runClass.changeToEUR(moneyKOR);
					out.saveDATA(inputChangeType);
					break;
				case ConstValueClass.CHANGE_TYPE_JPY:
					runClass.changeToJPY(moneyKOR);
					out.saveDATA(inputChangeType);
					break;
			}

		} while (inputChangeType != 0); // 만약 inputchangetype이 0일 경우 종료
	}
}
