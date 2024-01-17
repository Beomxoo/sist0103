package day0109;

public class MathRandom_04 {

	public static void main(String[] args) {
		// 자바에서 랜덤수(난수)를 구하는 방법
		// 1. Math.randam() Math클래스에서 random 메서드 이용
		// 2. Random 이라는 클래스 이용

		System.out.println("기본 랜덤수 5개 발생");

		for (int i = 1; i <= 5; i++) {
			double a = Math.random(); // 0.0******~0.9******* 사이의 실수 결코 1이 될수없음
			System.out.print(a + " ");
		}
		System.out.println("\n------------------------");
		System.out.println("0~9 사이의 랜덤수 5개 발생");

		for (int i = 1; i <= 5; i++) {
			int a = (int) (Math.random() * 10);
			System.out.print(a + " ");
		}
		System.out.println("\n------------------------");
		System.out.println("0~99 사이의 랜덤수 5개 발생");
		for (int i = 1; i <= 5; i++) {
			int a = (int) (Math.random() * 100);
			System.out.print(a + " ");
		}

		System.out.println("\n------------------------");
		System.out.println("1~10 사이의 랜덤수 5개 발생");

		for (int i = 1; i <= 5; i++) {
			int a = (int) (Math.random() * 10) + 1;
			System.out.print(a + " ");
		}
		
		System.out.println("\n------------------------");
		System.out.println("1~100 사이의 랜덤수 5개 발생");

		for (int i = 1; i <= 5; i++) {
			int a = (int) (Math.random() * 100) + 1;
			System.out.print(a + " ");
		}
		
	}

}
