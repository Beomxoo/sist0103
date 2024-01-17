package day0108;

import java.util.Scanner;

public class Quiz_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// quiz_1();
		quiz_2();
	}

	public static void quiz_1() {
		// Q. 반복해서 숫자를 입력하여 양수의 갯수와 움수의 갯수를 구하시오.(0입력시 종료)
		/*
		 * 6
		 * -10
		 * 88
		 * 120
		 * -130
		 * 0 
		 * 양수의 갯수: 3개
		 * 음수의 갯수: 2개
		 */
		Scanner sc = new Scanner(System.in);
		int num1;
		int pCount = 0, mCount = 0;
		while (true) {
			System.out.print("(0누르면 종료)숫자를 입력하세요: ");
			num1 = sc.nextInt();

			if (num1 > 0) {
				pCount++;
			} else if (num1 < 0) {
				mCount++;
			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

		}
		System.out.println("양수의 갯수: " + pCount + "개");
		System.out.println("음수의 갯수: " + mCount + "개");

	}

	public static void quiz_2() {
		// 반복해서 점수를 입력하고 (1~100) 0을 입력시 빠져나와 총 갯수와 합계와 평균을 구하시오.
		// 범위에 맞지않는 점수는 횟수에서 제외되어야 한다.
		Scanner sc1 = new Scanner(System.in);
		int num2;
		int sum = 0, count = 0;
		double avg = 0;
		while (true) {
			System.out.print("(0을 누르면 종료됩니다.) 점수를 입력해주세요: ");
			num2 = sc1.nextInt();
			if (num2 == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}

			if (num2 > 100 || num2 < 1) {
				System.out.println("반드시 1~100사이의 숫자만 입력해주세요. 다시 입력 바랍니다.");
				continue;  // continue 만나면 아래문장 sum += num2; count++; 수행하지 않음 카운트안됨
			}

			sum += num2;
			count++;

		}
		avg = sum / (double) count;
		System.out.println("총 갯수: " + count);
		System.out.println("총 합계: " + sum);
		System.out.printf("평균: %.2f", avg);
	}

}
