<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/include/include.jsp" />

<html>
<body>
<div align="center">
<form:form method="POST" commandName="petObject" action="petUpdate">
<c:if test="${not empty pet}">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
				<tr><td>Pet Id :</td>
					<td>${pet.pid}</td></tr>
					<td><form:hidden path="pid" value="${pet.pid}" /></td>
				<tr><td>Pet Name :</td>
					<td><form:input path="petName" value="${pet.petName}"/></td></tr>
				<tr><td>Owner Name :</td>
					<td>${ownername}</td></tr>
				<tr><td>Type :</td>
					<td><form:input path="type" value="${pet.type}"/></td></tr>
				<tr><td>Birthdate :</td>
					<td><form:input type="date" path="birthdate" value="${pet.birthdate}"/></td></tr>
</c:if>
</TABLE>
					<br></br>

<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
				<tr>
					<td><input class="subButtons" type="submit" value="update"/></td>
</form:form>

<form:form method="GET" commandName="petObject" action="linkPet">
<c:if test="${not empty pet}">
					<td><form:hidden path="pid" value="${pet.pid}" /></td>
</c:if>

					<td><input class="subButtons" type="submit" value="Cancel"/></td>
				</tr>
</form:form>
</TABLE>

<c:if test="${not empty petUpdate}">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
					<br></br>
					<br></br>
				Updated values!!!!!!!!!!

				<tr><th>Pet_Id:</th>
						<td>${petUpdate.pid}</td>
					<th>Pet_Name:</th>
						<td>${petUpdate.petName}</td>
					<th>Owner_Name:</th>
						<td>${petUpdate.petOwner.ownerName}</td>
					<th>Type:</th>
						<td>${petUpdate.type}</td>
					<th>Birthdate:</th>
						<td>${petUpdate.birthdate}</td>
				</tr>
</TABLE>
</c:if>

</div>
</body>
</html>