package day0118;

import java.awt.Container;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLay_03 extends JFrame{
	Container cp;
	JButton btn1; //버튼선언
	
	public SwingLay_03(String title) {
		super(title);
		
		cp = this.getContentPane();
		this.setBounds(300, 100, 300, 300);
		cp.setBackground(new Color(255,204,204));
		
		//버튼생성
		btn1 = new JButton("버튼1");
		//버튼을 만들었으니, 프레임에 버튼 추가
		//프레임은 기본이 BorderLayout  보더레이아웃 변경시 다 생성해야함
		//이경우는 위치 지정이 필수
		this.add("North",btn1); // 첫글자 대문자
		
		this.add("South",new JButton("아래쪽"));
		this.add("West",new JButton("오른쪽"));
		this.add("East",new JButton("왼쪽"));
		this.add("Center",new JButton("가운데"));
		
		//버튼 1에 속성추가
		btn1.setBackground(Color.YELLOW);
		btn1.setForeground(Color.GREEN);
		
		
		this.setVisible(true); //항상 맨 마지막이여야함 보여주는것
	}
	public static void main(String[] args) {
		new SwingLay_03("기본레이아웃");
		
	}

}
