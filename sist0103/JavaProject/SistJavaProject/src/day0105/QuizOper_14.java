package day0105;

import java.util.Scanner;

public class QuizOper_14 {

	public static void main(String[] args) {
		/*
		 * (점수에 대한 조건 90점이상:매우잘함 80점이상: 잘함 70점이상: 좀더노력할것 70점미만: 꽝 
		 * 이름을 입력해주세요 
		 * 김민아 
		 * 자바시험점수를 입력해주세요 
		 * 88
		 * 
		 * =========================== 김민아님의 시험결과는 잘함 입니다 ===========================
		 */
		Scanner sc = new Scanner(System.in);
		String myName, grade;
		int score;

		System.out.println("이름을 입력해주세요.");
		myName = sc.nextLine();
		System.out.println("자바시험점수를 입력해주세요.");
		score = sc.nextInt();

		if (score >= 90) {
			grade = "매우잘함";
		} else if (score >= 80) {
			grade = "잘함";
		} else if (score >= 70) {
			grade = "좀더 노력할것";
		} else {
			grade = "꽝!!";
		}

		grade = score >= 90 ? "매우잘함" : 
			score >= 80 ? "잘함" : 
			score >= 70 ? "좀더 노력할것" : "꽝!!";

		System.out.println("===========================");
		System.out.println(myName + "님의 시험결과는 " + grade + " 입니다.");
		System.out.println("===========================");

	}

}
