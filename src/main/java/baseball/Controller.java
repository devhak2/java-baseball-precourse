package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Console;

public class Controller {
	public void playBaseBall(int num) {
		Baseball baseball = Baseball.getInstance();
		baseball.init(num);
		while (true) {
			Viewer.printPrompt();
			String input = Console.readLine();
			int[] result = baseball.calculate(convertInput(input));
			Viewer.printResult(result);

			if (result[0] == 3) {
				Viewer.printComplete(num);
				return;
			}
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
