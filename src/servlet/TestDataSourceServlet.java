package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;


/**
 * Servlet implementation class DataSourceStatsServlet
 */
@WebServlet("/testdatasource")
public class TestDataSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static InitialContext ctx;
	private static BasicDataSource ds;
	
	static {
		try {
			ctx = new InitialContext();
			Context initContext = (Context) ctx.lookup("java:/comp/env");
			ds = (BasicDataSource) initContext.lookup("jdbc/TestDB");
		} catch (NamingException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    /**
     * Default constructor. 
     */
    public TestDataSourceServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
		Connection con;
		try {
			con = ds.getConnection();
			Statement stmt = con.createStatement();
			String query = "select * from kermitvite.user";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				out.print("<br/>" + rs.getString("id") + "</td>");
				out.print("<br/>" + rs.getString("username") + "</td>");
				out.print("<hr/>");				
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
