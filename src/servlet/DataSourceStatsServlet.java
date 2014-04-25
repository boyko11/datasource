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
		request.setAttribute("active", ds.getNumActive());
		request.setAttribute("max-active", ds.getMaxActive());
		request.setAttribute("num-idle", ds.getNumIdle());
		request.setAttribute("min-idle", ds.getMinIdle());
		request.setAttribute("max-idle", ds.getMaxIdle());
		request.setAttribute("initial-size", ds.getInitialSize());
		request.setAttribute("max-wait", ds.getMaxWait());
		request.setAttribute("default-catalog", ds.getDefaultCatalog());
		request.setAttribute("default-transaction-isolation", ds.getDefaultTransactionIsolation());
		request.setAttribute("max-open-prepared-statements", ds.getMaxOpenPreparedStatements());
		request.setAttribute("min-evictable-idle-time", ds.getMinEvictableIdleTimeMillis());
		request.setAttribute("remove-abandoned-timeout", ds.getRemoveAbandonedTimeout());
		request.setAttribute("num-tests-per-eviction-run", ds.getNumTestsPerEvictionRun());
		request.setAttribute("time-between-eviction-runs", ds.getTimeBetweenEvictionRunsMillis());
		request.setAttribute("validation-query", ds.getValidationQuery());
		request.setAttribute("validation-query-timeout", ds.getValidationQueryTimeout());
		request.setAttribute("log-abandoned", ds.getLogAbandoned());
		request.setAttribute("remove-abandoned", ds.getRemoveAbandoned());
		request.getRequestDispatcher("/data-source-stats.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
