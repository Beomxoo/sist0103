package day0104;

public class QuizDataType_10 {

	public static void main(String[] args) {
		// 변수는 args를 이용할것(변수는 5개 0~4까지).. 변수명은 알아서 어울리게.
		/*
		 * 학생명: 김선호 님
		 * 지역: 부산
		 * 나이: 23 세
		 * 
		 *  ===============================================
		 *  김선호님의 자바점수는 88점  오라클점수는 77점  총 165점입니다.
		 *  
		 */
		//1.변수선언 2.계산 3.최종출력
		
		//1.변수선언
		String name = args[0], region = args[1];
		int age = Integer.parseInt(args[2]); //숫자 계산이 필요없으면 String age=args[2]로 해도 상관없음
		int java = Integer.parseInt(args[3]);
		int oracle = Integer.parseInt(args[4]);
		
		//2.계산
		int total= java + oracle;
		
		//3.최종출력
		System.out.println("학생명: "+ name+ "님");
		System.out.println("지역: "+ region);
		System.out.println("나이: "+ age+ "세");
		System.out.println();
		System.out.println("===============================================");
		System.out.printf("%s님의 자바점수는 %d점  오라클점수는 %d점  총 %d점입니다.", name,java,oracle,total);
		
	}

}
