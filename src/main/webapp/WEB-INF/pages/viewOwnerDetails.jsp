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
<form:form method="POST" commandName="petOwner" action="ownerUpdateForm">
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
		<td colspan="2"><input class="subButtons" type="submit" value="Update"/><td>
</form:form>

<form:form commandName="petOwner" action="petSearch_ownerLink">
		<td><form:hidden path="ownerName" value="${petOwner.ownerName}"/></td>
		<td colspan="2"><input class="subButtons" type="submit" value="Cancel"/><td>
	</tr>

</form:form>

	<td><br></br></td>

<form:form commandName="petOwner" action="deletePetOwnerForm">
	<tr>
		<td><form:hidden path="oid" value="${petOwner.oid}"/></td>
		<td colspan="2"><input class="subButtons" type="submit" value="Delete PetOwner"/><td>
	</tr>
</form:form>
</TABLE>

</div>
</body>
</html>



