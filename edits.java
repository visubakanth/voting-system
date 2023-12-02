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
 * Servlet implementation class edits
 */
@WebServlet("/edits")
public class edits extends HttpServlet {
	private static final String query="UPDATE register SET name=?,fathername=?,dob=?,gender=?,adharnumber=?,address=?,nation=? WHERE id=?";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edits() {
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
		String nam=request.getParameter("name");
		String fnam=request.getParameter("fathername");
		String date=request.getParameter("dob");
		String gen=request.getParameter("gender");
		String adhar=request.getParameter("adharnumber");
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
			ps.setString(4, gen);
			ps.setString(5, adhar);
			ps.setString(6, add);
			ps.setString(7, nation);
			ps.setInt(8, id);
			
			int count=ps.executeUpdate();
			if(count==1) {
				out.print("successfull");
			}
			else {
				out.print("notsuccessfull");
				
			}
	
		}catch(SQLException e) {
			e.printStackTrace();
			out.println("<h1>"+e.getMessage()+"</h1>");
		}catch(Exception ex) {
			ex.printStackTrace();
			out.println("<h1>"+ex.getMessage()+"</h1>");
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
