package day0108;

public class For_07 {

	public static void main(String[] args) {
		// while문과 for문 비교
		System.out.println("***while문으로 10~0출력***");
		int i = 10;

		while (i >= 0) {
			System.out.print(i-- + "  ");
		}

		System.out.println();
		System.out.println("***for문으로 10~0출력***");
		for (int a = 10; a >= 0; a--) {
			System.out.print(a + "  ");
		}

		System.out.println();
		System.out.println("***for문으로 1~10 출력 + 종료***");
		for (int a = 1; a <= 10; a++)
			System.out.print(a + "  ");
		System.out.println("종료");

		System.out.println("***while문으로 1~10 출력 + 종료***");

		int n = 1;

		while (true) {
			System.out.print(n++ + "  ");
			if (n > 10) {
				break;
			}
		}
		System.out.println("종료");

		System.out.println("***for문 1,4,7,10***");
		for (int b = 1; b <= 10; b += 3) {
			System.out.print(b + "  ");
		}
		System.out.println();

		System.out.println("***for문 5 4 3 2 1***");
		for (int b = 5; b > 0; b--) {
			System.out.print(b + "  ");
		}
		System.out.println("종료");

		System.out.println("***while문 5 4 3 2 1***");
		int c = 5;
		while (true) {
			System.out.print(c-- + "  ");
			if (c < 1) {
				break;
			}
		}
		System.out.println("종료");

		int z = 5;
		while (z > 0) {
			System.out.print(z-- + "  ");
		}
		System.out.println("종료");

		System.out.println("***for문 HelloJava를 5번 반복출력***");
		int j;
		for (j = 1; j <= 5; j++) {
			System.out.print("HelloJava ");

		}
	}

}
