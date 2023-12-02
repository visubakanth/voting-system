package java1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class view
 */
@WebServlet("/view")
public class view extends HttpServlet {
	private static final  String query="SELECT * FROM register";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/voting","root","visu2001");
			
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			out.println("<table  border='5' height='40' >");
			out.print("<tr>");
			out.print("<th>id</th>");
			out.print("<th>name</th>");
			out.print("<th>fathername</th>");
			out.print("<th>dob</th>");
			out.print("<th>gender</th>");
			out.print("<th>adharnumber</th>");
			out.print("<th>address</th>");
			out.print("<th>nation</th>");
			
			
			out.print("</tr>");
		
		
			while (rs.next())
			{
				out.print("<tr>");
				out.print("<td>" +rs.getString("id")+"</td>");
				out.print("<td>" +rs.getString("name")+"</td>");
				out.print("<td>" +rs.getString("fathername")+"</td>");
				out.print("<td>" +rs.getString("dob")+"</td>");
				out.print("<td>" +rs.getString("gender")+"</td>");
				out.print("<td>" +rs.getString("adharnumber")+"</td>");
				out.print("<td>" +rs.getString("address")+"</td>");
				out.print("<td>" +rs.getString("nation")+"</td>");
				
				
		
				
				out.print("</tr>");
				
			}
			out.println("</table>");
		
	
		}catch(SQLException e) {
			e.printStackTrace();
			out.println("<h1>"+e.getMessage()+"</h1>");
		}catch(Exception ex) {
			ex.printStackTrace();
			out.println("<h1>"+ex.getMessage()+"</h1>");
		}
		out.println("<a href='home.html'>home</a>");
		out.println("<a href='admin.html'>back</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
