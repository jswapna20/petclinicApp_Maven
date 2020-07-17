<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/include/include.jsp" />

<html>
<body>
<div align="center">
<c:if test="${not empty ownerColl}">
	<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
		<tr>
			<th> Owner Id </th>
			<th> Owner Name </th>
			<th> Owner Address </th>
		</tr>
	<c:forEach var="o" items="${ownerColl}">
	   <tr>
			<td>${o.oid}</td>
			<td>${o.ownerName}</td>
			<td>${o.address}</td>
			<td>
				<spring:url var="pets" value="/addPets">
				<spring:param name="oid" value="${o.oid}"></spring:param>
				<spring:param name="ownerName" value="${o.ownerName}"></spring:param>
				</spring:url>
			</td>
			<td>
				<a href="${pets}">Add Pet</a>
			</td>
		</tr>
						
	 </c:forEach>
	</TABLE>
</c:if>

</div>
</body>
</html>



