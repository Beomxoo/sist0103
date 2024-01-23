package day0119;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Joomal extends JFrame implements ItemListener {
	Container cp;
	JCheckBox[] cbNara = new JCheckBox[4];
	JCheckBox cbGender;
	JRadioButton[] rb = new JRadioButton[3];
	JLabel lblResult;
	Color[] colors = { Color.RED, Color.BLUE, Color.BLACK };
	JPanel panel1, panel2, panel3;

	public Joomal(String title) {
		super(title);
		cp = this.getContentPane();
		this.setBounds(300, 300, 450, 300);
		cp.setBackground(Color.CYAN);
		initDesign();
		this.setVisible(true);

	}

	public void initDesign() {
		this.setLayout(null);

		cbGender = new JCheckBox("남자");
		cbGender.setBounds(20, 20, 100, 30);
		cbGender.setOpaque(false);
		cbGender.addItemListener(this);
		this.add(cbGender);

		String[] str1 = { "빨강", "파랑", "검정" };
		ButtonGroup bg = new ButtonGroup();
		int xpos = 20;

		panel1 = new JPanel();
		panel1.setBorder(new TitledBorder("색상"));
		panel1.setBounds(20, 60, 200, 60);
		this.add(panel1);

		for (int i = 0; i < rb.length; i++) {
			rb[i] = new JRadioButton(str1[i]);
			rb[i].setBounds(xpos, 50, 100, 30);

			xpos += 80;
			rb[i].addItemListener(this);
			rb[i].setOpaque(false);
			bg.add(rb[i]);
			panel1.add(rb[i]);
			panel1.setOpaque(false);
		}

		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder("내가 가본나라"));
		panel2.setBounds(20, 130, 250, 60);
		panel2.setOpaque(false);
		this.add(panel2);

		String[] str2 = { "미국", "중국", "일본", "러시아" };
		for (int i = 0; i < cbNara.length; i++) {
			cbNara[i] = new JCheckBox(str2[i]);
			cbNara[i].setOpaque(false);
			cbNara[i].addItemListener(this);
			panel2.add(cbNara[i]);
		}

		panel3 = new JPanel();
		panel3.setBounds(20, 200, 400, 60);
		panel3.setBorder(new LineBorder(Color.BLACK, 5));
		panel3.setOpaque(true);

		lblResult = new JLabel();
		lblResult.setHorizontalAlignment(JLabel.CENTER);

		lblResult.setFont(new Font("맑은 고딕", Font.BOLD, 20));

		panel3.add(lblResult);
		this.add(panel3);

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();

		for (int i = 0; i < rb.length; i++) {
			if (rb[i].isSelected()) {
				panel3.setBackground(colors[i]);

			}
		}

		String s = "내가 가본나라는";
		int select = 0;
		for (int i = 0; i < cbNara.length; i++) {
			if (cbNara[i].isSelected()) {
				s += "[" + cbNara[i].getText() + "]";
				select++;
			}
		}
		if (select == 0) {
			s += " 없습니다.";
		} else {
			s += " 입니다.";
		}
		lblResult.setText(s);

		if (ob == cbGender) {
			if (cbGender.isSelected()) {
				lblResult.setText("남자입니다.");
			} else {
				lblResult.setText("여자입니다.");
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Joomal("주말과제!!!");
	}

}