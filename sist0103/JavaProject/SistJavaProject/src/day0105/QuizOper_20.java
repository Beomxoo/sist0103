package day0105;

import java.util.Scanner;

public class QuizOper_20 {

	public static void main(String[] args) {
		/*
		 * (상품을 5개 이상 구매시 10% 할인하여 계산된다) 상품명: 키보드 수량: 3 가격: 20000
		 * 
		 * ============================= **5개이상 구매시 10% 할인됩니다 .
		 * ** 키보드 5개는 총 90000원 입니다.
		 * 할인된 금액은: 10000원
		 * 
		 */
		Scanner sc = new Scanner(System.in);
		String name;
		int num, price;
		int discount, tot;

		System.out.print("상품명: ");
		name = sc.nextLine();
		System.out.print("수량: ");
		num = sc.nextInt();
		System.out.print("가격: ");
		price = sc.nextInt();

		tot = num * price;
		discount = tot / 10;

		if (num >= 5) {
			tot = tot / 10 * 9;
		}
		System.out.println("=============================");
		System.out.println("**5개이상 구매시 10% 할인됩니다.**");
		System.out.println(name+" " + num + "개는 총 " + tot + "원 입니다.");
		System.out.println("할인된 금액은 " + discount + "원");

	}

}
