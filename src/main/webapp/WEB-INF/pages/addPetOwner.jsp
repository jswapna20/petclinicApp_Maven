
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="/WEB-INF/include/include.jsp" />

<html>
<body>
	<div align="center">
		<form:form method="POST" commandName="petOwner"
			action="addNewPetOwner">
			<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">
				<tr>
					<td>Owner Id :</td>
					<td><form:input path="oid" /></td>
				</tr>

				<tr>
					<td>Owner Name :</td>
					<td><form:input path="ownerName" /></td>
				</tr>

				<tr>
					<td>Telephone :</td>
					<td><form:input path="telephone" /></td>
				</tr>

				<tr>
					<td>Address :</td>
					<td><form:input path="address" /></td>
				</tr>

				<tr>
					<td>City :</td>
					<td><form:input path="city" /></td>
				</tr>
			</TABLE>


			<TABLE WIDTH=20% BORDER=0 BORDERCOLOR="#aabbcc">
				<td><br></br></td>
				<tr>
					<td colspan="2"><input class="subButtons" type="submit"
						value="Add" /></td>
					</form:form>

					<form:form method="GET" commandName="pet"
						action="cancelToPetsearch">
						<td colspan="2"><input class="subButtons" type="submit"
							value="Cancel" /></td>
				</tr>
			</TABLE>
		</form:form>


		<c:if test="${not empty ownerTest}">
			<td><br></br></td>
			<TABLE WIDTH=20% BORDER=1 BORDERCOLOR="#aabbcc">

				Added PetOwner details!!!!!!

				<tr>
					<th>Owner id</th>
					<td>${ownerTest.oid}</td>
					<th>OwnerName</th>
					<td>${ownerTest.ownerName}</td>
					<th>Telephone</th>
					<td>${ownerTest.telephone}</td>
					<th>Address</th>
					<td>${ownerTest.address}</td>
					<th>City</th>
					<td>${ownerTest.city}</td>
				</tr>
			</TABLE>
		</c:if>
	</div>
</body>
</html>