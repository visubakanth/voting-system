package java1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.sql.DriverManager;
import java.sql.Connection;
import java.io.PrintWriter;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class canditate
 */
@WebServlet("/canditate")
public class canditate extends HttpServlet {
	private static final String query="INSERT INTO canditate(name,fathername,dob,party,image)VALUES(?,?,?,?,?)";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public canditate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String nam=request.getParameter("name");
		String fnam=request.getParameter("fathername");
		String date=request.getParameter("dob");
		String par=request.getParameter("party");
		String ar=request.getParameter("area");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cf) {
			cf.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///voting","root","visu2001");
		   PreparedStatement ps=con.prepareStatement(query);){
			ps.setString(1, nam);
			ps.setString(2, fnam);
			ps.setString(3, date);
			ps.setString(4, par);
			ps.setString(5, ar);
			
			
			int count=ps.executeUpdate();
			if(count==1) {
				pw.println("succesfull");
				
			}
			else {
				pw.println("notsuccesfull");
			}
			   
		   }catch(SQLException se) {
			   se.printStackTrace();
			   pw.println(se.getMessage());
		   }catch(Exception e) {
			   e.printStackTrace();
			   pw.println(e.getMessage());
		   }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
