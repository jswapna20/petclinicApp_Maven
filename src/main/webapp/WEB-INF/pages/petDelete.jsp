<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/include/include.jsp" />

<html>
<body>
<div align="center">
<form:form method="POST" commandName="pet" action="deletePet">
	<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
			<tr><td>Pet Id :</td>
				<td>${pet.pid}</td></tr>
				<td><form:hidden path="pid" value="${pet.pid}" /></td>
			<tr><td>Pet Name :</td>
				<td>${pet.petName}</td></tr>
			<tr><td>Owner Name :</td>
				<td>${ownername}</td></tr>
			<tr><td>Type :</td>
				<td>${pet.type}</td></tr>
			<tr><td>Birthdate :</td>
				<td>${pet.type}</td></tr>
	</TABLE>

	<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
			<tr><td><input class="subButtons" type="submit" value="Delete"/></td>
</form:form>
	
<form:form method="GET" commandName="pet" action="linkPet">
<c:if test="${not empty pet}">
				<td><br></br></td>
				<td><form:hidden path="pid" value="${pet.pid}"/></td>
</c:if>
					<br></br>
				<td><input class="subButtons" type="submit" value="Cancel"/></td></tr>
</form:form>
	</TABLE>

<c:if test="${not empty petTest}">
				<td>Pet Deleted!!!!</td>
</c:if>


</div>
</body>
</html>