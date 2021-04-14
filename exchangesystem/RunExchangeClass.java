package exchangesystem;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RunExchangeClass {
	public OutputClass outClass = null;
	public static double reaminUSDbalance; // ���Ͽ� �������� �������� (ȯ�� �� ���� �޷�)
	public static double remainEURbalance;
	public static double remainJPYbalance;

	public RunExchangeClass() throws IOException {
		outClass = new OutputClass();
	}

	public int[] outusdresult(int moneyKOR) { // ȯ�� ���� �� ȯ���� ��ȭ�� , �Ž������� �迭�� ���� ( wirte�ϱ� ���Ͽ� ��� )
		double returnUSD;
		int returnRealUSD;
		int charge;
		int[] result = new int[2];

		returnUSD = moneyKOR / ConstValueClass.EX_USD;
		returnRealUSD = (int) returnUSD;

		charge = (int) (moneyKOR - returnRealUSD * ConstValueClass.EX_USD);
		charge = (charge / 10) * 10;
		result[0] = returnRealUSD;
		result[1] = charge;

		return result;
	}

	public int[] outeurresult(int moneyKOR) {
		double returnEUR;
		int returnRealEUR;
		int charge;
		int[] result = new int[2];
		returnEUR = moneyKOR / ConstValueClass.EX_EUR;
		returnRealEUR = (int) returnEUR;
		charge = (int) (moneyKOR - returnRealEUR * ConstValueClass.EX_EUR);
		charge = (charge / 10) * 10;
		result[0] = returnRealEUR;
		result[1] = charge;

		return result;

	}

	public int[] outjpyresult(int moneyKOR) {
		double returnJPY, wonjp, restWON;
		int returnRealJPY;
		int charge;
		int[] result = new int[2];
		returnJPY = moneyKOR / ConstValueClass.EX_JPY;
		returnRealJPY = (int) returnJPY;
		wonjp = returnJPY - (returnJPY % 100);
		restWON = (returnJPY - wonjp) * ConstValueClass.EX_JPY;
		charge = (int) (restWON - (restWON % 10));
		result[0] = returnRealJPY;
		result[1] = charge;
		return result;
	}

	public void changeToUSD(int moneyKOR) throws IOException { // ���� �Է¹��� �ݾ����κ��� ȯ���ϴ� �޼ҵ�
		double returnUSD;
		int returnRealUSD;
		int charge;
		returnUSD = moneyKOR / ConstValueClass.EX_USD; // ȯ���� ���� �ݾ׿� �´� usd �޷�
		returnRealUSD = (int) returnUSD; // �Ҽ��� �ڸ��� ������

		if (checkBalanceUSD(returnRealUSD)) { // �����޷��� ȯ���䱸�޷��� ���Ͽ� True�ϰ�� ����

			outClass.outputResultUSD(returnRealUSD); // ���� ������ ����ϰ� ���
			charge = (int) (moneyKOR - returnRealUSD * ConstValueClass.EX_USD); // �Ž����� ���
			charge = (charge / 10) * 10; // 10�� ���������� ��� -> 1���ڸ� ������

			outClass.outputResultWon(charge); // ���� �Ž������� won ���� �Ǵ� ���� ������ ���
			ConstValueClass.BALANCE_USD -= returnRealUSD; // ���� ���� ��ȭ���� ȯ���� ��ȭ ����
			outClass.printRemainUSD(ConstValueClass.BALANCE_USD); // ���� ���� ��ȭ ���
			reaminUSDbalance = ConstValueClass.BALANCE_USD; // ��¿��� ���� ���� ��ȭ ����ϱ� ���� Ŭ���� ���������� ����

		} else {
			outClass.printErrorMessage(ConstValueClass.ERR_BALANCE_USD); // �䱸�ϴ� ��ȭ�� �����޷����� Ŭ �� �����޽��� ���
		}

		
	}

	public void changeToEUR(int moneyKOR) throws IOException {
		double returnEUR;
		int returnRealEUR;
		int charge;
		returnEUR = moneyKOR / ConstValueClass.EX_EUR;
		returnRealEUR = (int) returnEUR;

		if (checkBalanceEUR(returnRealEUR)) {

			outClass.outputResultEUR(returnRealEUR);

			charge = (int) (moneyKOR - returnRealEUR * ConstValueClass.EX_EUR);
			charge = (charge / 10) * 10;

			outClass.outputResultWon(charge);
			ConstValueClass.BALANCE_EUR -= returnRealEUR;
			outClass.printRemainEUR(ConstValueClass.BALANCE_EUR);
			remainEURbalance = ConstValueClass.BALANCE_EUR;
		} else {
			outClass.printErrorMessage(ConstValueClass.ERR_BALANCE_EUR);
		}

	}

	public void changeToJPY(int moneyKOR) throws IOException {
		double returnJPY, wonjp, restWON;
		int returnRealJPY;
		int charge;
		returnJPY = moneyKOR / ConstValueClass.EX_JPY;
		returnRealJPY = (int) returnJPY;

		if (checkBalanceJPY(returnRealJPY)) {

			outClass.outputResultJPY(returnRealJPY);

			wonjp = returnJPY - (returnJPY % 100);
			restWON = (returnJPY - wonjp) * ConstValueClass.EX_JPY;
			charge = (int) (restWON - (restWON % 10));

			outClass.outputResultWon(charge);
			ConstValueClass.BALANCE_JPY -= returnRealJPY;
			outClass.printRemainJPY(ConstValueClass.BALANCE_JPY);
			remainJPYbalance = ConstValueClass.BALANCE_JPY;

		} else {
			outClass.printErrorMessage(ConstValueClass.ERR_BALANCE_JPY);
		}

	}

	private boolean checkBalanceUSD(int requestUSD) { // �䱸�ݾװ� �����ݾ��� ���Ͽ� true , false�� ��ȯ�ϴ� boolean �޼ҵ�
		if (requestUSD <= ConstValueClass.BALANCE_USD) {
			return true;

		} else {
			return false;
		}
	}

	private boolean checkBalanceEUR(int requestEUR) {
		if (requestEUR <= ConstValueClass.BALANCE_EUR) {
			return true;

		} else {
			return false;
		}
	}

	private boolean checkBalanceJPY(int requestJPY) {
		if (requestJPY <= ConstValueClass.BALANCE_JPY) {
			return true;

		} else {
			return false;
		}
	}

}
