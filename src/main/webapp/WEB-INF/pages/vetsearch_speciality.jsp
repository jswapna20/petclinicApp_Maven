<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/include/include.jsp" />


<html>
<body style="background-color:lightyellow;">
<div align = "center" >
<c:if test="${not empty spMap}">
<TABLE WIDTH=20% BORDER=3 BORDERCOLOR="#aabbcc">	
				<TR>
					<th> Speciality :</th>
					<th> Vet Name: </th>
				</TR>
	<c:forEach var="t" items="${spMap}">
				<tr>
					<td>${t.key.specialityName}</td>
					<td>${t.value.vetName}</td>
				</tr>
	</c:forEach>
</TABLE>	
</c:if>
					<td><br></br></td>

<c:if test="${not empty vetMap}">
<TABLE WIDTH=20% BORDER=3 BORDERCOLOR="#aabbcc">
				<TR>
					<th> Id: </th>
					<th> Vet Name: </th>
					<th> Specialities:</th>
				</TR>
	<c:forEach var="o" items="${vetMap}">
				<tr>
					<td>${o.key.vid}</td>
					<td>${o.key.vetName}</td>
					<td>${o.value}</td>
				</tr>
	</c:forEach>
</TABLE>
</c:if>

</div>
</body>	
</html>