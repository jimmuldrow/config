<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
    <script src="<c:url value='/static/js/jquery-1.12.2.min.js' />"></script>
    <script src="<c:url value='/static/js/editPeople.js' />"></script>
</head>
<body>

<h1 class="topHead">Edit Existing Record</h1>

<c:url var="saveUrl" value="/edit?id=${person.id}" />
<form:form modelAttribute="person" method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="firstName">First Name:</form:label></td>
			<td><form:input id="firstName" path="firstName"/></td>
			<td><form:errors path="firstName" cssClass="error"/><span id="errFirstName" style="color: red;"></span></td>
		</tr>
		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:input id="lastName" path="lastName"/></td>
			<td><form:errors path="lastName" cssClass="error"/><span id="errLastName" style="color: red;"></span></td>
		</tr>		
		<tr>
			<td><form:label path="money">Money</form:label></td>
			<td><form:input id="money" path="money"/></td>
			<td><form:errors path="money" cssClass="error"/><span id="errMoney" style="color: red;"></span></td>
		</tr>
		<tr>
			<td><form:label path="customerType">Customer Type</form:label></td>
			<td><form:radiobuttons name="customerType" path="customerType" items="${customerTypes}" /></td>
			<td><form:errors path="customerType" cssClass="error"/><span id="errCustomerType" style="color: red;"></span></td>
		</tr>		
		<tr>
			<td><form:label path="birthDate">Birth Date</form:label></td>
			<td><form:input placeholder="YYYY-MM-DD" id="birthDate" path="birthDate"/></td>
			<td><form:errors path="birthDate" cssClass="error"/><span id="errDate" style="color: red;"></span></td>
		</tr>		
	</table>
	
	<input id="submit" type="submit" value="Save" />
</form:form>
</body>
</html>