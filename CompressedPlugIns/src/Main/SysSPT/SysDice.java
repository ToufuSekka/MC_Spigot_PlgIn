package Main.SysSPT;

import java.util.Random;

/**
 * 
 * @author ToufuSekka
 * @since 2021.09.06;
 * 랜덤시스탬을 모아두기 위한 클래스다.
 */
public class SysDice {
	private Random r;
	private boolean Win;
	
	/**
	 * 백분율로 계산하는 확률계산기다.
	 * @param Percent 당첨의 확률
	 */
	public SysDice(float Percent) {
		if ((Percent < 0) || (Percent > 100))
			throw new IllegalArgumentException("0보다 크고 100보다 작은수를 기입하세요.");
		r = new Random();
		float Value = r.nextFloat() * 100f;
		if (Value < Percent)
			Win = true;
		else
			Win = false;
	}

	/**
	 * 총 주사위 눈을 정한후, 그중에서 정답이 되는 눈을 기입하는 방식이다.
	 * @param Dice 총 주사위 눈수. 해당은 0보단 커야한다.
	 * @param WinNumber 당첨 주사위의 숫자. 총 주사위 수보다 커선 안된다.
	 */
	public SysDice(int Dice, int[] WinNumber) {
		if (WinNumber.length < 1)
			throw new NullPointerException("1개 이상의 출현주사위를 설정해야 합니다.");
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

	/**
	 * 최대 주사위 눈수를 기준으로 최소승리와 최대 승리의 구간을 지정한다.
	 * @param BaseDice 기준이 되는 주사위 눈수. 0보단 커야한다.
	 * @param MinWin 최소 당첨 범위 0보다 크로 최대수나 기준 수사위보단 작아야한다.
	 * @param MaxWin 최대 당첨범위. 주사위 최소 수자위보단 크거나, 기준 주사위 눈보단 작아야한다.
	 */
	public SysDice(int BaseDice, int MinWin, int MaxWin) {
		if (BaseDice < 0)
			throw new IllegalArgumentException("0보다 큰수를 기입하시오."); //$NON-NLS-1$
		if (BaseDice < MaxWin)
			throw new IllegalArgumentException("湲곗큹�씤�옄蹂대떎 �겙 二쇱궗�쐞瑜� �꽕�젙�븷�닔 �뾾�뒿�땲�떎.");
		if (MinWin < 0)
			throw new IllegalArgumentException("理쒖냼 �떦泥⑥＜�궗�쐞 �닔�뒗 0蹂대떒 而ㅼ빞�빀�땲�떎."); //$NON-NLS-1$

		r = new Random();
		int Value = r.nextInt(BaseDice);

		if ((Value > MinWin) && (Value < MaxWin))
			Win = true;
		else
			Win = false;
	}

	/**
	 * 당첨의 여부를 변환한다.
	 * @return true-> 당첨, false->탈락.
	 */
	public boolean GetWin() {
		return this.Win;
	}
}
