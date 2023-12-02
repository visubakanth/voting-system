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
 * Servlet implementation class edit
 */
@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final String query="SELECT name,fathername,dob,gender,adharnumber,address,nation FROM register WHERE id=?";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/voting","root","visu2001");
			
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			out.println("<form action='editurl?id="+id+"' method='get'>");
			out.println("<table align='center'>");
			out.println("<tr>");
			out.println("<td>name</td>");
			out.println("<td><input type='text' name='name' value='"+rs.getString("name")+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>fathername</td>");
			out.println("<td><input type='text' name='name' value='"+rs.getString("fathername")+"'></td>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<td>dob</td>");
			out.println("<td><input type='text' name='name' value='"+rs.getString("dob")+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>gender</td>");
			out.println("<td><input type='text' name='name' value='"+rs.getString("gender")+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>adharnumber</td>");
			out.println("<td><input type='text' name='name' value='"+rs.getString("adharnumber")+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>address</td>");
			out.println("<td><input type='text' name='name' value='"+rs.getString("address")+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>nation</td>");
			out.println("<td><input type='text' name='name' value='"+rs.getString("nation")+"'></td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td><input type='submit' value='update'></td>");
			out.println("</tr>");
		
		
			
			out.println("</table>");
			out.println("</form>");
		
	
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
