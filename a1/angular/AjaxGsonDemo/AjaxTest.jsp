
<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
</head>
<body>
<h2>Ajax</h2>

<div ng-app="myApp" ng-controller="customersCtrl"> 

<ul>
  <li ng-repeat="x in names">
    {{ x.firstName + " " + x.mi  + " " + x.lastName }}
  </li>
</ul>

</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("http://localhost:7001/testWar/serv2")
    .success(function(response) {
    	$scope.names = response;
    });
});
</script>
</body>
</html>