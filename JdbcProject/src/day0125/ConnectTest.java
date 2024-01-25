package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class ConnectTest {

	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; // 전역

	public void connectSawon() {
		// 초기값 없으므로 null 설정
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon order by num";

		try {
			conn = DriverManager.getConnection(URL, "teacher", "a1234");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql); // 1줄만 가져옴

			// 여러줄을 가져올때는 while문으로 가져온다
			// rs.next() : 다음데이터로 이동하면서 true반환, 더이상 데이터가 없으면 false 반환
			while (rs.next()) {
				// db로 부터 데이터 가져오기
				int num = rs.getInt("num");
				// int num = rs.getInt(1); 컬럼순서로도 가능
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				String buseo = rs.getString("buseo");
				int pay = rs.getInt("pay");

				System.out.println(num + "\t" + name + "\t" + gender + "\t" + buseo + "\t" + pay);

			}

			System.out.println("오라클 드라이버 연결 성공!!!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("오라클 드라이버 연결 실패...");
		} finally {
			{
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	public void connectShop() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select idx,c.num,sangpum,color,cnt,guipday from shop s,cart2 c where s.num=c.num";

		try {
			conn = DriverManager.getConnection(URL, "teacher", "a1234");
			System.out.println("오라클성공!!!");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("**회원 장바구니 리스트**");

			System.out.println("주문번호\t상품번호\t상품명\t색상\t구입갯수\t구입날짜");
			System.out.println("------------------------------------------");

			while (rs.next()) {
				int idx = rs.getInt("idx");
				int num = rs.getInt("num");
				String sang = rs.getString("sangpum");
				String color = rs.getString("color");
				int cnt = rs.getInt("cnt");
				String guipday = rs.getString("guipday");

				System.out.println(idx + "\t" + num + "\t" + sang + "\t" + color + "\t" + cnt + "\t" + guipday);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클실패!!!");
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void sawonRead() {
		// 부서별 인원수 평균급여
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select buseo, count(*) cnt,round(avg(pay),0) pay from sawon group by buseo";

		try {
			conn = DriverManager.getConnection(URL, "teacher", "a1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("**부서별 평균 인원 및 급여 구하기**");
			System.out.println();
			System.out.println("부서명\t인원수\t평균급여");
			System.out.println("----------------------------");

			while (rs.next()) {

				String buseo = rs.getString("buseo");
				int count = rs.getInt("cnt");
				int pay = rs.getInt("pay");

				System.out.println(buseo + "\t" + count + "명\t" + pay + "원");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void foodRead() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		String sql = "select order_num,f.fno, order_name, food_name, price, food_shopname , shop_loc, order_addr from foodshop f, jumun j where f.fno = j.fno order by order_name";

		try {
			conn = DriverManager.getConnection(URL, "teacher", "a1234");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			System.out.println("***배달의민족 주문내역***");
			System.out.println();
			System.out.println("주문번호\t음식번호\t주문자\t음식명\t가격\t상호명\t상점위치\t주문자위치");
			System.out.println("-------------------------------------------------------------------------");

			while (rs.next()) {

				int order_num = rs.getInt("order_num");
				int fno = rs.getInt("fno");
				String order_name = rs.getString("order_name");
				String food_name = rs.getString("food_name");
				int price = rs.getInt("price");
				String food_shopname = rs.getString("food_shopname");
				String shop_loc = rs.getString("shop_loc");
				String order_addr = rs.getString("order_addr");

				DecimalFormat df = new DecimalFormat("###,###");

				System.out.println(order_num + "\t" + fno + "\t" + order_name + "\t" + food_name + "\t"
						+ df.format(price) + "원\t" + food_shopname + "\t" + shop_loc + "\t" + order_addr);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectTest ct = new ConnectTest();
		// ct.connectSawon();
		// ct.connectShop();
		// ct.sawonRead();
		ct.foodRead();
	}

}
