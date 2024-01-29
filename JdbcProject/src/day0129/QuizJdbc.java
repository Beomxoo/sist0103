package day0129;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

import oracleDb.DbConnect;

public class QuizJdbc {

	DbConnect db = new DbConnect();
	Scanner sc = new Scanner(System.in);

	// 데이터 추가 메서드
	public void insertMember() {

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("사원명을 입력해주세요.");
		String name = sc.nextLine();
		System.out.println("부서를 입력해주세요.");
		String buseo = sc.nextLine();
		System.out.println("직급을 입력해주세요.");
		String position = sc.nextLine();
		System.out.println("성별을 입력해주세요.");
		String gender = sc.nextLine();
		System.out.println("월급여를 입력해주세요.");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스를 입력해주세요.");
		int bonus = Integer.parseInt(sc.nextLine());

		String sql = "insert into sawonmember values (seq_smem.nextval, ?,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, buseo);
			pstmt.setString(3, position);
			pstmt.setString(4, gender);
			pstmt.setInt(5, pay);
			pstmt.setInt(6, bonus);

			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		System.out.println("데이터가 추가되었습니다.");
		System.out.println();

	}

	// 전체출력 메서드
	public void writeMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select s_no, s_name, buseo,position,gender, pay ,bonus,ipsaday from sawonmember order by s_no";

		System.out.println("\t\t**전체 사원 정보 출력**");
		System.out.println();
		System.out.println("사원번호\t사원명\t부서\t직급\t성별\t월급여\t\t보너스\t\t입사날짜");
		System.out.println("---------------------------------------------------------------------------------");

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				DecimalFormat decimalFormat = new DecimalFormat("###,###");

				String pay = decimalFormat.format(rs.getInt("pay"));
				String bonus = decimalFormat.format(rs.getInt("bonus"));

				System.out.println(rs.getInt("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("buseo")
						+ "\t" + rs.getString("position") + "\t" + rs.getString("gender") + "\t" + pay + "원\t" + bonus
						+ "원\t" + rs.getDate("ipsaday"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		System.out.println();

	}

	// 삭제메서드
	public void deleteMember() {

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("삭제할 사원번호를 입력해주세요.");
		int num = Integer.parseInt(sc.nextLine());

		String sql = "delete from sawonmember where s_no =?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);

			int a = pstmt.executeUpdate();
			if (a == 1) {
				System.out.println("해당 사원정보가 삭제되었습니다.");
			} else {
				System.out.println(num + "번 사원은 존재하지 않습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		System.out.println();

	}

	// 수정하기전에 검색메서드
	public boolean isOneData(String num) {

		boolean flag = false;

		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawonmember where s_no=? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}

		return flag;

	}

	// 수정메서드
	public void updateMember() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;

		System.out.println("수정할 사원번호를 입력해주세요.");
		String num = sc.nextLine();
		if (!this.isOneData(num)) {
			System.out.println("해당 사원번호는 존재하지 않습니다.");
			System.out.println();
			return;
		}

		System.out.println("부서를 입력해주세요.");
		String buseo = sc.nextLine();
		System.out.println("직급을 입력해주세요.");
		String position = sc.nextLine();
		System.out.println("급여를 입력해주세요.");
		int pay = Integer.parseInt(sc.nextLine());
		System.out.println("보너스를 입력해주세요.");
		int bonus = Integer.parseInt(sc.nextLine());

		String sql = "update sawonmember set buseo=?, position=?, pay=?, bonus=? where s_no=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buseo);
			pstmt.setString(2, position);
			pstmt.setInt(3, pay);
			pstmt.setInt(4, bonus);
			pstmt.setString(5, num);

			int b = pstmt.executeUpdate();

			if (b == 1) {
				System.out.println("정상적으로 수정되었습니다.");
			} else {
				System.out.println("해당 사원번호는 존재하지 않습니다.");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();

	}

	// 사원이름검색
	public void searchName() {
		Connection conn = db.getOracle();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println("검색할 이름을 입력해주세요.[일부도 가능]");
		String name = sc.nextLine();

		String sql = "select s_no, s_name, buseo,position,gender, pay ,bonus,ipsaday from sawonmember where s_name like ? order by s_no";

		System.out.println("\t\t**검색한 사원 정보 출력**");
		System.out.println();
		System.out.println("사원번호\t사원명\t부서\t직급\t성별\t월급여\t\t보너스\t\t입사날짜");
		System.out.println("---------------------------------------------------------------------------------");
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();

			while (rs.next()) {

				DecimalFormat decimalFormat = new DecimalFormat("###,###");

				String pay = decimalFormat.format(rs.getInt("pay"));
				String bonus = decimalFormat.format(rs.getInt("bonus"));

				System.out.println(rs.getInt("s_no") + "\t" + rs.getString("s_name") + "\t" + rs.getString("buseo")
						+ "\t" + rs.getString("position") + "\t" + rs.getString("gender") + "\t" + pay + "원\t" + bonus
						+ "원\t" + rs.getDate("ipsaday"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	// 실행메서드
	public void process() {

		while (true) {

			System.out.println("1.사원정보입력    2.전체사원출력    3.사원삭제    4.사원수정   5.이름검색    9.시스템종료");
			int num = Integer.parseInt(sc.nextLine());

			if (num == 1) {
				this.insertMember();
			} else if (num == 2) {
				this.writeMember();
			} else if (num == 3) {
				this.deleteMember();
			} else if (num == 4) {
				this.updateMember();
			} else if (num == 5) {
				this.searchName();
			} else if (num == 9) {
				System.out.println("프로그램을 종료합니다!!!");
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizJdbc qz = new QuizJdbc();
		qz.process();
	}

}
