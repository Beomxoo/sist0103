package day0130;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import oracleDb.DbConnect;

public class SwingJdbcScore extends JFrame implements ActionListener {
	DbConnect db = new DbConnect();
	Container cp;

	DefaultTableModel model;
	JTable table;
	JButton btnAdd, btnDel, btnUpdate;

	AddStuInfo addForm = new AddStuInfo("성적추가");
	UpdateStuInfo updateForm = new UpdateStuInfo("데이터수정");

	public SwingJdbcScore(String title) {
		super(title);
		cp = this.getContentPane();
		this.setBounds(200, 100, 400, 300);
		cp.setBackground(new Color(250, 250, 200));
		initDesin();
		this.setVisible(true);
	}

	// 테이블에 출력하는 메서드
	public void tableWrite() {
		// 테이블초기화
		model.setRowCount(0);

		// db연결
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from stuinfo0130 order by num";

		conn = db.getOracle();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				Vector<String> data = new Vector<String>();

				// String형태로 담기
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("ban"));
				data.add(rs.getString("java"));
				data.add(rs.getString("jsp"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("total"));
				data.add(rs.getString("average"));

				// 테이블에 추가
				model.addRow(data);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

	}

	// insert
	public void insertData() {
		String name = addForm.tfName.getText();
		String java = addForm.tfJava.getText();
		String jsp = addForm.tfJsp.getText();
		String spring = addForm.tfSpring.getText();
		String ban = (String) addForm.cbBan.getSelectedItem();

		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double avg = tot / 3.0;

		String sql = "insert into stuinfo0130 values (seq1.nextval, ?, ?, ?, ?, ?, ?, ?)";

		// db연결.sql문전송
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// ?순서대로 바인딩
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, avg);
			pstmt.setString(7, ban);

			// 업데이트
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// 삭제
	public void deleteData(String num) {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		String sql = "delete from stuinfo0130 where num=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			int n = pstmt.executeUpdate();

			if (n == 1) {
				JOptionPane.showMessageDialog(this, "추가 완료");
				this.tableWrite();
			} else {
				JOptionPane.showMessageDialog(this, "해당 번호가 존재하지 않습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 수정
	public void updateData() {

		String name = updateForm.tfName.getText();
		String java = updateForm.tfJava.getText();
		String jsp = updateForm.tfJsp.getText();
		String spring = updateForm.tfSpring.getText();
		String ban = (String) updateForm.cbBan.getSelectedItem();

		int tot = Integer.parseInt(java) + Integer.parseInt(jsp) + Integer.parseInt(spring);
		double average = tot / 3.0;

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		String sql = "update stuinfo0130 set name=?, java=?, jsp=?, spring=?, total=?, average=?, ban=? where num= ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, average);
			pstmt.setString(7, ban);
			pstmt.setString(8, updateForm.num);

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}

	}

	// 디자인
	public void initDesin() {
		String[] title = { "번호", "이름", "반", "Java", "Jsp", "Spring", "총점", "평균" };

		// 처음에 title,0 0으로 두고 시작
		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		this.add("Center", new JScrollPane(table));

		// 테이블d에 db데이터를 출력
		tableWrite();

		JPanel pTop = new JPanel();
		this.add("North", pTop);

		// 추가버튼
		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);

		// 추가폼에 있는 추가버튼에 액션 추가
		addForm.btnAdd.addActionListener(this);
		// 수정폼에 있는 수정버튼에 액션 추가
		updateForm.btnMod.addActionListener(this);

		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if (ob == btnAdd) {
			// 실제 코드는 여기서....
			addForm.setVisible(true);

		} else if (ob == addForm.btnAdd) { // 학생추가폼의 버튼이벤트
			// 입력하는 데이터를 읽어서 db추가
			insertData(); // db에 들어간거 확인

			// 테이블 다시 출력
			this.tableWrite();

			// 초기화 하면서 추가폼은 사라지게
			addForm.tfName.setText("");
			addForm.tfJava.setText("");
			addForm.tfJsp.setText("");
			addForm.tfSpring.setText("");
			addForm.setVisible(false);

		} else if (ob == btnDel) {
			String num = JOptionPane.showInputDialog(this, "삭제할 시퀀스를 입력해 주세요.");
			deleteData(num);

		} else if (ob == btnUpdate) {
			String num = JOptionPane.showInputDialog(this, "수정할 시퀀스를 입력해 주세요.");

			// 수정할 데이터를 띄워주는 메서드
			String sql = "select * from stuinfo0130 where num=" + num;

			Connection conn = db.getOracle();
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			try {
				pstmt = conn.prepareStatement(sql); // 바인딩
				rs = pstmt.executeQuery(); // 실행

				// 데이터 하나 조회 if
				if (rs.next()) {
					updateForm.num = num;
					updateForm.tfName.setText(rs.getString("name"));
					updateForm.tfJava.setText(rs.getString("java"));
					updateForm.tfJsp.setText(rs.getString("jsp"));
					updateForm.tfSpring.setText(rs.getString("spring"));
					updateForm.cbBan.setSelectedItem(rs.getString("ban"));

					updateForm.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this, "해당번호는 없습니다.");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				db.dbClose(rs, pstmt, conn);
			}
			

		} else if (ob==updateForm.btnMod) {
			updateData();
			this.tableWrite();
			JOptionPane.showMessageDialog(this, "수정되었습니다.");
			updateForm.setVisible(false);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubㄴ
		new SwingJdbcScore("학생성적관리DB");
	}

}
