package exchangesystem;

import java.io.IOException;

public class Exchange {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int moneyKOR = 0;
		int inputChangeType = 0;
		InputClass inputClass = new InputClass();
		OutputClass out = new OutputClass();
		do {
			moneyKOR = inputClass.inputFromConsoleWon();
			inputChangeType = inputClass.inputFromConsoleType();
			RunExchangeClass runClass = new RunExchangeClass();
			switch (inputChangeType) {
				case ConstValueClass.CHANGE_TYPE_USD:
					runClass.changeToUSD(moneyKOR);
					out.saveDATA(inputChangeType);
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

		} while (inputChangeType != 0);
	}
}
