package day0112;

//부모클래스
class Car {
	private String carCommpay; // 제조회사
	private String carKind; // 종류
	// 디폴트 생성자

	public Car() {
	}

	// 명시적생성자
	public Car(String carCommpay, String carKind) {
		this.carCommpay = carCommpay;
		this.carKind = carKind;
	}

	// setter getter
	public String getCarCommpay() {
		return carCommpay;
	}

	public void setCarCommpay(String carCommpay) {
		this.carCommpay = carCommpay;
	}

	public String getCarKind() {
		return carKind;
	}

	public void setCarKind(String carKind) {
		this.carKind = carKind;
	}

	// 메서드
	public void writeCar() {
		System.out.println("회사명: " + carCommpay);
		System.out.println("종류: " + carKind);
	}
}

//////////////////////////
//자식클래스
class MyCar extends Car {
	private String carName;
	private String carColor;
	private int carPrice;

	public MyCar() {
		this("현대", "전기차", "아이오닉5", "블랙", 35000000);
	}

	public MyCar(String carCommpay, String carKind, String carName, String carColor, int carPrice) {
		super(carCommpay, carKind);
		this.carName = carName;
		this.carColor = carColor;
		this.carPrice = carPrice;

	}

	// setter getter
	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}

	@Override
	public void writeCar() {
		super.writeCar();
		System.out.println("자동차명: " + carName);
		System.out.println("색상: " + carColor);
		System.out.println("가격: " + carPrice + "원");

	}

}

public class Inherit_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCar mc = new MyCar();
		System.out.println("**디폴트 생성자로 생성**");
		mc.writeCar();

		System.out.println();
		System.out.println("**명시적 생성자로 생성**");
		MyCar mc1 = new MyCar("기아", "가솔린", "코나", "화이트", 25000000);
		mc1.writeCar();
	}

}
