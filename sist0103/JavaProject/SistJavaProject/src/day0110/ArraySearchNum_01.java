package day0110;

import java.util.Scanner;

public class ArraySearchNum_01 {

	public static void main(String[] args) {
		// 배열중에서 숫자찾기
		// 있는지 찾기,없으면 없다고 있으면 몇번째 있는지 출력
		// 0 입력시 종료

		int[] data = { 2, 12, 99, 65, 47, 87, 32, 55, 66, 49, 91, 120, 259 };

		boolean flag;
		Scanner sc = new Scanner(System.in);
		int su;

		while (true) {
			System.out.println("검색할 숫자 입력");
			su = sc.nextInt();

			// 0입력시 종료
			if (su == 0) {
				System.out.println("프로그램 종료!!!");
				break;
			}

			flag = false; // 일단은 없다고 가정하고 찾으면 true로 바꾼다

			// 값 찾기
			for (int i = 0; i < data.length; i++) {
				if (su == data[i]) {
					flag = true;
					System.out.println((i + 1) + "번째 에서 검색 ");
				}
			}
			if (!flag == true) { //flag ==false 
				System.out.println("입력한 " + su + "는 데이터에 없습니다.");
			}

		}

	}

}
