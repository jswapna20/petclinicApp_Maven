<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/include/include.jsp" />

<html>
<body>
<div align="center">
<form:form method="POST" commandName="petnOwnerDto" action="link">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
<c:if test="${not empty pet}">
						
						<tr><td>Pet Id :</td>
							<td>${pet.pid}</td></tr>
						<tr><td>Pet Name :</td>
							<td>${pet.petName}</td></tr>
						<tr><td>Owner Name :</td>
							<td>${pet.petOwner.ownerName}</td></tr>
						<tr><td>Type :</td>
							<td>${pet.type}</td></tr>
						<tr><td>Birthdate :</td>
							<td>${pet.birthdate}</td></tr>
						
						<tr>
							<td>Visit Id</td>
							<td>Visited On </td>
							<td> Remarks </td>

						</tr>
  <c:if test="${not empty nvisit}">
		<c:forEach var="o" items="${nvisit}">
						<tr>
							<td>${o.visitId}</td>
							<td>${o.visitDate}</td>
							<td>${o.description}</td>
						</tr>

		</c:forEach>
  </c:if>
</c:if>
						<br></brhj>
</form:form>
</TABLE>

<form:form method="GET" commandName="petnOwnerDto" action="linkPet">
<c:if test="${not empty pet}">
							<td><form:hidden path="pid" value="${pet.pid}"/></td>
</c:if>
							<br></brhj>
							<td><input class="subButtons" type="submit" value="Go Back"/></td>
</form:form>

</div>
</body>
</html>