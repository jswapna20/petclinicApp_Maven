<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="/WEB-INF/include/include.jsp" />

<html>
<body>
<div align="center">
<c:if test="${not empty npetOwner}">
	<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
		<TR>
			<th>  </th>
			<th> Owner Name </th>
			<th>  </th>
			<th> Pet/Pets </th>
		</TR>
  <c:forEach var="o" items="${npetOwner}">
		<tr>
			<td>
			<spring:url var="owner" value="/linkOwner">
			<spring:param name="oid"	value="${o.oid}"></spring:param>
			</spring:url>
			<td><a href="${owner}">${o.ownerName} </a></td>
			</td>

		<c:forEach var="t" items="${o.pet}">
			<td>
			<spring:url var="pets" value="/linkPet">
			<spring:param name="pid"	value="${t.pid}"></spring:param>
			</spring:url>
			</td>
			<td><a href="${pets}">${t.petName} </a></td>
		</c:forEach>
		</tr>
	</c:forEach>
</TABLE>
</c:if>


<c:if test="${not empty npet}">
<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
		<TR>
		  	<th>  </th>
			<th> Pet</th>
			<th>  </th>
			<th> Owner Name</th>
		</TR>
	<c:forEach var="o" items="${npet}">
		<tr>
			<td>
			<spring:url var="pets" value="/linkPet">
			<spring:param name="pid"	value="${o.pid}"></spring:param>
			</spring:url>
			</td>
		
			<td>
				<a href="${pets}">${o.petName} </a>
			 </td>

			<td>
			<spring:url var="owner" value="/linkOwner">
			<spring:param name="oid"	value="${o.petOwner.oid}"></spring:param>
			</spring:url>
			</td>
								
			<td>
				<a href="${owner}">${o.petOwner.ownerName} </a>
			</td>			
		</tr>		
				
	</c:forEach>
</TABLE>

</c:if> 
</div>
</body>
</html>
		