package day0108;

public class SumTest_11 {

	public static void main(String[] args) {
		// 반복문안에서 합계구하기

		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			// sum = sum+i;
			sum += i; // sum에 i를 누적시킨다
		}
		System.out.println("1~10까지의 합: " + sum + " 입니다.");
		// while문
		int n = 1;
		int tot = 0;
		while (n <= 10) {
			// tot= tot+n;
			tot += n;
			n++;
		}
		System.out.println("1~10까지의 합: " + tot + " 입니다.");
		
		System.out.println("for문으로 1~10까지중 2씩 증가할경우의 합계를 구하시오");
		int sum1 = 0;
		for (int i=1; i<=10; i+=2) {
			sum1+=i;
		}
		System.out.println("1~10까지중 2씩 증가할경우의 합계는 "+ sum1 + " 입니다.");
		
		
	}

}
