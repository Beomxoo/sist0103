package day0124;

import java.awt.Color;

import javax.swing.JFrame;

public class Flame_01 extends JFrame{
	public Flame_01(String title) {
		super(title);
		
		//시작위치,너비,높이
		this.setBounds(500, 100, 370, 550);
		//배경색
		//this.getContentPane().setBackground(Color.CYAN); //static 상수를 이용한 색상
		this.getContentPane().setBackground(new Color(188,240,207)); //RGB 컬러
		//프레임에 보이게
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Flame_01("스윙기본");
		
	}

}
