package day0105;

import java.util.Scanner;

public class OperTest_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 두수를 입력해서 산술연산자를 이용해서 출력해봅시다.(+,-,*,/,%)
		/* 
		 * 두수 입력해주세요
		 * 6
		 * 2
		 * 
		 * [산술연산자결과]
		 * 더하기: 
		 * 빼기:
		 * 곱하기:
		 * 나누기:
		 * 나머지값:
		 */ 
		Scanner sc = new Scanner(System.in);
		int a,b;
		
		System.out.println("두수를 입력해주세요.");
		a= sc.nextInt();
		b= sc.nextInt();
		
		System.out.println("[산술연산자결과");
		System.out.println("더하기:"+ (a+b));
		System.out.println("빼기:"+ (a-b));
		System.out.println("곱하기:"+ (a*b));
		System.out.println("나누기:"+(double)a/b);
		System.out.println("나머지값:"+ (a%b));
		
		
	}

}
