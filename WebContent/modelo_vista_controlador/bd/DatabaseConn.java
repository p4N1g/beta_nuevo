package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConn {

	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://oraclepr.uco.es:3306/basedatos", "usuario", "passwd");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
