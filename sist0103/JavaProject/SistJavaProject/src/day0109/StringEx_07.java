package day0109;

public class StringEx_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("String 객체에 대한 멤버 메서드 학습");
		
		String str1= "apple";
		String str2= "Apple";
		String str3= "Have a Nice Day";
		String str4= "   Today now   ";
		
		System.out.println("str3의 길이:"+str3.length());
		
		System.out.println("str4의 길이:"+str4.length());
		
		System.out.println("앞뒤 공백 제거후 str4의 길이: "+ str4.trim().length()); //앞뒤 공백만제거가능
		System.out.println("*"+ str4.trim()+ "*");
		
		System.out.println("str3에서 0번 문자:"+str3.charAt(0));
		System.out.println("str3에서 7번 문자:"+str3.charAt(7));
		
		System.out.println("str3의 H의 인덱스: "+str3.indexOf('H'));
		System.out.println("str3의 N의 인덱스: "+str3.indexOf('N'));
		
		System.out.println("str3에서 Have 추출: "+str3.substring(0, 4));
		System.out.println("str3에서 Nice 추출: "+str3.substring(7, 11)); //index 시작번호, 끝번호+1
		System.out.println("str3에서 Nice부터 끝까지: "+str3.substring(7)); //index 번호부터 끝까지
		
		//equals는 같으면 true,다르면 false
		System.out.println("문자열비교: "+ str1.equals(str2));
		System.out.println("문자열비교: "+ str1.equalsIgnoreCase(str2));
		
		//a.compareTo(b)
		//a와b가 같으면 0
		//a가 작으면 -값(알파벳은 차이만큼 -값이 나옴)
		//a가 클경우 +값(알파벳은 차이만큼 +값이 나옴)
		System.out.println(str1.compareTo(str2)); // 아스키코드 a=97 A=65
		System.out.println(str1.compareTo(str1)); // 같으면 0
		System.out.println("computer".compareTo("command")); //com까지는 같으니 그 뒤인 p와 m을 비교
		
	}

}
