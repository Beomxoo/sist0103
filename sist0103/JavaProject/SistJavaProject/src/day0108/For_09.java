package day0108;

import java.util.Iterator;

public class For_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 가로로 1~10까지 출력
		for (int i = 1; i <= 10; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		// 10~1까지 출력
		for (int i = 10; i > 0; i--) {
			System.out.print(i + "  ");
		}
		System.out.println();

		// 배수 , continue
		for (int i = 0; i <= 50; i += 5) {
			System.out.print(i + "  ");
		}
		System.out.println();

		// continue
		for (int i = 1; i <= 20; i++) {
			// 1 2 3 4 6 7 8 9 11 12 13 14 16 17 18 19 출력
			// 5의 배수 빼고 출력
			if (i % 5 == 0) {
				continue; //continue 아래 문장은 수행하지 않고 바로 i++로 이동
			}
			System.out.print(i + " ");
		}
		System.out.println();
	}

}
