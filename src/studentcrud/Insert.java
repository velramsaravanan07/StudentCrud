package studentcrud;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class Insert {

		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			Scanner s = new Scanner(System.in);
			int count=1;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/collegestudent","root","root");
			PreparedStatement pstmt=con.prepareStatement("INSERT INTO schoolstud (id, name, city,class,percentage) VALUES (?, ?, ?,?,?)");
			
			while(count<=10) {
				System.out.println("entert the id");
				int sid=s.nextInt();
				System.out.println("entert the name");
				String sname=s.next();
				System.out.println("entert the city");
				String scity=s.next();
				 System.out.println("entert the class");
				int sclass=s.nextInt();
				System.out.println("entert the percentage");
				int sper=s.nextInt();
				count++;
				pstmt.setInt(1, sid);
				pstmt.setString(2,sname);
				pstmt.setString(3,scity);
				pstmt.setInt(4, sclass);
				pstmt.setInt(5, sper);
				pstmt.executeUpdate();
			}	
	
	con.close();
		}
	}


