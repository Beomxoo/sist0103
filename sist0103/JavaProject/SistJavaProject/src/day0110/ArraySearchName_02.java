package day0110;

import java.util.Scanner;

public class ArraySearchName_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String[] names = { "유재석", "이광수", "지석진", "양세찬", "양세형", "송지효", "김종국", "하하", "전소민", "개리" };

		boolean flag;
		String fname;

		while (true) {

			flag = false;
			System.out.println("찾고자 하는 이름을 입력하세요");
			fname = sc.nextLine();
			if (fname.equals("종료")) {
				System.out.println("종료");
				break;
			}

			for (int i = 0; i < names.length; i++) {
				if (names[i].equals(fname)) { //fname.equals(name[i])
					flag = true;
					System.out.println((i + 1) + "번째에서 검색 되었습니다. 존재함");
				}
			}
			if (!flag) {
				System.out.println("존재하지 않습니다.");
			}

		}

	}

}
