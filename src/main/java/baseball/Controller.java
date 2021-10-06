package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nextstep.utils.Console;

public class Controller {
	private int num;

	public Controller(int num) {
		this.num = num;
	}

	public void playBaseBall() {
		Baseball baseball = Baseball.getInstance();
		baseball.init(num);
		while (true) {
			String input = getBaseballInput();
			int[] result = baseball.calculate(convertInput(input));
			Viewer.printResult(result);

			if (result[0] == 3) {
				Viewer.printComplete(num);
				return;
			}
		}
	}

	private String getBaseballInput() {
		String input = null;
		do {
			Viewer.printPrompt();
			input = Console.readLine();
		} while (!validate(input));
		return input;
	}

	private boolean validate(String input) {
		try {
			validateInternal(input);
			return true;
		} catch (IllegalArgumentException e) {
			Viewer.printError(e.getMessage());
			return false;
		}
	}

	private void validateInternal(String input) {
		if (input.length() != num) {
			throw new IllegalArgumentException(String.format("%d 갯수만큼 입력해야 합니다.", num));
		}

		for (int i = 0; i < input.length(); i++) {
			checkNumber(input.charAt(i));
		}

		Set<String> stringSet = new HashSet<>(Arrays.asList(input.split("")));

		if (stringSet.size() != input.length()) {
			throw new IllegalArgumentException("중복된 수가 존재합니다.");
		}
	}

	private void checkNumber(char character) {
		if (!(character > 48 && character <= 57)) {
			throw new NumberFormatException("1에서 9사이 정수를 입력해야 합니다.");
		}
	}

	private List<Integer> convertInput(String input) {
		List<Integer> result = new ArrayList<>(input.length());
		for (int i = 0; i < input.length(); i++) {
			int numericValue = Character.getNumericValue(input.charAt(i));
			result.add(numericValue);
		}
		return result;
	}
}
