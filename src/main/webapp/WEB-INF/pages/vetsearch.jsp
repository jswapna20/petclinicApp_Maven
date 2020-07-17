<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="/WEB-INF/include/include.jsp" />


<html>
<body style="background-color:lightgreen;">
<div align = "center" >
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
<form:form method="POST" commandName="vetDto" action="searchVet">	
			<TR>
					<td> Vet Name</td>
					<td><form:input path="vetName" /></td>
					
			</TR>
			<TR>
					<td> Speciality</td>
					<td><form:input path="specialityName" /></td>
			</TR>
			<TR>
					<td colspan="2" style="text-align:right;width:20%;"><input class="button" type="submit" value="Search"/></td>
			</TR>
</form:form>
</TABLE>

</div>
</body>
</html>