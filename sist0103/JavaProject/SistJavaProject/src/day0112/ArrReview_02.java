package day0112;

class Shop {
	private String name;
	private int price;
	private String color;
	private static int no;

	private static String title = "쌍용매장 입고상품";

	public Shop(String name, int price, String color) {
		this.name = name;
		this.price = price;
		this.color = color;
	}

	// 제목
	public static void showTitle() {
		System.out.println("[" + title + "]" + "\n");
		System.out.println("번호\t상품명\t가격\t색상");
		System.out.println("================================");
	}

	public void write() {
		no++;
		System.out.println(no + "\t" + name + "\t" + price + "\t" + color);
	}

}

public class ArrReview_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shop[] shop = new Shop[4];
		shop[0] = new Shop("요가매트", 25000, "핑크");
		shop[1] = new Shop("아령", 30000, "블랙");
		shop[2] = new Shop("레깅스", 45000, "베이지");
		shop[3] = new Shop("나시", 22000, "화이트");

		Shop.showTitle();
		for (int i = 0; i < shop.length; i++) {

			shop[i].write();
		}
		System.out.println("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ");
		
		for (Shop s : shop) {
			s.write();
		}
	}

}
