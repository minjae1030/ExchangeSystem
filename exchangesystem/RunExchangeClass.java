package exchangesystem;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RunExchangeClass {
	public OutputClass outClass = null;
	public static double reaminUSDbalance; // 파일에 쓰기위한 전역변수 (환전 후 보유 달러)
	public static double remainEURbalance;
	public static double remainJPYbalance;

	public RunExchangeClass() throws IOException {
		outClass = new OutputClass();
	}

	public int[] outusdresult(int moneyKOR) { // 환전 성공 시 환전된 외화와 , 거스름돈을 배열에 저장 ( wirte하기 위하여 사용 )
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

	public void changeToUSD(int moneyKOR) throws IOException { // 실제 입력받은 금액으로부터 환전하는 메소드
		double returnUSD;
		int returnRealUSD;
		int charge;
		returnUSD = moneyKOR / ConstValueClass.EX_USD; // 환율에 맞춰 금액에 맞는 usd 달러
		returnRealUSD = (int) returnUSD; // 소수점 자리수 버리기

		if (checkBalanceUSD(returnRealUSD)) { // 보유달러와 환전요구달러를 비교하여 True일경우 진행

			outClass.outputResultUSD(returnRealUSD); // 지폐 개수를 계산하고 출력
			charge = (int) (moneyKOR - returnRealUSD * ConstValueClass.EX_USD); // 거스름돈 계산
			charge = (charge / 10) * 10; // 10위 단위까지만 출력 -> 1원자리 버리기

			outClass.outputResultWon(charge); // 계산된 거스름돈을 won 지폐 또는 동전 개수로 출력
			ConstValueClass.BALANCE_USD -= returnRealUSD; // 남은 보유 외화에서 환전된 외화 빼기
			outClass.printRemainUSD(ConstValueClass.BALANCE_USD); // 남은 보유 외화 출력
			reaminUSDbalance = ConstValueClass.BALANCE_USD; // 출력에서 남은 보유 외화 출력하기 위해 클래스 전역변수에 저장

		} else {
			outClass.printErrorMessage(ConstValueClass.ERR_BALANCE_USD); // 요구하는 외화가 보유달러보다 클 시 에러메시지 출력
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

	private boolean checkBalanceUSD(int requestUSD) { // 요구금액과 보유금액을 비교하여 true , false를 반환하는 boolean 메소드
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
