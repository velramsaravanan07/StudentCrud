package studentcrud;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindMax {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegestudent?user=root&password=root");
		CallableStatement cst =con.prepareCall("call collegestudent.maxper()");
		ResultSet rs=cst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString(1));
		}
		rs.close();
		con.close();
		cst.close();

	}

}
