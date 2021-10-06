package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Randoms;

public class Baseball {
	private Baseball() {
		this.numbers = new ArrayList<>();
	}

	public static Baseball getInstance() {
		return LazyHolder.INSTANCE;
	}

	public void init(int num) {
		if (numbers.size() != 0) {
			numbers.clear();
		}
		numbers.addAll(pickUniqueNumbersInRange(num, 1, 9));
	}

	public int[] calculate(List<Integer> userInput) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.size(); i++) {
			accumulateResult(result, i, userInput.indexOf(numbers.get(i)));
		}
		return result;
	}

	private List<Integer> pickUniqueNumbersInRange(int num, final int startInclusive, final int endInclusive) {
		Set<Integer> numbers = new LinkedHashSet<>();
		while (numbers.size() < num) {
			numbers.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
		}
		return new ArrayList<>(numbers);
	}

	private void accumulateResult(int[] result, int loopCount, int index) {
		if (loopCount == index) {
			result[0]++;
			return;
		}

		if (index >= 0) {
			result[1]++;
		}
	}

	private List<Integer> numbers;

	private static class LazyHolder {
		private static final Baseball INSTANCE = new Baseball();
	}
}
