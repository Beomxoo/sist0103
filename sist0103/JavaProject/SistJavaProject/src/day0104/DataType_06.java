package day0104;

public class DataType_06 {

	public static void main(String[] args) {
		// 기본자료형 8개

		boolean flag = false; //1.논리형 true,false
		
		//2.문자형
		//반드시 하나의 문자, 16바이트 유니코드값 표현
		//2바이트 문자하나
		//기본적으로 정수형, 아스키코드로 변경이 가능하므로
		//''로 표현
		char ch='가';
		
		//3.정수형
		byte a = 127;  //1바이트 -128~127
		short b = 32000; //2바이트 16bit
		int c = 670000; //4바이트 32bit
		long d = 100L; //8바이트 64bit  뒤에 L,l을 붙혀야 long인지 int인지를 의미
		
        //실수
		float f=3.1234f; //4바이트 32bit 뒤에 f를 붙히지않으면 double을 의미
		
		double dou=23456.1234567; //8바이트 64bit 소수점가진 숫자의미 double이 기본
		
		//출력
		System.out.println("flag="+ flag);
		System.out.println("ch="+ ch);
		
		System.out.println("정수 a="+ a);
		System.out.println("정수 b="+ b);
		System.out.println("정수 c="+ c);
		System.out.println("정수 d="+ d);
		
		System.out.println("실수 f="+ f);
		System.out.println("실수 dou="+ dou);
		
	}

}
