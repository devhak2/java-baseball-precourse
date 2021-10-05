package baseball;

public class Viewer {
	public static void printPrompt() {
		System.out.print("숫자를 입력해주세요 : ");
	}

	public static void printComplete(int num) {
		System.out.println(String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 끝", num));
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

	public static void printResult(int[] result) {
		if (result[0] > 0) {
			System.out.print(String.format("%d스트라이크 ", result[0]));
		}

		if (result[1] > 0) {
			System.out.print(String.format("%d볼", result[1]));
		}

		if (result[0] == 0 && result[1] == 0) {
			System.out.print("낫싱");
		}
		System.out.println();
	}
}
