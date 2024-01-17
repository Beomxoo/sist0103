package day0104;

import java.util.Calendar;

public class CalAge_12 {

	public static void main(String[] args) {
		// 매개변수 이용
		// 실행단계에서 변수입력하여 이름, 태어난년도 를 입력하여 나이를 출력해보자
		// calendar import 해서 하기

		// 1.import
		Calendar calendar = Calendar.getInstance();
		// 2.변수선언
		String name = args[0];

		int curYear = calendar.get(calendar.YEAR); // 현재년도
		int myYear = Integer.parseInt(args[1]); // 년도 계산을 위해 입력하는 문자열을 숫자(int)로 형변환

		// 3.계산 (계산할것이 있으면)
		int myAge = curYear - myYear;

		// 4.출력
		System.out.println("이름 : " + name);
		System.out.println("태어난 년도: " + myYear + " 년생");
		System.out.println("나이: " + myAge + " 세");
	}

}
