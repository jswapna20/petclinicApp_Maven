<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/include/include.jsp" />


<html>
<body>
<div align="center">

<form:form method="POST" commandName="pet" action="addNewPet">
	<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
		<tr>
			<td> Pet Id :</td>
			<td><form:input path="pid" /></td>
		</tr>
		<tr>
			<td> Pet Name :</td>
			<td><form:input path="petName" /></td>
		</tr>
		<tr>
			<td> Type : </td>
			<td><form:input path="type" /></td>
		</tr>
		<tr>
			<td> Birth Date : </td>
			<td><form:input type="date" path="birthdate" /></td>
		</tr>
		<tr>
			<td> </td>
			<td><form:hidden path="poid" value="${oid}" /></td>
		</tr>
	</TABLE>

<td><br></br></td>
	<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
		<tr>
			<td colspan="2"> <input class="button" type="submit" value="Add"/></td>
</form:form>

<form:form method="GET" commandName="petOwner" action="owners">
			<td><form:hidden path="ownerName" value="${petOwner.ownerName}"/></td>
			<td colspan="2"> <input class="button" type="submit" value="Cancel"/></td>
		</tr>
	</TABLE>
</form:form>


<c:if test="${not empty petTest}">
	<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">

		Added Pet details!!!!!!
		<tr>
			<th>Pet Id</th>
			<td>${petTest.pid}</td>
			<th>PetName</th>
			<td>${petTest.petName}</td>
			<th>Type</th>
			<td>${petTest.type}</td>
			<th>Birthdate</th>
			<td>${petTest.birthdate}</td>
		</tr>
	</TABLE>

</c:if>
</div>
</body>
</html>