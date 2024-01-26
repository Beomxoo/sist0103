package day0125;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class QuizConnect {

	static final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; // 전역

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
		QuizConnect ct = new QuizConnect();

		ct.foodRead();
	}

}
