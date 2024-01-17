package day0111;

class Artist {
	// 변수명
	private String company;
	private String groupName;
	private String song;
	static String art;
	static int cnt = 0;

	// 명시적 생성자
	Artist(String company, String groupName, String song) {
		this.company = company;
		this.groupName = groupName;
		this.song = song;
	}

	// 출력메서드
	public void writeInfo() {
		cnt++;
		System.out.println("**" + art + cnt + " 정보**");
		System.out.println("소속기획사: " + this.company);
		System.out.println("그룹명: " + this.groupName);
		System.out.println("대표곡: " + this.song);
		System.out.println("====================================");
	}

}

public class QuizInstance_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Artist art1 = new Artist("하이브", "bts", "버터");
		Artist art2 = new Artist("하이브", "뉴진스", "어텐션");
		Artist.art = "아티스트_";
		art1.writeInfo();
		art2.writeInfo();
	}

}
