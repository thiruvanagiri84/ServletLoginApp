<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java4s.ProfessionalBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  in showvalues jsp <br/>
  <%
  	ArrayList<ProfessionalBean> aList = (ArrayList<ProfessionalBean>)request.getAttribute("profbeanlist");
  	out.println("List size in jsp:: "+aList.size()+"<br/>");
  %>
  		<table border=2>
  			<tr>
  				<td>Professional Id</td>
  				<td>Professional Name</td>
  				<td>Professional Email</td>	
  			</tr>
  <%	
  	for(ProfessionalBean profBean: aList){
  		//out.println("Id: "+profBean.getProfId()+"<br/>");	
  		//out.println("Name: "+profBean.getProfName()+"<br/>");	
  		//out.println("Email: "+profBean.getProfEmail()+"<br/>");
  %>
  		
  			<tr>
  				<td><c:out value="<%=profBean.getProfId() %>"></c:out></td>
  				<td><c:out value="<%=profBean.getProfName() %>"></c:out></td>
  				<td><c:out value="<%=profBean.getProfEmail() %>"></c:out></td>
  			</tr>
  		
  	<%	
  	}
    %>
    </table>
  
  
  
</body>
</html>