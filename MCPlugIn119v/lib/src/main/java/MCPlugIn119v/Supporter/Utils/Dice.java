package MCPlugIn119v.Supporter.Utils;

import java.util.*;

/**
 * 랜덤시스탬에 관한 기초공작.
 * 
 * @since 2022-02-27
 * @author TouhuSekka
 */
public class Dice {
	private Random Ran;
	private boolean WIN;

	/**
	 * @param percent 0 ~ 100까지의 확률
	 * @exception IllegalArgumentException 0보다 작은 수를 기입하면 출력됨.
	 */
	public Dice(float percent) {
		if ((percent < 0) || (percent > 100))
			throw new IllegalArgumentException("0보다 큰수를 기입하시오.");

		Ran = new Random();
		float Value = Ran.nextFloat() * 100f;

		if (percent <= Value)
			WIN = true;
		else
			WIN = false;
	}

	/**
	 * 
	 * @param DiceNumber
	 * @param WinNumber
	 */
	public Dice(int DiceNumber, int[] WinNumber) {
		if (DiceNumber < 0)
			throw new IllegalArgumentException("1이상의 주사위눈을 입력하시오.");

		if (WinNumber.length < 1)
			throw new NullPointerException("최소 1개의 당첨번호를 입력하시오.");

		if (WinNumber.length > DiceNumber)
			throw new IndexOutOfBoundsException("당첨인자는 주사위 눈보다 클수 없습니다.");

		this.Ran = new Random();
		int Value = Ran.nextInt(DiceNumber);

		for (int i : WinNumber) {
			if (Value == i) {
				WIN = true;
				break;
			} else
				WIN = false;
		}
	}

	/**
	 * 
	 * @param BaseDice
	 * @param MinWin
	 * @param MaxWin
	 */
	public Dice(int BaseDice, int MinWin, int MaxWin) {
		if (BaseDice < 0)
			throw new IllegalArgumentException("1이상의 주사위 눈을 입력하시오.");

		if ((BaseDice > MinWin) || (BaseDice < MaxWin))
			throw new NullPointerException("0보다 작거나, 최대 당첨인자보다 높을수 없습니다.");

		if (MinWin > MaxWin)
			throw new IndexOutOfBoundsException("최소 당첨인자보다 낮을수 없습니다.");

		Ran = new Random();
		int Value = this.Ran.nextInt(BaseDice);

		if ((Value > MinWin) && (Value < MaxWin))
			WIN = true;
		else
			WIN = false;

	}

	public boolean GetWin() {
		return WIN;
	}
}
