package day0109;

public class ForStar_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("**다중 for문으로 star(*) 출력하기**");
		for (int i = 1; i <= 5; i++) { // 행갯수
			for (int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------------------");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println("--------------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("--------------------------");
		for (int i = 1; i <= 5; i++) {
			for (int j = i; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
