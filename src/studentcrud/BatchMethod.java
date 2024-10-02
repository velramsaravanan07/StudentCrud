package studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.sql.*;

public class BatchMethod {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegestudent?user=root&password=root");
		Statement st=con.createStatement();
         st.addBatch("insert into student values(1,'surya','surya@gmail.com')");
         st.addBatch("update student set gmail='sandy@gmail.com' where id=678");
         st.addBatch("delete from student where id=123");
         int[] a=st.executeBatch();
         System.out.println(Arrays.toString(a));
         con.close();
	}

}