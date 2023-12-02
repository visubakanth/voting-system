package java1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final String query="DELETE FROM register WHERE id=?";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException cf) {
			cf.printStackTrace();
		}
		try(Connection con=DriverManager.getConnection("jdbc:mysql:///voting","root","visu2001");
		   PreparedStatement ps=con.prepareStatement(query);){
			ps.setInt(1, id);
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
