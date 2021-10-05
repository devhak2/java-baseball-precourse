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

	private List<Integer> numbers;

	private static class LazyHolder {
		private static final Baseball INSTANCE = new Baseball();
	}
}
