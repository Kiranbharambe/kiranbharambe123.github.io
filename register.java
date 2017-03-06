package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PhoneNo = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pr=response.getWriter();
		
		String f=request.getParameter("FirstName");
		String l=request.getParameter("LastName");
		String e=request.getParameter("Email");
		String ph=request.getParameter("PhoneNo");
		String lo=request.getParameter("Location");
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49178;database=kiran;integratedSecurity=true");
			PreparedStatement ps=con.prepareStatement("insert into user_detail1 values(?,?,?,?,?)");
			
			ps.setString(1, f);
			ps.setString(2, l);
			ps.setString(3, e);
			ps.setString(4, ph);
			ps.setString(5, lo);
			int i=ps.executeUpdate();
			if(i>0)
			{
				pr.print("registered");
			}
			
			
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
	
		pr.close();
	}

}
