package studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.Statement;

public class ImplUser {
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/collegestudent", "root", "root");
	}

	public int saveuserf(User u) throws SQLException, ClassNotFoundException {

		String query = "INSERT INTO user (iduser,name,email) VALUES (?, ?, ?)";
		try (Connection con = getConnection(); PreparedStatement pstmt = con.prepareStatement(query)) {
			pstmt.setString(1, getid(u));
			pstmt.setString(2, u.getName());
			pstmt.setString(3, u.getEmail());
			return pstmt.executeUpdate();
		}
	}

	private String getid(User u) throws SQLException, ClassNotFoundException {

		String query = "select count(iduser) from user";
		Connection con = getConnection();
		Statement pstmt = con.createStatement();
		ResultSet rs = pstmt.executeQuery(query);
		rs.next();
		int a = Integer.parseInt(rs.getString(1));
		a++;
		String s = u.getClass().getSimpleName().substring(0, 2);

		String su = s + "_" + three(a + "");
		return su;
	}

	private static String three(String num) {
		while (num.length() <= 3) {
			num = "0" + num;
		}
		return num;

	}
}
//String num = "000";
//int i = 0;
//ImplUser im=new ImplUser();
//String twochar=	im.getClass().getSimpleName().substring(0,2);
//
//while (i < 10) {
//	int a = (Integer.parseInt(num));
//	a++;
//	num = a + "";
//	if (num.length() < 3) {
//		num = three(num,twochar);
//	}
//	System.out.println(num);
//	i++;
//
//}
//
//}
//
//private static String three(String num, String twochar) {
//while (num.length() <4) {
//	num =twochar+ "0" + num;
//}
//return num;
//
//}
