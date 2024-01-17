package day0105;

import java.util.Scanner;

public class OperTest_08 {

	public static void main(String[] args) {
		// 신체검사를 하는데 이름과 키,몸무게 입력하면
		// 표준몸무게를 출력해봅시다. (키-100)*0.9 표준몸무게 소수점 한자리로 출력하기
		/*
		 * 당신의 이름? 이효리
		 *  키? 165 
		 *  몸무게? 55
		 * 
		 * 
		 * 이효리님의 표준몸무게는 55kg 입니다.
		 */
		Scanner sc = new Scanner(System.in);

		String name;
		double my_height, my_weight;
		double st_weight;

		System.out.print("당신의 이름?==>");
		name = sc.nextLine();
		System.out.print("키?==>");
		my_height = sc.nextDouble();
		System.out.print("몸무게?==>");
		my_weight = sc.nextDouble();

		st_weight = (my_height - 100) * 0.9;

		System.out.printf("%s님의 권장 표준몸무게는 %.1fkg입니다.", name, st_weight);

	}
}
