package studentcrud;

import java.sql.SQLException;

public interface StudentImple {
	void add(Student student) throws SQLException, ClassNotFoundException;
    void getData();
    void update(int id, String newName); 
    void iddelete(int id);
    void delete(String tablename);
    void displaytablename();
}
