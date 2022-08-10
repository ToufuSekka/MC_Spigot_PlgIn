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

		for (int z = 0; z < 8; z++) {
			System.out.print("Start("+z+") : ");
			for (int x = 0; x < 16; x++) {
				RNA[x] = r.nextInt(4);
				System.out.print(RNA[x] + ", ");
			}
			DNA.add(RNA);
			System.out.println();
		}
	}
	
	private void Parent() {
		DNA = new ArrayList<int[]>();
	};
}
