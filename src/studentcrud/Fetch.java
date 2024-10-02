package studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Fetch {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the class:");
        int sclass = sc.nextInt();

        System.out.println("Enter the percentage:");
        int percen = sc.nextInt();

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collegestudent?user=root&password=root");

        String query = "SELECT * FROM schoolstud WHERE class=? AND percentage>=?";
        PreparedStatement pstmt = con.prepareStatement(query);

        pstmt.setInt(1, sclass);
        pstmt.setInt(2, percen);

        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getInt(4) + " " + rs.getInt(5));
        }

        con.close();
        sc.close();
    }
}