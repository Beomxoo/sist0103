package day0105;

import java.util.Scanner;

public class QuizOper_19 {

	public static void main(String[] args) {

		/*
		 * (평가 90점이상 참잘함!! 80점이상은 좀더 노력하세요~~ 80점미만 불합격) 이름을 입력하세요. 손흥민 국,영,수 점수를 입력하세요.
		 * 88 99 77
		 * 
		 * ======================== 
		 * [손흥민 님의 기말고사 성적] 
		 * 총점: **점 
		 * 평균: **.*점 
		 * 평가: 좀더 노력하세요~~~
		 */
		Scanner sc = new Scanner(System.in);
		String name, grade;
		int kor, eng, mat;
		int tot;
		double avg;

		System.out.println("이름을 입력하세요.");
		name = sc.nextLine();
		System.out.println("국,영,수 점수를 입력하세요.");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();

		tot = kor + eng + mat;
		avg = tot / 3.0;
		
		if (avg>=90) {
			grade = "참잘함!!!";
		} else if (avg>=80) {
			grade = "좀더 노력하세요~~~";
		} else {
			grade = "불합격";
		}

		System.out.println("========================");
		System.out.println("[" + name + "님의 기말고사 성적]");
		System.out.println("총점: "+ tot);
		System.out.printf("평균: %.1f\n", avg);
		System.out.println("평가: "+ grade);

	}

}
