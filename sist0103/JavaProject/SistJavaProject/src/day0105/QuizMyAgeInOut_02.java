package day0105;

import java.util.Calendar;
import java.util.Scanner;

public class QuizMyAgeInOut_02 {

	public static void main(String[] args) {
		/*
		 * 당신의 이름은?==>손범수 당신이 태어난 연도는?==>1998 당신이 사는 지역은?==>서울
		 * 
		 * ===============================
		 *  [손범수 님의 개인정보] 
		 *  ===============================
		 * 이름: 손범수 
		 * 태어난년도: 1998 
		 * 나이: **세 
		 * 지역 : 서울
		 */
		// 1.임포트
		Scanner sc = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();

		// 2.변수
		String name, region;
		int curYear, myAge;

		// 3.입력
		System.out.print("당신의 이름은?==>");
		name = sc.nextLine();
		System.out.print("당신이 태어난 연도는?==>");
		//myYear=sc.nextInt();
		int myYear = Integer.parseInt(sc.nextLine());
		//Integer.parseInt("1998")=1998 : String -> int
		//sc.nextLine() 는 키보드의 버퍼나 엔터를 먼저읽어서 없애준다.
		System.out.print("당신이 사는 지역은?==>");
		region = sc.nextLine();

		// 4.계산
		curYear = cal.get(cal.YEAR);
		myAge = curYear - myYear;
		
		// 5.결과출력
		System.out.println("===============================");
		System.out.println("[손범수 님의 개인정보]");
		System.out.println("===============================");
		System.out.println("이름: " + name);
		System.out.println("태어난년도: " + myYear);
		System.out.println("나이: " + myAge);
		System.out.println("지역: " + region);

	}

}
