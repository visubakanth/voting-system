package java2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java1.Logindao;

/**
 * Servlet implementation class admin1
 */
@WebServlet("/admin1")
public class admin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin1() {
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
		String nam=request.getParameter("name");
		String adhar=request.getParameter("adharnumber");
		if(Logindao.validate(nam, adhar)) {
			RequestDispatcher rd=request.getRequestDispatcher("admin.html");
			rd.forward(request,response);
		}
		else {
			out.print("sorry username or password error");
			RequestDispatcher rd=request.getRequestDispatcher("election.html");
			rd.forward(request,response);
		}
		out.close();
			
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
