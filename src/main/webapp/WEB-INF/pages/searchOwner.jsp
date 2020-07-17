<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<jsp:include page="/WEB-INF/include/include.jsp" />



<html>
<body>
<div align="center">

<form:form method="GET" commandName="petOwner" action="owners">
<TABLE WIDTH=26% BORDER=1 BORDERCOLOR="#aabbcc">
			    <TR>
					<td>For Pet Owner:</td>
					<td><form:input path="ownerName" /></td>
				</TR>
				<TR>
					<td></td>
					<td style="text-align:right;width:20%;"> <input class="button" type="submit" value="search"/></td>
				</TR>
</TABLE>
</form:form>

</div>
</body>
</html>