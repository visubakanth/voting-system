package java1;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Logindao
 */
@WebServlet("/Logindao")
public class Logindao {
	public static boolean validate(String name,String adhar) {
		boolean status=false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/voting","root","visu2001");
		PreparedStatement ps=con.prepareStatement("select * from register where name=? and adharnumber=?" );
		ps.setString(1, name);
		ps.setString(2,adhar);
		ResultSet rs=ps.executeQuery();
		status=rs.next();
		
		}catch(Exception e) {
			System.out.println(e);
		}return status;

}}
