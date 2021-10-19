package PlugMain.SysSPT;

import java.util.Random;;

/**
 * @author ToufuSekka
 * @since 2021-10-19
 */
public class Dice {
	private Random ran;
	private boolean Win;
	
	public Dice(float Percent) {
		if ((Percent < 0) || (Percent > 100))
			throw new IllegalArgumentException("0보다 크고 100보다 작은수를 기입하세요.");
		ran = new Random();
		float Value = ran.nextFloat() * 100f;
		if (Value < Percent)
			Win = true;
		else
			Win = false;
	}
	
	public Dice(int DiceNumber, int[] WinNumber) {
		if (WinNumber.length < 1)
			throw new NullPointerException("1개 이상의 출현주사위를 설정해야 합니다.");
		ran = new Random();
		int Value = ran.nextInt(DiceNumber);
		for (int i : WinNumber) {
			if (Value == i) {
				Win = true;
				break;
			} else
				Win = false;
		}
	}
	
	public Dice(int BaseDice, int MinWin, int MaxWin) {
		if (BaseDice < 0 || MinWin < 0)
			throw new IllegalArgumentException("0보다 큰수를 기입하시오.");
		if (BaseDice < MaxWin)
			throw new IllegalArgumentException("주사위 눈수는 최대 숫자보다 작아야 합니다.");

		ran = new Random();
		int Value = ran.nextInt(BaseDice);

		if ((Value > MinWin) && (Value < MaxWin))
			Win = true;
		else
			Win = false;
	}
	
	public boolean GetWin() {
		return Win;
	};
}
