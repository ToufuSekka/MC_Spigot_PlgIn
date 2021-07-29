package Main.SysSPT;

import java.util.Random;

public class SysDice {
	private Random r;
	private boolean Win;

	public SysDice(float Percent) {
		if ((Percent < 0) || (Percent > 100))
			throw new IllegalArgumentException("당첨의 확률은 0과 100사이여야 합니다."); //$NON-NLS-1$
		r = new Random();
		float Value = r.nextFloat() * 100f;
		if (Value < Percent)
			Win = true;
		else
			Win = false;
	}

	public SysDice(int Dice, int[] WinNumber) {
		if (WinNumber.length < 1)
			throw new NullPointerException("최소 1개 이상의 숫자를 등록 하십시오"); //$NON-NLS-1$
		r = new Random();
		int Value = r.nextInt(Dice);
		for (int i : WinNumber) {
			if (Value == i) {
				Win = true;
				break;
			} else
				Win = false;
		}
	}

	public SysDice(int BaseDice, int MinWin, int MaxWin) {
		if (BaseDice < 0)
			throw new IllegalArgumentException("기초인자의 수는 0보단 커야합니다."); //$NON-NLS-1$
		if (BaseDice < MaxWin)
			throw new IllegalArgumentException("기초인자보다 큰 주사위를 설정할수 없습니다."); //$NON-NLS-1$
		if (MinWin < 0)
			throw new IllegalArgumentException("최소 당첨주사위 수는 0보단 커야합니다."); //$NON-NLS-1$

		r = new Random();
		int Value = r.nextInt(BaseDice);

		if ((Value > MinWin) && (Value < MaxWin))
			Win = true;
		else
			Win = false;
	}

	// Getter
	public boolean GetWin() {
		return this.Win;
	}
}
