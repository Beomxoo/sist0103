package day0109;

import java.util.Scanner;

public class RandomSu_06 {

	public static void main(String[] args) {
		// 1~10사이의 랜덤수를 발생시켜 그 숫자 맞추기
		Scanner sc = new Scanner(System.in);

		int rnd = (int) (Math.random() * 10) + 1; // 1~10까지의 범위

		int su; // 입력할수
		int cnt = 0; // count 횟수를 구하는 변수

		while (true) {
			cnt++;
			System.out.print("시도횟수 " + cnt + "회 : ");
			su = sc.nextInt();

			if (su > rnd) {
				System.out.println(su + "보다 작습니다.");
			} else if (su < rnd) {
				System.out.println(su + "보다 큽니다.");
			} else {
				System.out.println("정답입니다. 정답은 " + rnd + "입니다.");
				break;
			}
		}

	}

}
