<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<script src="<c:url value='/static/js/editCreditCards.js' />"></script>
</head>
<body>

<h1 class="topHead">Edit Existing Credit Card</h1>

<c:url var="saveUrl" value="/main/creditcard/edit?pid=${personId}&id=${creditCard.id}" />
	<form:form modelAttribute="creditCard" method="POST"
		action="${saveUrl}">
		<table>

			<tr>
				<td>Person Id:</td>
				<td><input type="text" value="${personId}" disabled="true" /></td>
			</tr>

			<tr>
				<td><form:label path="type">Type:</form:label></td>
  				<td><form:select id="ccType" path="type">
						<form:option value="">Select Credit Card Type</form:option>
						<form:options items="${creditcardlist}" />
					</form:select></td>
				<td><form:errors path="type" cssClass="error" /><span id="errCCType" style="color: red;"></span></td>
			</tr>

			<tr>
				<td><form:label path="number">Number:</form:label></td>
				<td><form:input id="ccNumber" path="number" /></td>
				<td><form:errors path="number" cssClass="error" /><span id="errCCNumber" style="color: red;"></span></td>
			</tr>
		</table>

		<input id="submit" type="submit" value="Save" />
	</form:form>
</body>
</html>