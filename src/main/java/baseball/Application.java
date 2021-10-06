package baseball;

import nextstep.utils.Console;

public class Application {
	public static void main(String[] args) {
		Controller controller = new Controller(3);
		String input = "1";
		while (input.equals("1")) {
			controller.playBaseBall();
			input = Console.readLine();
		}
	}
}
