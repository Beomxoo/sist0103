package spring.di.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex4Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app4=new ClassPathXmlApplicationContext("appContext4.xml");
		
		Sungjuk sungjuk=(Sungjuk)app4.getBean("sj"); //规过1
		//Sungjuk sungjuk=app4.getBean("sj", Sungjuk.class); //规过2
		sungjuk.writeSungjuk();
	}

}
