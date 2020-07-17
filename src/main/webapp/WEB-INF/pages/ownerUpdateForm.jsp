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
		
<form:form method="POST" commandName="po" action="ownerUpdate">
		<tr>
				<td> Owner Id </td>
				<td>${po.oid}</td>
				<td><form:hidden path="oid" value="${po.oid}"/></td>
		</tr>
		<tr>
				<td> Owner Name </td>
				<td>${po.ownerName}</td>
				<td><form:hidden path="ownerName" value="${po.ownerName}"/></td>

		</tr>
		<tr>
				<td> Owner Address </td>
				<td><form:input path="address" value="${po.address}"/></td>
		</tr>
		<tr>
				<td> City </td>
				<td><form:input path="city" value="${po.city}"/></td>
		</tr>
		<tr>
				<td> Telephone </td>
				<td><form:input path="telephone" value="${po.telephone}"/></td>
		</tr>

</TABLE>

<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
		<td><br></br></td>
		<tr>
				<td colspan="2"><input class="button" type="submit" value="Update"/><td>
</form:form>

<form:form  commandName="po" action="linkOwner">
				<td><form:hidden path="oid" value="${po.oid}"/></td>
				<td><input class="button" type="submit" value="Cancel"/><td>
</form:form>
		</tr>

</div>
</TABLE>
<td><br></br><td>

<c:if test="${not empty ownerObject}">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">

				updated values!!!

		<tr><th>PetOwner_Id:</th>
				<td>${ownerObject.oid}</td>
			<th>Owner_Name:</th>
				<td>${ownerObject.ownerName}</td>
			<th>Address:</th>
				<td>${ownerObject.address}</td>
			<th>City:</th>
				<td>${ownerObject.city}</td>
			<th>Telephone:</th>
				<td>${ownerObject.telephone}</td>
		</tr>
</c:if>
</TABLE>
				
</body>
</html>



