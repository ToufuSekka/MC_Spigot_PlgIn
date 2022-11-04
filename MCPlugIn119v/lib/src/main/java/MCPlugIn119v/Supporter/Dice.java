package MCPlugIn119v.Supporter;

import java.util.*;

/**
 * @since 2022-02-27
 * @author TouhuSekka
 */
public class Dice {
	private Random Ran;
	private boolean WIN;
	
	/** 100분율의 퍼센테이지를 나타냄
	 * @param percent 0 ~ 100
	 * @exception IllegalArgumentException When less 0
	 */
	public Dice(float percent) {
		if ((percent < 0) || (percent > 100))
			throw new IllegalArgumentException("Enter Between 0 to 100");

		Ran = new Random();
		float Value = Ran.nextFloat() * 100f;

		if (Value <= percent)
			WIN = true;
		else
			WIN = false;
	}

	/**
	 *  0에서 어떤 수까지 특정 숫자의 당첨
	 * @param DiceNumber 0부터 시작되는 주사위
	 * @param WinNumber 당첨숫자를 물리적으로 기입.
	 * 
	 */
	public Dice(int DiceNumber, int[] WinNumber) {
		if (DiceNumber < 0)
			throw new IllegalArgumentException("Enter Dice Bigger then 1");

		if (WinNumber.length < 1)
			throw new NullPointerException("Enter At least 1");

		if (WinNumber.length > DiceNumber)
			throw new IndexOutOfBoundsException("Not be bigger then Win");

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
	 * 0에서 주사위 수까지 특정구간의 당첨
	 * @param BaseDice 0부터 시작되는 주사위
	 * @param MinWin 최소 당첨 숫자
	 * @param MaxWin 최대 당첨 숫자
	 */
	public Dice(int BaseDice, int MinWin, int MaxWin) {
		if (BaseDice < 0)
			throw new IllegalArgumentException("Enter Dice Bigger then 1");

		if ((BaseDice > MinWin) || (BaseDice < MaxWin))
			throw new NullPointerException("Do not Write 0 or bigger then Dice Value");

		if (MinWin > MaxWin)
			throw new IndexOutOfBoundsException("Do not Write MaxWin less then MinWin");

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
