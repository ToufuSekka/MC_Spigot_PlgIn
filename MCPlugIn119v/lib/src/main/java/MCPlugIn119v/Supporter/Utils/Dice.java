package MCPlugIn119v.Supporter.Utils;

import java.util.*;

/**
 * @since 2022-02-27
 * @author TouhuSekka
 */
public class Dice {
	private Random Ran;
	private boolean WIN;

	/**
	 * @param percent 0 ~ 100
	 * @exception IllegalArgumentException When less 0
	 */
	public Dice(float percent) {
		if ((percent < 0) || (percent > 100))
			throw new IllegalArgumentException("Enter bigger then 0");

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
	 * 
	 * @param BaseDice
	 * @param MinWin
	 * @param MaxWin
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
