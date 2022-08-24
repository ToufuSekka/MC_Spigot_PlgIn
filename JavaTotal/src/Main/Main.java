package Main;

import java.util.*;

public class Main {
	static List<int[]> DNA;
	static int[] RNA;
	static Random r;

	public static void main(String[] args) {
		RNA = new int[16];
		DNA = new ArrayList<int[]>();

		r = new Random();

		for (int z = 0; z < 3; z++) {
			System.out.print("Start(" + z + ") : ");
			for (int x = 0; x < 16; x++) {
				RNA[x] = r.nextInt(4);
				System.out.print(RNA[x] + ", ");
			}

			DNA.add(RNA);
			double a = Math.pow(RNA[0], 1) + Math.pow(RNA[1], 2) + Math.pow(RNA[3], 3) + Math.pow(RNA[4], 4),
					b = Math.pow(RNA[4], 1) + Math.pow(RNA[7], 2) + Math.pow(RNA[10], 3) + Math.pow(RNA[13], 4),
					c = Math.pow(RNA[5], 1) + Math.pow(RNA[8], 2) + Math.pow(RNA[11], 3) + Math.pow(RNA[14], 4),
					d = Math.pow(RNA[6], 1) + Math.pow(RNA[9], 2) + Math.pow(RNA[12], 3) + Math.pow(RNA[15], 4);

			double ab = a + b, cd = c + d, PctAB = (ab / 680) * 100, PctCD = (cd / 680) * 100;
			String Data1 = String.format("%.3f", PctAB), Data2 = String.format("%.3f", PctCD);

			double Total1 = PctAB / 4, Total2 = PctCD / 4;
			String Tstr = String.format("%.3f", Total1), Tstr2 = String.format("%.3f", Total2);

			double aP = a / ab, bP = b / ab, cP = c / cd, dP = d / cd;
			String StraP = String.format("%.3f", aP), StrbP = String.format("%.3f", bP),
					StrcP = String.format("%.3f", cP), StrdP = String.format("%.3f", dP);
			
			System.out.println();
			System.out.println("Total : " + a + " : " + b + " : " + c + " : " + d);
			System.out.println("A+B : " + ab + ", " + Data1 + "%, C+D : " + cd + ", " + Data2 + "%");
			System.out.println("(-" + Tstr + " to +" + Tstr + ") and (-" + Tstr2 + " to +" + Tstr2+")");
			System.out.println("Type1 : " + StraP + ", " + StrbP + ", Type2 : " + StrcP + ", " + StrdP);
			System.out.println();
		}
	}
}
