package day0110;

class Car {
	// 필드선언
	String model;
	int speed;

	// 생성자 선언
	Car(String model) {
		this.model = model;
	}

	// 메소드선언
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		setSpeed(100);
		System.out.println(model+"가 달립니다.(시속:"+ speed+ "km/h)");
	}
	
}

public class Book243_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car("포르쉐");
		Car yourCar = new Car("벤츠");
		
		myCar.run();
		yourCar.run();
				
	}

}
