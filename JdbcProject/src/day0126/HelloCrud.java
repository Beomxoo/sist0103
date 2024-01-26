package day0126;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracleDb.DbConnect;

public class HelloCrud {

	DbConnect db = new DbConnect();

	public void insert() {
		Scanner sc = new Scanner(System.in);
		String name, addr;
		String sql = ""; // 여기에 sql문을 먼저 작성하면 안들어감 입력후에 작성해야함
		System.out.println("이름을 입력하세요");
		name = sc.nextLine();
		System.out.println("주소를 입력하세요");
		addr = sc.nextLine();

		sql = "insert into hello values (seq1.nextval,'" + name + "','" + addr + "', sysdate)";
		System.out.println(sql);

		// 1.db연결
		Connection conn = null;
		// 2.statement
		Statement stmt = null; // sql문 객체 전송에 필요한 API

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();

			// 3.sql문실행
			stmt.execute(sql); // executeUpdate는 반환값이 int임 조건줄때 좋음 execute는 반환값 boolean
			System.out.println("** 데이터 추가됨**");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public void select() {

		// String sql = "select seq7.nextval num, name, addr, sdate from hello order by
		// num";
		String sql = "select * from hello";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // select문 요청 executeQuery

			System.out.println("***검색 결과***");
			System.out.println();
			System.out.println("시퀀스\t이름\t주소\t가입날짜");

			while (rs.next()) { // 2개이상 데이터 검색시 while문 사용
				// int num = rs.getInt("num");
				// String name = rs.getString("name");
				// String addr = rs.getString("addr");
				// String sdate = rs.getString("sdate");
				System.out.println(rs.getInt("num") + "\t" + rs.getString("name") + "\t" + rs.getString("addr") + "\t"
						+ rs.getDate("sdate"));

				// System.out.println(num + "\t" + name + "\t" + addr + "\t" + sdate);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, stmt, conn);
		}
		System.out.println("***정상적으로 검색되었습니다.***");
		System.out.println(sql);

	}

	public void delete() {
		// 삭제할 번호 입력후 삭제
		Scanner sc = new Scanner(System.in);
		String num;
		String sql = "";
		System.out.println("삭제할 번호 입력");
		num = sc.nextLine();

		sql = "delete from hello where num=" + num;
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();
		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql); // 성공한 레코드의 갯수

			// 없는번호 입력시 실제 삭제가 안되므로 0이 반환
			if (a == 0) {
				System.out.println("없는 데이터 번호입니다.");
			} else {
				System.out.println("***삭제되었습니다.***");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}
	}
	
	
	//수정하려는 데이터 조회 메소드
	public boolean getOneData(String num) { //있다없다를 반환해야 하므로 반환값 boolean
		
		boolean flag = false; // num에 해당하는 데이터가 있으면 true, 없으면 false 반환
		String sql ="select * from hello where num="+num;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = db.getOracle();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			//한개만 조회할경우는 if문
			if(rs.next()) { //데이터가 있는경우
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
		
		
		return flag;
	}
	

	// 수정
	public void update() {
		// 수정할 시퀀스를 입력후 이름,주소 입력
		Scanner sc = new Scanner(System.in);
		String num, name, addr;

		System.out.println("수정할 번호를 입력해주세요");
		num = sc.nextLine();
		
		if(!this.getOneData(num)){//this는 넣어도 되고 안넣어도됨
			System.out.println("해당번호는 존재하지 않습니다.");
			return; //메소드 종료
		} 

		System.out.println("수정할 이름을 입력해주세요");
		name = sc.nextLine();
		System.out.println("수정할 주소를 입력해주세요");
		addr = sc.nextLine();

		String sql = "update hello set name ='" + name + "', addr='" + addr + "'where num=" + num;
		//update hello set name ='김범수', addr='서울시 동작구'where num=1
		//  " + name + "  => 결합               
		System.out.println(sql);

		Connection conn = null;
		Statement stmt = null;

		conn = db.getOracle();

		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql);

			if (a == 0) {
				System.out.println("수정할 데이터가 존재하지 않습니다.");
			} else {
				System.out.println("수정 되었습니다.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(stmt, conn);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloCrud hello = new HelloCrud();

		Scanner sc = new Scanner(System.in);
		int n;

		while (true) {
			System.out.println("**hello db 연습**");
			System.out.println("1.insert\t2.select\t3.delete\t4.update\t9.exit");

			n = Integer.parseInt(sc.nextLine());

			if (n == 1) {
				hello.insert();
			} else if (n == 2) {
				hello.select();
			} else if (n == 3) {
				hello.delete();
			} else if (n == 4) {
				hello.update();
			}else if (n == 9) {
				System.out.println("종료할게요~~~");
				break;
			}
		}

	}

}
