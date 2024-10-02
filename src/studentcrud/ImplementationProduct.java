package studentcrud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImplementationProduct {

    private Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/collegestudent", "root", "root");
    }

    public int insert(Product p) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO product (id, brand, price, discount) VALUES (?, ?, ?, ?)";
        try (Connection con = getConnection(); 
        		PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, p.getId());
            pstmt.setString(2, p.getBrand());
            pstmt.setDouble(3, p.getPrice());
            pstmt.setDouble(4, p.getDiscount());
            return pstmt.executeUpdate();
        }
    }

    public int delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM product WHERE id = ?";
        try (Connection con = getConnection(); 
        		PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            return pstmt.executeUpdate();
        }
    }

    public Product fetchdata(int id) throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM product WHERE id = ?";
        try (Connection con = getConnection(); 
        		PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
                }
            }
        }
        return null;
    }

    public List<Product> fetchAll() throws ClassNotFoundException, SQLException {
        String query = "SELECT * FROM product";
        List<Product> productList = new ArrayList<>();
        try (Connection con = getConnection(); 
        		Statement st = con.createStatement(); 
        		ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4));
                productList.add(p);
            }
        }
        return productList;
    }
}
