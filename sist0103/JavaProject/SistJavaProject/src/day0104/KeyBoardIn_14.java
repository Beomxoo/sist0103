package day0104;

import java.util.Scanner;

public class KeyBoardIn_14 {

	public static void main(String[] args) {
		// 키보드 입력에 필요한 Scanner 클래스를 import 해야함
		// 1.import
		Scanner sc = new Scanner(System.in);

		// 2.변수선언
		String name;
		int age;

		// 3.입력을 하기 위한 출력문
		System.out.print("이름을 입력해 보세요==>");
		name = sc.nextLine(); // 문자열을 한줄로 반환해주는 메소드  한줄을 문자로 읽어온다(공백사용가능)

		System.out.print("나이를 입력하세요==>");
		//age = sc.nextInt();  // 숫자로 읽어온다. 숫자로 읽고 다음에 문자열 입력시 버퍼
		age = Integer.parseInt(sc.nextLine());
		//숫자 입력후 엔터누르면 그 엔터가 키보드 버퍼로 저장되어 다음 문자열 읽을때 먼저 읽어버리는 현상 발생
		//그래서 다음문자열 읽기전에 그 엔터를 읽어 없애기. -> sc.nextline() 사용하여 줄넘김
		
		System.out.print("당신이 사는 지역은?");
		String city = sc.nextLine(); //숫자를 
		// 4.최종출력
		System.out.println(name + "님의 나이는 " + age + "세 이고,"+ city + "지역에 살아요.");

	}

}
