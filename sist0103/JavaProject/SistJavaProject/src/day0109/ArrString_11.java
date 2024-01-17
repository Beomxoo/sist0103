package day0109;

public class ArrString_11 {

	public static void main(String[] args) {
		// 문자열 배열
		String[] str1 = { "텀블러", "키보드", "핸드크림", "칫솔", "우산" };
		String[] strColors = { "red", "pink", "blue", "yello", "gray", "white" };

		// str1은 1번째: 텀블러
		System.out.println("str1 출력1_for");
		for (int i = 0; i < str1.length; i++) {
			System.out.println((i + 1) + "번째: " + str1[i]);
		}
		System.out.println("\nstr1 출력1_foreach");
		for (String s : str1) {
			System.out.print(s + " ");
		}
		// strColors 0번지색 : red
		System.out.println("\nstrColors 출력2_for");
		for (int i = 0; i < strColors.length; i++) {
			System.out.println((i + 1) + "번째: " + strColors[i]);
		}
		System.out.println("\nstrColors 출력2_foreach");
		for (String s : strColors) {
			System.out.print(s + " ");
		}
	}

}
