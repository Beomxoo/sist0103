package spring.day0430.anno2;

import org.springframework.stereotype.Component;

@Component
public class VietnamManggo implements Manggo {

	@Override
	public void writeMangoName() {
		// TODO Auto-generated method stub
		System.out.println("내가 좋아하는 베트남 망고!!!");		
	}

}
