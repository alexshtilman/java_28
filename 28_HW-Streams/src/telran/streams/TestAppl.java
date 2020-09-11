package telran.streams;

import static telran.streams.ArrayToStream.*;

public class TestAppl {

	public static void main(String[] args) {

		int[][] arr = { { 1, 1 }, { 7, 6, 5, 4, 3, 2, 1 }, { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
				{ 3, 1, 7, 3, 9, 2, 0, 0, 5, 5, 3, 1 }, { 1, 1, 1, 2, 2, 2 }, { 1, 1, 0, 1, 1, 1 }, {} };
		for (int[] a : arr) {
			displayArrayShuffled(a);
			System.out.println();
		}
		displayDigitsStatistics();
	}

}
