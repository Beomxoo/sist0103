package day0108;

import java.util.Scanner;

public class ForGugu_14 {

	public static void main(String[] args) {
		// 중첩for문 이용한 구구단(2~18단)
		// 기본 구구단
		/*
		 * for (int dan = 2; dan <= 9; dan++) { // 단 for (int j = 1; j <= 9; j++) {
		 * System.out.println(dan + " X " + j + " = " + dan * j); }
		 * System.out.println("-------------------------"); }
		 */

		// break문을 이용해서 *4 까지만 나오게하기
		loop1: for (int dan = 2; dan <= 9; dan++) { // 단
			for (int j = 1; j <= 9; j++) {
				if (j == 5) {
					// break; // 현재의 반복문을 빠져나가 상위의 dan++로 이동
					break loop1; // label 이름을 명시하여 여러반복문 빠져나가는것도 가능 네이밍: 콜론
				}
				System.out.println(dan + " * " + j + " = " + dan * j);
			}
			System.out.println("-------------------------");
		}
		System.out.println("Q. 단을 입력하면 해당단이 나오게 해주세요. [5단]");
		Scanner sc = new Scanner(System.in);
		int num;
		/*
		 * while (true) { System.out.println("구하고자 하는 단을 입력해주세요:"); // 0단 입력시 종료 , 2~9단만
		 * 가능 num = sc.nextInt(); // 종료조건 if (num == 0) {
		 * System.out.println("프로그램을 종료합니다."); break; } // 잘못입력한 경우 if (num < 2 || num >
		 * 9) { System.out.println("2~9단만 입력해주세요"); continue; // continue,break는 반복문에서만
		 * 불러올수있음 } // 구구단 출력 System.out.println("[" + num + "단]"); for (int dan = 1;
		 * dan <= 9; dan++) { System.out.printf("%d x %d = %2d\n", num, dan, num * dan);
		 * } }
		 */

		System.out.println("가로 방향으로 구구단 출력");
		/*
		 * [2단] [3단] [4단] -단일 for 2x1=2 3x1=3 4x1=4 -다중 for
		 */
		for (int d = 2; d <= 9; d++) {
			System.out.print("[" + d + "단]\t");
		}
		System.out.println();
		for (int i = 1; i <= 9; i++) {
			for (int d = 2; d <= 9; d++) {
				System.out.print(d + "x" + i + "=" + d * i + "\t");
			}
			System.out.println();
		}

	}

}
