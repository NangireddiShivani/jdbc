package dianamic;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.util.Scanner;
	
	
	public class droptable {
		private static final String Driver = "com.mysql.cj.jdbc.Driver";		
		private static final String username = "root";
		private static final String password = "root";
		public static void main(String[] args) {
			
			try {
				Scanner sc = new Scanner(System.in);
				System.out.println("enter the database name :");
				String url ="jdbc:mysql://localhost:3306/"+sc.next();
				
				Class.forName(Driver);
				
				Connection conn = DriverManager.getConnection(url,username,password);
				System.out.println("Enter the table name");
				String name="drop table " +sc.next() ;
				
				PreparedStatement pmst = conn.prepareStatement(name); 
				
				int i = pmst.executeUpdate();
				
				if (i==0) {
					System.out.println("table deleted");
				}
				else {
					System.out.println("table not deleted");
				}
				conn.close();
				pmst.close();

				
				} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}