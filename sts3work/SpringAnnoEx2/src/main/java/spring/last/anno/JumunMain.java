package spring.last.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JumunMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext japp=new ClassPathXmlApplicationContext("annoContext1.xml");
		
		OrderController oc=(OrderController)japp.getBean("orderController");
		
		oc.jumunInsert("마우스", 9, "검정색");
		oc.jumunDelete("2");
		oc.jumunSelect("아령", 45000, "핑크");
	}

}
