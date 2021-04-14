package exchangesystem;

import java.io.IOException;

public class Exchange {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int moneyKOR = 0; // �䱸�ݾ� �ʱ�ȭ
		int inputChangeType = 0; // �޴����� �ʱ�ȭ
		InputClass inputClass = new InputClass();
		OutputClass out = new OutputClass();
		do {
			moneyKOR = inputClass.inputFromConsoleWon(); // inputclass�� inputFromConsoleWon()�� ȣ���Ͽ� �Է¹ޱ�
			inputChangeType = inputClass.inputFromConsoleType(); // inputclass�� inputFromConsoleType()�� ȣ���Ͽ� �޴����� �Է¹ޱ�
			RunExchangeClass runClass = new RunExchangeClass();
			switch (inputChangeType) {				 // inputchangetype�� 1~3�� ���
				case ConstValueClass.CHANGE_TYPE_USD: // 1�� ���
					runClass.changeToUSD(moneyKOR); // input money�� ���ڷ� RunExchangeClass�� changeToUSD �޼ҵ带 ȣ���Ͽ� ȯ�� �� ���� ����, �Ž����� ��ȯ
					out.saveDATA(inputChangeType); // �ش� ������ CSV���Ϸ� ����
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

		} while (inputChangeType != 0); // ���� inputchangetype�� 0�� ��� ����
	}
}
