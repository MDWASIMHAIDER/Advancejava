package jdbcPropertyWithStatement;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class FlexibleTest {

	public static void main(String[] args) {
		InputStream is=null;
		Properties ps=null;
		Connection con=null;
		String driver=null;
		String url=null;
		String user=null;
		String pwd=null;
		try {
			System.out.println("started");
			is=new FileInputStream("src/com/nt/commons/dbDetails.properties");
			ps=new Properties();
			ps.load(is);
			//ps.setProperty("url","oracle.jdbc.driver.OracleDriver");
			driver=ps.getProperty("driver");
			url=ps.getProperty("url");
			user=ps.getProperty("username");
			pwd=ps.getProperty("password");
			System.out.println(driver+" "+url+" "+user+" "+pwd);
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, pwd);
			if(con!=null)
			System.out.println("connncetion established");
		}
		catch(Exception e) {}
	}

}
