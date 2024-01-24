package day0119;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SwingRadioCheck_02 extends JFrame implements ActionListener {

	Container cp;
	JRadioButton[] rb = new JRadioButton[4]; // 하나만 선택하고 싶을때 [
	JCheckBox[] cb = new JCheckBox[4]; // 여러개 골라도 되고 안골라도 되고 자유
	Color[] colors = { Color.RED, Color.GREEN, Color.MAGENTA, Color.CYAN };
	JLabel lblMessage;

	public SwingRadioCheck_02(String title) {
		super(title);
		cp = this.getContentPane();
		this.setBounds(300, 100, 500, 400);
		cp.setBackground(new Color(255, 204, 204));
		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		// 상단패널 보더로 감싼 4개의 라디오버튼
		String[] str1 = { "RED", "GREEN", "MAGENTA", "CYAN" };

		JPanel pTop = new JPanel();
		pTop.setBorder(new TitledBorder("글자색"));
		this.add(pTop, BorderLayout.NORTH);

		// 라디오버튼 하나만 선택되도록 하려면 그룹을 지어줘야함
		ButtonGroup bg = new ButtonGroup();

		for (int i = 0; i < rb.length; i++) {
			rb[i] = new JRadioButton(str1[i], i == 1 ? true : false); // 라디오버튼생성(텍스트,기본체크) i==1? true : false 디폴트값 넣어주기
			pTop.add(rb[i]); // 탑패널에 추가
			bg.add(rb[i]); // 버튼그룹에 추가
			rb[i].addActionListener(this); //액션 추가 연동
		}
		// 가운데 라벨
		lblMessage = new JLabel("안녕하세요~ 즐거운 금요일", JLabel.CENTER); // 가로 가운데
		this.add("Center", lblMessage); // 여기에 주면 세로 가운데
		lblMessage.setBorder(new LineBorder(Color.RED, 2)); // 라인 굵기

		// 하단패널 보더로 감싼 4개의 체크박스
		JPanel pBottom = new JPanel();
		pBottom.setBorder(new TitledBorder("가능언어"));
		this.add("South", pBottom);

		String[] str2 = { "자바", "오라클", "파이썬", "C" };

		for (int i = 0; i < cb.length; i++) {
			cb[i] = new JCheckBox(str2[i]);
			cb[i].addActionListener(this); //액션 추가 연동
			pBottom.add(cb[i]);

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		//라디오버튼 호출처리, 메세지 출력이 컬러별로 출력되도록
		for(int i=0; i<rb.length; i++) {
			if(ob==rb[i]) {
				lblMessage.setForeground(colors[i]);
				lblMessage.setFont(new Font("", Font.BOLD, 22));
			}
		}
		//체크박스 호출처리(다중선택:자바 JSP)
		String msg = "";
		for(int i=0; i<cb.length; i++) {
			if(cb[i].isSelected()) { // cb[i].isSelected()==true 와 동일함
				msg+=cb[i].getText()+ " ";
				lblMessage.setText(msg);
			}
		}
		
	}
	

	public static void main(String[] args) {
		new SwingRadioCheck_02("스윙 라디오 체크박스_2");

	}

}