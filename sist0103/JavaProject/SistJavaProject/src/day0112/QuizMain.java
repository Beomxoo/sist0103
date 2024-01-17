package day0112;

import java.util.Scanner;

class Quiz {
	private String schoolName;
	private String stuName;
	private int java, oracle, html;
	private int tot = 0;
	private double avg;
	private String grade;
	
	// 디폴트생성자
	public Quiz() {
		
	}
	// 명시적생성자
	public Quiz(String schoolName, String stuName, int java, int oracle, int html) {
		this.schoolName = schoolName;
		this.stuName = stuName;
		this.java = java;
		this.oracle = oracle;
		this.html = html;
	}

	// getter setter
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	// 총점 메서드
	public int getTotal() {
		tot = java + oracle + html;
		return tot;
	}

	// 평균메서드
	public double getAverage() {
		avg = tot / 3.0;
		return avg;
	}

	// 평가메서드
	public String getPyungga() {
		if (avg >= 90) {
			grade = "장학생";
		} else if (avg >= 80) {
			grade = "합격";
		} else {
			grade = "불합격";
		}
		return grade;
	}

	// 제목
	public static void showTitle() {

		System.out.println();
		System.out.println("이름\tJAVA\tORACLE\tHTML\t총점\t평균\t평가");
		System.out.println("==================================================");
	}

}

public class QuizMain {
	// 출력메서드
	public void write(Quiz[] qu) {
		Quiz.showTitle();
		for (Quiz q : qu) {
			System.out.println(q.getStuName() + "\t" + q.getJava() + "\t" + q.getOracle() + "\t" + q.getHtml() + "\t"
					+ q.getTot() + "\t" + q.getAvg() + "\t" + q.getGrade());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("학교이름을 입력하세요.");
		String name = sc.nextLine();
		
		int inwon;
		Quiz[] qu;
		System.out.println();
		
	}

}
