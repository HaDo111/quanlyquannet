package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class cosoo {

	 public static Connection cn;
     public void KetNoi() {
    	 try {
    		 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		 
    		 String st=
    				   "jdbc:sqlserver://ADMIN\\SQLEXPRESS:1433;databaseName=qlqn; user=sa; password=123";
    				    		 cn=DriverManager.getConnection(st);
    				   
		} catch (Exception e) {
			e.printStackTrace();
		}
     }
	public static void main(String[] args) {
		cosoo cs= new cosoo();
		cs.KetNoi();
	}
}
