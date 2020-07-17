<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/include/include.jsp" />


<html>
<body>
<div align="center">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">

<form:form method="POST" commandName="petnOwnerDto" action="addVisits">
<c:if test="${not empty pet}">
							<br></br>
							<br></br>
					<tr><td>Pet Id :</td>
						<td>${pet.pid}</td></tr>

					<tr><td>Pet Name :</td>
						<td>${pet.petName}</td></tr>

					<tr><td>Owner Name :</td>
						<td>${pet.petOwner.ownerName}</td></tr>

					<tr><td>Type :</td>
						<td>${pet.type}</td></tr>

						<td><form:hidden path="pid" value="${pet.pid}"/></td>
</c:if>
					<tr><td>Date :</td>
						<td><form:input type="date" path="visitDate"/></td></tr>

					<tr><td>Description:</td>
						<td><form:input path="description"/></td></tr>
</TABLE>

		
<TABLE WIDTH=20% HEIGHT=5% BORDER=0 BORDERCOLOR="#aabbcc">
						<td><br></br></td>
					<tr>
						<td colspan="2"> <input class="subButtons" type="submit" value="Add"/></td>
</form:form>

<form:form method="GET" commandName="pet" action="linkPet">
						<td><form:hidden path="pid" value="${pet.pid}"/></td>
						<td colspan="2"> <input class="subButtons" type="submit" value="Cancel"/></td>
</form:form>

<form:form method="GET" commandName="pet" action="petviewToVisitForm">
						<td><form:hidden path="pid" value="${pet.pid}"/></td>
						<td colspan="2"> <input class="subButtons" type="submit" value="Clear"/></td>
</form:form>
					</tr>
</TABLE>


<TABLE WIDTH=20% HEIGHT=5% BORDER=0 BORDERCOLOR="#aabbcc">
						<td><br></br></td>
<c:if test="${not empty testVisit}">

		Visit Details Added!!!!!

</c:if>
</TABLE>


</div>
</body>
</html>