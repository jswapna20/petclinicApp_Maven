<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/include/include.jsp" />

<html>
<body>
<div align="center">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
<form:form method="POST" commandName="petOwner" action="deleteOwner">
		<tr>
				<td> Owner Id </td>
				<td>${petOwner.oid}</td>
				<form:hidden path="oid" value="${petOwner.oid}"/>
		</tr>
		<tr>
				<td> Owner Name </td>
				<td>${petOwner.ownerName}</td>
		</tr>
		<tr>
				<td> Owner Address </td>
				<td>${petOwner.address}</td>
		</tr>
		<tr>
				<td> City </td>
				<td>${petOwner.city}</td>
		</tr>
		<tr>
				<td> Telephone </td>
				<td>${petOwner.telephone}</td>
		</tr>
</TABLE>

<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
				<td><br></br></td>

		<tr>
				<td colspan="2"><input class="subButtons" type="submit" value="Delete"/><td>
</form:form>

<form:form commandName="petOwner" action="linkOwner">
				<td><form:hidden path="oid" value="${petOwner.oid}"/></td>
				<td colspan="2"><input class="subButtons" type="submit" value="Cancel"/><td>
		</tr>

</form:form>
</TABLE>


<c:if test="${not empty petOwnerTest}">
				<td>PetOwner Deleted!!!!</td>
</c:if>
</div>
</body>
</html>



