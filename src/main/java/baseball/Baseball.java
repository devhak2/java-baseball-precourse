package baseball;

import java.util.ArrayList;
import java.util.List;

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
		numbers.addAll(Randoms.pickUniqueNumbersInRange(num, 1, 9));
	}

	public int[] calculate(List<Integer> userInput) {
		int[] result = new int[2];
		for (int i = 0; i < numbers.size(); i++) {
			accumulateResult(result, i, userInput.indexOf(numbers.get(i)));
		}
		return result;
	}

	private void accumulateResult(int[] result, int loopCount, int index) {
		if (loopCount == index) {
			result[0]++;
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
