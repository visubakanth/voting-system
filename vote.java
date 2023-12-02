package java1;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Servlet implementation class vote
 */
@WebServlet("/vote")
public class vote extends HttpServlet {
	private static final  String query="INSERT INTO register(name,fathername,dob,gender,adharnumber,address,nation) VALUES(?,?,?,?,?,?,?)";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vote() {
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
		String gender=request.getParameter("gender");
		String adharnum=request.getParameter("adharnumber");
		String add=request.getParameter("address");
		String nation=request.getParameter("nation");
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
			ps.setString(4, gender);
			ps.setString(5, adharnum);
			ps.setString(6, add);
			ps.setString(7, nation);
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
