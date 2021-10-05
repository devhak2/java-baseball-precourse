package baseball;

import nextstep.utils.Console;

public class Application {
	public static void main(String[] args) {
		Controller controller = new Controller();
		while (true) {
			controller.playBaseBall(3);
			checkExit(Console.readLine());
		}
	}

	private static void checkExit(String input) {
		if (input.equals("2")) {
			System.exit(0);
		}
	}
}
