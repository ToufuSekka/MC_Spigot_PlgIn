package org.spigotmc.spigot.SysSpt;

import java.util.*;

/**
 * @since 2021-12-15
 * @author ToufuSekka
 *
 */
public class Dice {
	private Random Ran;
	private boolean WIN;
	
	/**
	 * @param percent : insert numbers between 0 to 100
	 */
	public Dice(float percent) {
		if((percent < 0)||(percent > 100))
			throw new IllegalArgumentException(" 0 에서 100사이의 실수의 숫자를 기입해 주십시오.") ; 
		
		Ran = new Random();
		float Value = Ran.nextFloat() * 100f;
		
		if(percent <= Value)
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
		if(DiceNumber < 0)
			throw new IllegalArgumentException("주사위의 숫자는 0보다 커야합니다.");
		
		if(WinNumber.length < 1)
			throw new NullPointerException("1개 이상의 당첨을 기입하십시오.");
		
		if(WinNumber.length > DiceNumber)
			throw new IndexOutOfBoundsException("수사의 인수보다 많은 담첨인자를 만들지 마십시오.");
		
		Ran= new Random();
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
		if(BaseDice < 0)
			throw new IllegalArgumentException("주사위의 숫자는 0보다 커야합니다.");
		
		if((BaseDice > MinWin )||(BaseDice < MaxWin))
			throw new NullPointerException("BaseDice범위 안에서 설정해 주십시오.");
		
		if(MinWin> MaxWin)
			throw new IndexOutOfBoundsException("Min은 Max보다 작아야합니다.");
		
		Ran = new Random();
		int Value = Ran.nextInt(BaseDice);

		if ((Value > MinWin) && (Value < MaxWin))
			WIN = true;
		else
			WIN = false;
	
	}
	
	public boolean GetWin() {
		return WIN;
	}
}
