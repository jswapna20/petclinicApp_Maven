<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="/WEB-INF/include/include.jsp" />



<html>
<body style="background-color:#FFCC99;">
<div align ="center" >

<form:form method="GET" commandName="pet" action="search">
	<TABLE WIDTH=30% HEIGHT=10% BORDER=1 BORDERCOLOR="#aabbcc">
				<TR>
					<td> Pet Name</td>
					<td><form:input path="petName" /></td>
					<td colspan="2"> <input class="button" type="submit" value="Search"/></td>
				</TR>
				
	</TABLE>
</form:form>

<TABLE HEIGHT=10% WIDTH=35% BORDER=0>
					<td>________________________ OR _____________________</td>
</TABLE>

<form:form method="GET" commandName="petOwner" action="petSearch_ownerLink">
	<TABLE WIDTH=30% HEIGHT=10% BORDER=1 BORDERCOLOR="#aabbcc">
				<TR>
					<td> Pet Owner Name</td>
					<td><form:input path="ownerName" /></td>
					<td colspan="2"> <input class="button" type="submit" value="Search"/></td>
				</TR>
	</TABLE>
</form:form>

<form:form method="GET" commandName="pet" action="addPetowner">
	<TABLE WIDTH=20% HEIGHT=10% BORDER=0 BORDERCOLOR="#aabbcc">
				<TR>
					<td colspan="2"> <input class="button" type="submit" value="Add New PetOwner"/></td>
</form:form>

<form:form method="GET" commandName="pet" action="searchOwner">
					<td colspan="2"> <input class="button" type="submit" value="Add New Pet"/></td>
				</TR>
			</TABLE>
</form:form>

</div>
</body>
</html>