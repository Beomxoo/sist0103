package day0110;

public class ArraysChange_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = 10, b = 20;
		System.out.println("a=" + a + ", b=" + b);

		int temp = a;
		a = b;
		b = temp;
		System.out.println("a=" + a + ", b=" + b);

		int[] n = { 5, 8, 4 };

		for (int s : n) {
			System.out.print(s + " ");
		}

		System.out.println("\n0번이랑 2번을 교환 후 출력");
		int temp2 = n[0];
		n[0] = n[2];
		n[2] = temp2;
		for (int s : n) {
			System.out.print(s + " ");
		}

	}

}
