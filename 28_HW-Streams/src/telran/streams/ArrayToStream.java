package telran.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayToStream {
	/*
	 * Displaying a given array in the shuffled order
	 */
	static void displayArrayShuffled(int[] ar) {
		/*
		 * Random().nextInt(2) - (0,2] = {0,1}
		 */
		new Random().ints(0, ar.length).distinct().limit(ar.length).forEach(i -> System.out.print(ar[i]));
	}

	/*
	 * displaying counts of the digits occurrence in the 1000000 random numbers in
	 * the full range of the positive numbers (with no Integer.MAX_VALUE) <digit> :
	 * <count>
	 */
	static void displayDigitsStatistics() {
		int maxNumbers = 1000000;
		new Random().ints(maxNumbers, 0, Integer.MAX_VALUE)
					.mapToObj(Integer::toString)
					.flatMapToInt(s -> s.chars())
					.boxed()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
					.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
					.forEach(entry -> System.out.printf("%c : %d\n",entry.getKey(), entry.getValue()));

	}
}
