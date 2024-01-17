package day0105;

import java.util.Scanner;

public class prac_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int year;
		year = sc.nextInt();

		if (year%4==0) {
			if(year%100!=0 || year%400==0) {
				System.out.println("1");
			}
			else {
				System.out.println("0");
			}
		} else {
			System.out.println("0");
		}

	}

}
