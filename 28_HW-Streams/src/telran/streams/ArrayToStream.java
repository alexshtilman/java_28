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
		int[] randomNumbers = rand.ints(maxDigits, 0, Integer.MAX_VALUE - 1).toArray();
		Map<Integer, Long> result = Arrays.stream(randomNumbers).mapToObj(Integer::toString)
				.flatMapToInt(s -> s.chars()).mapToObj(x -> x - '0')
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		result.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
				.forEach(entry -> System.out.println(entry.getKey() + ":" + entry.getValue()));

	}
}
