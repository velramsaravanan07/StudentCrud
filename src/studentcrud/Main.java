package studentcrud;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);
		StudentImple si=new Implementation();
		  int choice;

	            System.out.println("=== Student CRUD Operations ===");
	            System.out.println("1. Add Student");
	            System.out.println("2. View All Students");
	            System.out.println("3. Update Student");
	            System.out.println("4. Delete");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	            case 1:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Gmail: ");
                    String gmail = scanner.nextLine();
                    Student student = new Student(id, name, gmail);
                    try {
                        si.add(student);
                    } catch (SQLException e) {
                        
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                       
                        e.printStackTrace();
                    }
                    break;
	                case 2:
	                	System.out.println("All students:");
	                    si.getData();
	                    break;
	                case 3:
	                	 si.getData();
	                	System.out.print("Enter Student ID to update: ");
	                    int updateId = scanner.nextInt();
	                    scanner.nextLine(); 
	                    System.out.print("Enter New Name: ");
	                    String newName = scanner.nextLine();
	                    si.update(updateId, newName);
	                    break;
	                case 4:	                	 
	                	  System.out.println("=== Student Delete Operations ===");
	                	  System.out.println("1. Id Student");
	      	              System.out.println("2. Delete the Students Details from Table");
	      	          System.out.print("Enter your choice: ");
	  	            choice = scanner.nextInt();
	  	            switch(choice) {
	  	            case 1:
	  	            	si.getData();
	  	            	System.out.print("Enter Student ID to Deleted: ");
	                    int deleteId = scanner.nextInt();
	                    scanner.nextLine();
	                    si.iddelete(deleteId);
	  	            case 2:
	  	            	si.displaytablename();
	  	            	System.out.print("Enter the tableName to be deleted: ");
	  	            	String tablename=scanner.next();
	  	            	si.delete(tablename);
	  	            }
	                	  
	}

}
}
