package spring.di.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SawonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("appContext3.xml");
		
		//sawon
		Sawon sawon=(Sawon)context.getBean("sawon");
		sawon.writeData();
		
		Sawon sawon2=(Sawon)context.getBean("sawon2");
		sawon2.writeData();
	}

}
