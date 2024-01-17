package day0110;

class Mart {

	private String sangpum; 
	int su;
	int dan;
	static String SHOPNAME = "롯데마트";
	
	/*public static Mart getInstance() {
		return new Mart();
	} */
	//sangpum은 메서드가 아니면 다른클래스에서 접근불가
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	
	public String getSangpum() {
		return sangpum;
	}
	
	/*
	public void setSu(int su) {
		this.su = su;

	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	
	//su,dan은 private가 아니므로 다른클래스에서 생성시 변수접근 가능하다
	//static은 다른클래스에서 접근시 클래스명,변수명으로 접근 가능하다.
	public int getSu() {
		return su;
	}

	public int getDan() {
		return dan;
	}
	*/

}

public class QuizClass_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mart m1 = new Mart();
		m1.setSangpum("쵸코파이");
		m1.su=10;
		m1.dan=4500;
		
		Mart m2 = new Mart();
		m2.setSangpum("엄마손파이");
		m2.su=5;
		m2.dan=2500;
		
		System.out.println("**"+ Mart.SHOPNAME+" 입고상품**");
		System.out.println("상품명: "+m1.getSangpum());
		System.out.println("수량: "+ m1.su+ "개");
		System.out.println("가격: "+ m1.dan+ "원");
		System.out.println("---------------------------------------");
		System.out.println("상품명: "+m2.getSangpum());
		System.out.println("수량: "+ m2.su+ "개");
		System.out.println("가격: "+ m2.dan+ "원");
		
		
		/*Mart m1 = new Mart();
		m1.setSu(10);
		m1.setDan(4500);
		int ssu = m1.getSu();
		int ddan = m1.getDan();
		Mart mart = Mart.getInstance();
		mart.setSangpum("쵸코파이");
		String ssangpum = mart.getSangpum();

		System.out.println("***롯데마트 입고물품***");
		System.out.println("=========================");
		System.out.println("상품명: " + ssangpum);
		System.out.println("수량: "+ ssu+ "개");
		System.out.println("가격: "+ ddan+ "원");
		System.out.println("---------------------------------------");
		Mart m2 = new Mart();
		m2.setSu(5);
		m2.setDan(2500);
		int ssu1 = m2.getSu();
		int ddan1 = m2.getDan();
		Mart mart1 = Mart.getInstance();
		mart1.setSangpum("엄마손파이");
		String ssangpum1 = mart1.getSangpum();
		System.out.println("상품명: " + ssangpum1);
		System.out.println("수량: "+ ssu1+ "개");
		System.out.println("가격: "+ ddan1+ "원");
		*/
	}

}
