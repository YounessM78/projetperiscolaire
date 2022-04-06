package vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Statement;

public class login {
	
	Connection cnx = null;
	ResultSet Rs = null;
	PreparedStatement ps=null;
	
	public static Connection ConnectDB() {
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cnx=DriverManager.getConnection("jdbc:odbc:Database","", "");
			return cnx;
		}
		
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
	}

}
