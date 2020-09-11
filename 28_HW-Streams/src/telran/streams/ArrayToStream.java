package telran.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayToStream {
	/*
	 * Displaying a given array in the shuffled order
	 */
	static void displayArrayShuffled(int[] ar) {
		/*
		 * Random().nextInt(2) - (0,2] = {0,1}
		 */
		Arrays.stream(ar).boxed().sorted((f1, f2) -> (new Random().nextInt(2)) == 0 ? -1 : 1)
				.forEach(System.out::print);
	}

	/*
	 * displaying counts of the digits occurrence in the 1000000 random numbers in
	 * the full range of the positive numbers (with no Integer.MAX_VALUE) <digit> :
	 * <count>
	 */
	static void displayDigitsStatistics() {
		int maxDigits = 1000000;
		Random rand = new Random();
		// int[] randomNumbers = rand.ints(maxDigits, 0, Integer.MAX_VALUE - 1).toArray();
		int[] randomNumbers = rand.ints(maxDigits, 0, 1000).toArray();
		Map<Integer, Long> map = Arrays.stream(randomNumbers).boxed()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		map.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));
	}
}
