
import java.sql.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class info
 */
@WebServlet("/info")
public class info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://mydatabasetest.ciydcc3zf6bp.us-east-1.rds.amazonaws.com","jrfox9","jfoxherr20?!");
			Statement stmt = con.createStatement();
			String sql = "select * from DBTest.students_info where ID="+request.getParameter("ID").toString();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) 
			{
				System.out.println(rs.getInt("ID")+"\t"+rs.getString("Name")+"\t"+rs.getString("CurrentLevel"));
				System.out.println("Yes");
			}
		}catch(Exception e) {
			System.out.print(e);
		}
	}

}
