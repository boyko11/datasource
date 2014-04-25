<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Source Stats</title>
<link rel="stylesheet" type="text/css" href="css/table.css">
</head>
<body>
<div class="centered">
	<table cellspacing='0'> <!-- cellspacing='0' is important, must stay -->
	    <tr><th>Connection Property</th><th>Value</th></tr>
    	<tr><td>Active:</td><td><%=request.getAttribute("active") %></td></tr>
    	<tr class="even"><td>MaxActive:</td><td><%=request.getAttribute("max-active") %></td></tr>
    	<tr><td>Idle:</td><td><%=request.getAttribute("num-idle") %></td></tr>
    	<tr class="even"><td>MinIdle:</td><td><%=request.getAttribute("min-idle") %></td></tr>
    	<tr><td>MaxIdle:</td><td><%=request.getAttribute("max-idle") %></td></tr>
       	<tr class="even"><td>InitialSize:</td><td><%=request.getAttribute("initial-size") %></td></tr>
    	<tr><td>MaxWait:</td><td><%=request.getAttribute("max-wait") %></td></tr>
    	<tr class="even"><td>DefaultCatalog:</td><td><%=request.getAttribute("default-catalog") %></td></tr>
    	<tr><td>getDefaultTransactionIsolation:</td><td><%=request.getAttribute("default-transaction-isolation") %></td></tr>
    	<tr class="even"><td>getMaxOpenPreparedStatements</td><td><%=request.getAttribute("max-open-prepared-statements") %></td></tr>
    	<tr><td>getMinEvictableIdleTimeMillis:</td><td><%=request.getAttribute("min-evictable-idle-time") %></td></tr>
    	<tr class="even"><td>getRemoveAbandonedTimeout</td><td><%=request.getAttribute("remove-abandoned-timeout") %></td></tr>
    	<tr><td>getNumTestsPerEvictionRun</td><td><%=request.getAttribute("num-tests-per-eviction-run") %></td></tr>
    	<tr class="even"><td>getTimeBetweenEvictionRunsMillis</td><td><%=request.getAttribute("time-between-eviction-runs") %></td></tr>
    	<tr><td>getValidationQuery</td><td><%=request.getAttribute("validation-query") %></td></tr>
    	<tr class="even"><td>getValidationQueryTimeout</td><td><%=request.getAttribute("validation-query-timeout") %></td></tr>
    	<tr><td>getLogAbandoned</td><td><%=request.getAttribute("log-abandoned") %></td></tr>
    	<tr class="even"><td>getRemoveAbandoned</td><td><%=request.getAttribute("remove-abandoned") %></td></tr> 
	</table>
</div>
</body>
</html>