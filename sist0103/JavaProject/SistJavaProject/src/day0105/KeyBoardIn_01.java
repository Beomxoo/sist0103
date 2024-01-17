package day0105;

import java.util.Scanner;

public class KeyBoardIn_01 {

	public static void main(String[] args) {
		// 이름, 핸드폰번호, 주소 입력후 출력
		// 1.임포트
		Scanner sc = new Scanner(System.in);

		// 2.변수선언
		String name, hp, addr; // 자료형이 같을때는 나란히 변수선언가능

		// 3.입력
		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();

		System.out.println("휴대폰번호를 입력하세요.");
		hp = sc.nextLine();

		System.out.println("주소를 입력하세요.");
		addr = sc.nextLine();

		// 최종출력
		System.out.println("============================");
		System.out.println("\t[입력결과]");
		System.out.println("이름: " + name + "님");
		System.out.println("핸드폰번호: " + hp);
		System.out.println("주소: " + addr);

	}

}
