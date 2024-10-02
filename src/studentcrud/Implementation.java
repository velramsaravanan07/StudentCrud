package studentcrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Implementation implements StudentImple {
    private ArrayList<Student> s = new ArrayList<>();

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/collegestudent", "root", "root");
    }

    @Override
    public void add(Student student) {
        if (student == null) {
            System.out.println("Null value cannot be added");
            return;
        }
        
        for (Student stud : s) {
            if (stud.getId() == student.getId()) {
                System.out.println("Student with ID " + student.getId() + " already exists.");
                return;
            }
        }
        
        s.add(student);

        try (Connection con = getConnection();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO student (id, name, gmail) VALUES (?, ?, ?)")) {
            pstmt.setInt(1, student.getId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getGmail());
            pstmt.executeUpdate();
            System.out.println("Student added to database: " + student);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getData() {


        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM student")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, String newName) {

            try (Connection con = getConnection();
                 PreparedStatement pstmt = con.prepareStatement("UPDATE student SET name = ? WHERE id = ?")) {
                pstmt.setString(1, newName);
                pstmt.setInt(2, id);
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Database update completed. Rows affected: " + rowsAffected);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }

    }

    @Override
    public void iddelete(int id) {
       
            try (Connection con = getConnection();
                 PreparedStatement pstmt = con.prepareStatement("DELETE FROM student WHERE id = ?")) {
                pstmt.setInt(1, id);
                int rowsAffected = pstmt.executeUpdate();
                System.out.println("Database deletion completed. Rows affected: " + rowsAffected);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        
    }

    @Override
    public void displaytablename() {
        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SHOW TABLES")) {
            while (rs.next()) {
                String tableName = rs.getString(1);
                System.out.println("Table Name: " + tableName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String tablename) {
        try (Connection con = getConnection();
             Statement st = con.createStatement()) {
            String query = "TRUNCATE TABLE " + tablename;
            st.executeUpdate(query);
            System.out.println("Table " + tablename + " has been truncated.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
