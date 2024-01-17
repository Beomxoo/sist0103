package day0104;

public class DataType_09 {

	public static void main(String[] args) {
		// args이용한 연산

		// 변수선언
		int java = Integer.parseInt(args[0]);
		int jsp = Integer.parseInt(args[1]);
		int spring = Integer.parseInt(args[2]);

		// 계산
		int tot = java + jsp + spring;
		int count = 3; // 3과목의미하는 변수

		double avg1 = tot / count; // 결과는 무조건 int이나 , 변수의 자료형이 double이므로 -> 출력은 double 결과
		//결과는 무조건 int .. 작은건 큰거에 담기므로 double 생략가능
		double avg2 = (double) tot / count; // int형 변수 tot을 cast해서 결과 자체가 double로 나온다.

		System.out.println(avg1);
		System.out.println(avg2);

		// printf를 이용해서
		System.out.printf("java=%d, jsp=%d, spring=%d\n", java, jsp, spring);
		System.out.println("총점="+ tot);
		
		System.out.printf("평균=%.2f", avg2);
		

	}

}
