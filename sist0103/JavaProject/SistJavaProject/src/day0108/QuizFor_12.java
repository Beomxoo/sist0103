package day0108;

import java.util.Scanner;

public class QuizFor_12 {

	public static void main(String[] args) {
		//
		System.out.println("1. 1 2 4 5 7 8 10 (continue활용할것!!)");
		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0) {
				continue;
			}
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("2. 홀수값:1 홀수값:3 홀수값:5 홀수값:7 홀수값:9");
		for (int i = 1; i <= 10; i += 2) {
			System.out.print("홀수값:" + i + " ");
		}
		System.out.println();
		System.out.println("3. 점수를 입력후 합계를 구하는데 0을 입력하면 빠져나오면서 합계출력 ");
		int num;
		int sum = 0;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("점수를 입력하세요:");
			num = sc.nextInt();
			if (num == 0) {
				break;
			}
			if (num<0 || num>100) {
				System.out.println("다시입력해 주세요(1~100)");
				continue;
			}
			sum += num;
		}
		System.out.println("\n입력한 점수의 합계는 " + sum + " 입니다.");

	}

}
