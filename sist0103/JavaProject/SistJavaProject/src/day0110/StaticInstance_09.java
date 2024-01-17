package day0110;

//static 변수는 메모리에 한번 할당되면 프로그램이 종료될때 해제되는 변수
//약수터에 공용바가지 느낌
//메모리에 한번 할당이므로 여러객체가 해당 메모리를 공유..-> 메모리 효율이 좋아진다.

public class StaticInstance_09 {

	static int count = 0; // 인스턴스변수
	
	//생성자 [이름은 클래스이름과 같아야함]
	public StaticInstance_09() {
		count++;
		System.out.println(count);
		
	}
	
	
	public static void main(String[] args) {
		//객체변수는 항상 독립적이므로 count는 서로 다른 메모리를 가지므로 증가하지 않는다. 각 1 , 1이나옴
		// 그러나 변수를 static 변수로 선언한경우, 메모리 공유하기때문에 > 값이 2가 나옴  증가하여 누적
		StaticInstance_09 s1 = new StaticInstance_09();
		StaticInstance_09 s2 = new StaticInstance_09();
	}

}
