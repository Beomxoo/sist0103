package day0116;

abstract class AbstObj {
	abstract public void dataIn();

	abstract public void dataOut();
}

/////////////////////////////////////////////////////////
class SubAbst extends AbstObj {

	@Override
	public void dataIn() {
		System.out.println("상속_데이터입력");
	}

	@Override
	public void dataOut() {
		System.out.println("상속_데이터출력");
	}

}

////////////////////////////////////////////////////////
public class Anonymous_09 {

	// 익명내부클래스
	AbstObj ab1 = new AbstObj() {

		@Override
		public void dataOut() {
			System.out.println("익명내부클래스_데이터출력");

		}

		@Override
		public void dataIn() {
			// TODO Auto-generated method stub
			System.out.println("익명내부클래스_데이터입력");
		}
	};
	
	//SubAbst sub = new SubAbst(); 생성시 main함수 실행문에서 ano.sub.dataIn(); 사용가능

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 익명내부클래스
		Anonymous_09 ano = new Anonymous_09();
		ano.ab1.dataIn();
		ano.ab1.dataOut();
		// 상속받은클래스
		SubAbst sub = new SubAbst();
		sub.dataIn();
		sub.dataOut();
		
	}

}
