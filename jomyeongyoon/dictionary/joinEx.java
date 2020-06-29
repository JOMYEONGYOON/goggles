package dictionary;



import java.sql.Connection;
import java.sql.DriverManager;;

public class joinEx 	{
	public static void main(String[] args) {
		getConnection();
		
	}
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/dictionary?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true";
			String id = "root";
			String password = "1234";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,id,password);
			System.out.println("연결완료");
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
		
	}
	
	
	
	
	
}

