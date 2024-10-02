package studentcrud;

import java.sql.SQLException;

public class UserMain {	
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	ImplUser implu=new ImplUser();
	
	implu.saveuserf(new User("smith", "smith@gmail"));
	implu.saveuserf(new User("Dhana", "chan@gmail"));
	implu.saveuserf(new User("Chan", "dhan @gmail"));
	
}
}
