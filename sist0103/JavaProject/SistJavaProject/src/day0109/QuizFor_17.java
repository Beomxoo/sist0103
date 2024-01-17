package day0109;

import java.util.Scanner;

public class QuizFor_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		quiz1();
		// quiz2();
		// quiz3();
	}

	public static void quiz1() {
		/*
		 * 팩토리얼 구할 숫자를 입력하여 해당숫자에 대한 팩토리얼 구하기 5 5! = 120
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		int num;
		int result = 1;
		for (int j = 0; j < 3; j++) {
			System.out.println("팩토리얼을 구할 숫자를 입력해주세요.");
			num = sc.nextInt();
			for (int i = 1; i <= num; i++) {
				result *= i;
			}
			System.out.println(num + "!= " + result);
			result = 1;
		}

	}

	public static void quiz2() {
		/*
		 * Q.두수 x,y를 입력후 x의 y승 구하기 두수 입력 3 3 3의 3승은 27입니다.
		 */
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		int result = 1;
		System.out.println("두수를 입력해주세요.(x,y)");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		for (int i = 1; i <= num2; i++) {
			result *= num1;
		}
		System.out.println(num1 + "의 " + num2 + "승은 " + result + "입니다.");
	}

	public static void quiz3() {
		/*
		 * 1~100까지의 숫자중 짝수의 합과 홀수의 합을 나눠서 출력해주세용 1~100 홀수합: ~ 1~100 짝수합: ~
		 */
		int holsum = 0, zaksum = 0;

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				zaksum += i;
			} else {
				holsum += i;
			}
		}
		System.out.println("1~100 홀수합: " + holsum);
		System.out.println("1~100 짝수합: " + zaksum);

	}

}
