package servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/datasourcestats")
public class DataSourceStatsServlet extends HttpServlet {
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
    public DataSourceStatsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>Hola</title>");
	    out.println("</head>");
	    out.println("<body bgcolor=\"white\">");
	    out.println("<br/>Active: " + ds.getNumActive());
	    out.println("<br/>MaxActive: " + ds.getMaxActive());
	    out.println("<br/>Idle: " + ds.getNumIdle());
	    out.println("<br/>MinIdle: " + ds.getMinIdle());
	    out.println("<br/>MaxIdle: " + ds.getMaxIdle());
	    out.println("<br/>InitialSize: " + ds.getInitialSize());
	    out.println("<br/>MaxWait: " + ds.getMaxWait());
	    out.println("<br/>DefaultCatalog: " + ds.getDefaultCatalog());
	    out.println("<br/>getDefaultTransactionIsolation: " + ds.getDefaultTransactionIsolation());
		out.println("<br/>getMaxOpenPreparedStatements: " + ds.getMaxOpenPreparedStatements());
		out.println("<br/>getMinEvictableIdleTimeMillis: " + ds.getMinEvictableIdleTimeMillis());
		out.println("<br/>getRemoveAbandonedTimeout: " + ds.getRemoveAbandonedTimeout());
		out.println("<br/>getNumTestsPerEvictionRun: " + ds.getNumTestsPerEvictionRun());
		out.println("<br/>getRemoveAbandonedTimeout: " + ds.getRemoveAbandonedTimeout());
		out.println("<br/>getTimeBetweenEvictionRunsMillis: " + ds.getTimeBetweenEvictionRunsMillis());
		out.println("<br/>getValidationQuery: " + ds.getValidationQuery());
		out.println("<br/>getValidationQueryTimeout: " + ds.getValidationQueryTimeout());
		out.println("<br/>getLogAbandoned: " + ds.getLogAbandoned());
		out.println("<br/>getRemoveAbandoned: " + ds.getRemoveAbandoned());
	    out.println("</body>");
	    out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
