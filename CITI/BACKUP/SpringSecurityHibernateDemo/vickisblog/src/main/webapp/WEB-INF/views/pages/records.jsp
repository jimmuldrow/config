<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
    <link href="<c:url value='/static/css/custom.css' />" rel="stylesheet"></link>
    <script src="<c:url value='/static/js/angular.min.js' />"></script>
    <script src="<c:url value='/static/js/jquery-1.12.2.min.js' />"></script>
</head>
<body>
<h1>Records</h1>

<c:url var="editImgUrl" value="/static/img/edit.png" />
<c:url var="deleteImgUrl" value="/static/img/delete.png" />
<c:url var="addUrl" value="/add" />

<div ng-app="ccApp" ng-controller="ccCtrl"> 

<table style="border: 1px solid; width: 100%; text-align:center">
	<thead style="background:#d3dce3">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Money</th>
			<th>Customer Type</th>
			<th>Birth Date</th>
			<th colspan="2"></th>
			<th>CC Type</th>
			<th>CC Number</th>
			<th colspan="3"></th>
		</tr>
	</thead>
	<tbody style="background:#ccc" ng-repeat="person in people">
		<c:url var="editUrl" value="/edit?id={{person.id}}" />
		<c:url var="deleteUrl" value="/delete?id={{person.id}}" />
			<tr ng-show="person.creditCards.length == 0">
				<td>{{person.id}}</td>
				<td>{{person.firstName}} </td>
				<td>{{person.lastName}} </td>
				<td>{{person.money}} </td>
				<td>{{person.customerType}} </td>
				<td>{{person.birthDate}} </td>
				<td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>						
				<td></td>
				<td></td>
				<c:url var="addCcUrl" value="/main/creditcard/add?id={{person.id}}" />
				<td><a href="${addCcUrl}">+</a></td>
				<td></td>
				<td></td>			
			</tr>
			<tr ng-repeat="creditCard in person.creditCards">
				<td>{{person.id}}</td>
				<td>{{person.firstName}} </td>
				<td>{{person.lastName}} </td>
				<td>{{person.money}} </td>
				<td>{{person.customerType}} </td>
				<td>{{person.birthDate}} </td>
				<td><a href="${editUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteUrl}"><img src="${deleteImgUrl}"></img></a></td>						
				<td>{{creditCard.type}} </td>
				<td>{{creditCard.number}} </td>
				<c:url var="addCcUrl" value="/main/creditcard/add?id={{person.id}}" />
				<c:url var="editCcUrl" value="/main/creditcard/edit?pid={{person.id}}&cid={{creditCard.id}}" />
				<c:url var="deleteCcUrl" value="/main/creditcard/delete?id={{creditCard.id}}" />
				<td><a href="${addCcUrl}">+</a></td>
				<td><a href="${editCcUrl}"><img src="${editImgUrl}"></img></a></td>
				<td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"></img></a></td>
			</tr>
	</tbody>
</table>

<p><a href="${addUrl}">Create new record</a></p>
</div>

<script>
var app = angular.module('ccApp', []);
app.controller('ccCtrl', function($scope, $http) {
    $http.get("http://localhost:8080/test/listAll")
    .success(function(response) {
    	$scope.people = response;
    });
});
</script>

</body>
</html>