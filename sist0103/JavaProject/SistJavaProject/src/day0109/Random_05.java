package day0109;

import java.util.Random;

public class Random_05 {

	public static void main(String[] args) {
		// 2. Random 이라는 클래스 이용
		Random r = new Random();

		System.out.println("0~9사이의 난수 5개발생");
		for (int i = 1; i <= 5; i++) {
			int a = r.nextInt(10);
			System.out.print(a + " ");
		}
		System.out.println("\n------------------------");
		System.out.println("0~99 사이의 랜덤수 5개 발생");

		for (int i = 1; i <= 5; i++) {
			int a = r.nextInt(100);  //nextInt(num) 함수는 0부터~num-1까지 난수     
			System.out.print(a + " ");
		}

		System.out.println("\n------------------------");
		System.out.println("1~10사이의 난수 5개발생");
		for (int i = 1; i <= 5; i++) {
			int a = r.nextInt(10) + 1; 
			System.out.print(a + " ");
		}
		System.out.println("\n------------------------");
		System.out.println("65~90사이의 난수 5개발생");
		for (int i = 1; i <= 5; i++) {
			int a = r.nextInt(26) + 65; 
			System.out.print((char)a + " ");
		}
	}

}
