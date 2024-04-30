package spring.day0430.anno3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex3Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app3=new ClassPathXmlApplicationContext("annoContext1.xml");
		
		TestController tc=(TestController)app3.getBean("testController");
		tc.insert("±è¹Î±Ô");
		tc.delete("±è¸Õ±Ô");
		tc.select("±è¸¸±Ô");
	}

}
