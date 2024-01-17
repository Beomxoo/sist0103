package day0112;

public class SubObj_03 extends SuperObj_03 {
	String addr;

	public SubObj_03(String name, int age, String addr) {
		super(name, age); // 반드시 첫줄, 부모생성자 호출
		// 디폴트생성자는 super(); 자동으로 생성됨
		this.addr = addr;
	}

	public SubObj_03() {
		super();
	}

	public void writeData() {
		System.out.println("이름: " + this.name); // 위에서 생성자로 생성했으므로 부모껏도 내꺼가됨 고로 super.name이 아님
		System.out.println("나이: " + this.age);
		System.out.println("주소: " + this.addr);
	}
}
