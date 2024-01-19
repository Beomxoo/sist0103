package day0118;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

public class QuizSwing_10 extends JFrame implements ActionListener {

	Container cp;
	JButton[] btn = new JButton[5];
	String[] btnlabel = { "빨강색", "파란색", "노란색", "초록색", "주황색" };
	Color[] btnColor = { Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.ORANGE };
	JLabel lblstr;

	public QuizSwing_10(String title) {
		super(title);
		cp = this.getContentPane();
		this.setBounds(300, 100, 700, 300);
		cp.setBackground(new Color(255, 204, 204));
		initDesign();
		this.setVisible(true);
		
	}

	public void initDesign() {
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		this.add(panel, BorderLayout.NORTH);

		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btnlabel[i]);
			btn[i].setBackground(btnColor[i]);
			btn[i].addActionListener(this);
			panel.add(btn[i]);
		}

		
		
		lblstr = new JLabel("안녕하세요.");
		lblstr.setBounds(100, 100, 100,100);
		lblstr.setFont(new FontUIResource("", Font.BOLD, 25));
		lblstr.setBackground(Color.PINK);
		lblstr.setHorizontalAlignment(JLabel.CENTER);
		lblstr.setOpaque(true);
		this.add(lblstr);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		for (int i = 0; i < btn.length; i++) {
			if (ob == btn[i]) {
				lblstr.setForeground(btnColor[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new QuizSwing_10("스윙 퀴즈");
	}

}