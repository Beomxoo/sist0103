package day0112;

class Food {

	private String foodName;
	private int fPrice;

	static int no;

	// 명시적 생성자(2개)
	public Food(String foodName, int fPrice) {
		this.foodName = foodName;
		this.fPrice = fPrice;
	}

	// 출력문
	public void writeFood() {
		System.out.println("음식명: " + foodName);
		System.out.println("가격: " + fPrice);
		System.out.println("=========================");
	}

	// 제목
	public static void showTitle() {
		no++;
		System.out.println("메뉴_" + no);

	}

}

public class ArrReview_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Food food1 = new Food("마르게리타 피자", 12000);
		 * 
		 * Food.showTitle(); food1.writeFood();
		 * 
		 * Food food2 = new Food("까르보나라 스파게티", 15000);
		 * 
		 * Food.showTitle(); food2.writeFood();
		 * 
		 * Food food3 = new Food("리코타 샐러드", 9000);
		 * 
		 * Food.showTitle(); food3.writeFood();
		 */
		Food[] food = new Food[3];
		food[0] = new Food("마르게리타 피자", 12000);
		food[1] = new Food("까르보나라 스파게티", 15000);
		food[2] = new Food("리코타 샐러드", 9000);
		for (int i = 0; i < food.length; i++) {
			/*
			 * Food f = food[i]; f.writeFood(); /
			 */
			Food.showTitle();
			food[i].writeFood();

		}
		System.out.println();

		for (Food f : food) {
			Food.showTitle();
			f.writeFood();
		}
	}

}
