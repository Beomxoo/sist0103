package day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracleDb.DbConnect;

public class QuizStuInfo {

	DbConnect db = new DbConnect();

	// insert 메소드
	public void insert() {
		Scanner sc = new Scanner(System.in);
		String name, gender, age, hp;
		String sql = "";

		System.out.println("이름을 입력해주세요.");
		name = sc.nextLine();
		System.out.println("성별을 입력해주세요.");
		gender = sc.nextLine();
		System.out.println("나이를 입력해주세요.");
		age = sc.nextLine();
		System.out.println("전화번호를 입력해주세요.");
		hp = sc.nextLine();

		sql = "insert into stuinfo values (seq_info.nextval,'" + name + "','" + gender + "','" + age + "','" + hp
				+ "', sysdate)";

		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("데이터가 정상적으로 추가되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	// select 검색메소드
	public void select() {
		String sql = "select * from stuinfo order by s_name";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("***학생 정보 전체 검색 결과***");
			System.out.println();
			System.out.println("번호\t이름\t성별\t나이\t연락처\t가입일");
			System.out.println("======================================================================");

			while (rs.next()) {

				System.out.println(rs.getInt("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("s_gender")
						+ "\t" + rs.getInt("s_age") + "\t" + rs.getString("s_hp") + "\t" + rs.getDate("gaipday"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		System.out.println(sql);
		System.out.println("정상적으로 검색되었습니다.");

	}

	// delete 삭제메소드
	public void delete() {
		Scanner sc = new Scanner(System.in);
		String num;
		String sql = "";

		System.out.println("삭제할 번호를 입력해주세요.");
		num = sc.nextLine();

		sql = "delete from stuinfo where s_no=" + num;

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql);

			if (a == 0) {
				System.out.println("삭제할 데이터가 없습니다.");
			} else {
				System.out.println("데이터가 삭제되었습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		System.out.println(sql);

	}

	// 수정하려는 데이터 조회 메소드
	public boolean getOnData(String num) {

		boolean flag = false;
		String sql = "select * from stuinfo where s_no=" + num;

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		System.out.println(sql);

		return flag;

	}

	// update 메소드
	public void update() {
		Scanner sc = new Scanner(System.in);

		String num, name, gender, age, hp;

		System.out.println("수정할 번호를 입력해주세요!");
		num = sc.nextLine();

		if (!this.getOnData(num)) {
			System.out.println("해당번호는 존재하지 않습니다.");
			return;
		}

		System.out.println("변경할 학생명을 입력해주세요!");
		name = sc.nextLine();
		System.out.println("변경할 성별을 입력해주세요!");
		gender = sc.nextLine();
		System.out.println("변경할 나이를 입력해주세요!");
		age = sc.nextLine();
		System.out.println("변경할 연락처를 입력해주세요!");
		hp = sc.nextLine();

		String sql = "update stuinfo set s_name = '" + name + "', s_gender = '" + gender + "', s_age = '" + age
				+ "' , s_hp= '" + hp + "' where s_no = " + num;

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql);

			if (a == 0) {
				System.out.println("수정할 데이터가 없습니다.");
			} else {
				System.out.println("정상적으로 수정되었습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
		System.out.println(sql);

	}

	// 학생검색 메소드
	public void stuSelect() {
		Scanner sc = new Scanner(System.in);
		String stuName;

		System.out.println("검색할 학생명을 입력해주세요.");
		stuName = sc.nextLine();

		String sql = "select * from stuinfo where s_name like '%" + stuName + "%' order by s_name";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("***학생 검색 결과 출력***");
			System.out.println();
			System.out.println("번호\t이름\t성별\t나이\t연락처\t가입일");
			System.out.println("======================================================================");

			while (rs.next()) {

				System.out.println(rs.getInt("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("s_gender")
						+ "\t" + rs.getInt("s_age") + "\t" + rs.getString("s_hp") + "\t" + rs.getDate("gaipday"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		System.out.println(sql);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizStuInfo qsi = new QuizStuInfo();
		Scanner sc = new Scanner(System.in);
		int n;

		while (true) {

			System.out.println("1.학생정보입력     2.정보출력     3.정보삭제     4.학생정보수정     5.학생검색     9.종료");
			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				qsi.insert();
			} else if (n == 2) {
				qsi.select();
			} else if (n == 3) {
				qsi.delete();
			} else if (n == 4) {
				qsi.update();
			} else if (n == 5) {
				qsi.stuSelect();
			} else if (n == 9) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}

	}

}
