<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/include/include.jsp" />


<html>
<body>
<c:if test="${not empty npet}">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
				<tr>
					<td>${npet.pid}</td>
					<td>${npet.petName}</td>
					<td>${ownerName}</td>
					<td>${npet.type}</td>
					<td>${npet.birthdate}</td>
					<td>
						<spring:url var="petView" value="/petviewToVisitations">
						<spring:param name="pid" value="${npet.pid}"> </spring:param>  
						</spring:url>
					</td>

					<td><a href="${petView}"> View Visitation </a></td>

					<td>
						<spring:url var="addVisit" value="/petviewToVisitForm">
						<spring:param name="pid" value="${npet.pid}"> </spring:param>  
						</spring:url>
					</td>

					<td><a href="${addVisit}"> Add New Visit </a></td>

					<td>
						<spring:url var="update" value="/petviewToUpdatePet">
						<spring:param name="pid" value="${npet.pid}"> </spring:param>  
						</spring:url>
					</td>

					<td><a href="${update}"> Update Info </a></td>


					<td>
						<spring:url var="delete" value="/petviewToDeletePet">
						<spring:param name="pid" value="${npet.pid}"> </spring:param>  
						</spring:url>
					</td>

					<td><a href="${delete}"> Delete Pet </a></td>

			</tr>
</TABLE>
</c:if>

</body>
</html>