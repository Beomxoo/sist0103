package day0108;

import java.util.Scanner;

public class QuizForWhile_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test1();
		// test2();
		// test3();
		test4();

	}

	public static void test1() {
		// 문제 : 1~100까지의 3의 배수 갯수 구하기
		int n = 0;
		int cnt = 0;

		while (true) {
			n++;
			// 3의 배수이면 cnt 변수 1증가
			if (n % 3 == 0) {
				cnt++;
			}
			// n이 100이 되면 while문 종료
			if (n == 100) {
				break;
			}
		}
		System.out.println("3의 배수 갯수: " + cnt + "개");
	}

	public static void test2() {
		// 1~100까지의 짝수의 합을 구하기(while(true))
		int num1 = 0;
		int sum1 = 0;
		while (true) {
			num1++;
			if (num1 % 2 == 0) {
				sum1 += num1;
			}
			if (num1 == 100) {
				break;
			}

		}
		System.out.println("1~100까지의 짝수의 합: " + sum1);
	}

	public static void test3() {
		// 1~100까지의 홀수의 합을 구하기(while(true))

		int sum2 = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1) {
				sum2 += i;
			}
		}
		System.out.println("1~100까지의 홀수의 합: " + sum2);

	}

	public static void test4() {
		/*
		 * (1~100까지만 입력가능) 총 5개의 점수를 입력받아 합계를 구하는것 1번 점수: 90 2번 점수: -70 잘못입력했어요 2번점수 :
		 * 85 3번 점수:120 잘못입력했어요 3번 점수: 88 4번 점수 : 98 5번 점수: 75 총점 : ***점
		 */
		Scanner sc = new Scanner(System.in);
		int tot = 0, score;

		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번 점수: ");
			score = sc.nextInt();
			if (score > 100 || score < 1) {
				System.out.println("잘못입력하셨습니다");
				i--;
				continue;
			}
			tot += score;
		}
		System.out.println("총점: " + tot);

	}

}
