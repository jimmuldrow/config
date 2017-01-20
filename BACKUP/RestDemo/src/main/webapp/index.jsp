<!DOCTYPE html>
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="js/jquery.plugin.min.js"></script>
<script src="js/jquery.datepick.min.js"></script>
<link href="css/jquery.datepick.css" rel="stylesheet">

<style>
body {font-family: arial, verdana};
</style>
</head>
<body>


<div ng-app="myApp" ng-controller="myCtrl" style="padding-top: 40px; padding-left: 50px;"> 

Test Date: <input placeholder="mm/dd/yyyy" id="testDate" size="11" class="datepicker"><br><br>
<input ng-click="validateDate()" id="click" type="button" value="Validate Date"><br><br>
Is Date Valid? {{result}}<br><br><br><br>


Celsius Temperature: <input ng-model="celsius" ><br><br>
<input type="button" value="Convert Celsius To Fahrenheit" ng-click="celsiusToFahrenheitFunc()"><br><br>
Celsius To Fahrenheit Value: {{celsiusToFahrenheit}}<br><br><br><br>



Fahrenheit Temperature: <input ng-model="fahrenheit" ><br><br>
<input type="button" value="Convert Fahrenheit To Celsius" ng-click="fahrenheitToCelsiusFunc()"><br><br>
Fahrenheit to Celsius Value: {{fahrenheitToCelsius}}





</div>

<script>

var app = angular.module('myApp', []);
app.controller('myCtrl', function($scope, $http) {
	$(function() {$('#testDate').datepick();});	
	
	$scope.validateDate = function(){
		$scope.result = ""; 
		$scope.testDate = $("#testDate").val();
		
		if(valueExists($scope.testDate)){
			var isDateFormat = /^(\d){1,2}\/(\d){1,2}\/(\d){4}$/.test($scope.testDate);

			if(isDateFormat){
				var mdy = $scope.testDate.split("/");

				if(mdy.length === 3){
					var jsonDate = {"month": mdy[0], "day": mdy[1], "year": mdy[2], "isDateValid": "false"}; 
					
				    $http.post("http://localhost:8080/test/webapi/jersey/verifydate", jsonDate)
				    .success(function(response) {
				    	$scope.result = response.isDateValid;
				    })  
				    .error(function() {
				    	$scope.result = "false";
				    })  				    
				}
				else{
					$scope.result = "false";
				}
			}
			else{
				$scope.result = "false";
			}			
		}
		else{
			$scope.result = "false";
		}		
	}
	
	$scope.celsiusToFahrenheitFunc = function(){
		var cel = $scope.celsius;
		$scope.celsiusToFahrenheit = "";
		
		if(valueExists(cel)){
			$http.get('http://localhost:8080/test/webapi/jersey/celsiustofahrenheit/' + cel)
			.success(function(response) {
				$scope.celsiusToFahrenheit = response;
			})
			.error(function() {
				$scope.celsiusToFahrenheit = "";
			});				
		}
		else{
			$scope.celsiusToFahrenheit = "";
		}
	}	
	
	$scope.fahrenheitToCelsiusFunc = function(){
		var fah = $scope.fahrenheit;
		$scope.fahrenheitToCelsius = "";
		
		if(valueExists(fah)){	
			$http.get('http://localhost:8080/test/webapi/jersey/fahrenheittocelsius/' + fah)
			.success(function(response) {
				$scope.fahrenheitToCelsius = response;
			})
			.error(function() {
				$scope.fahrenheitToCelsius = "";
			});			
		}
		else{
			$scope.fahrenheitToCelsius = "";
		}
	}	
	
	function valueExists(s){
		if((s === undefined) || (s === null)){
			return false;
		}
		else{
			s = s.trim();
			
			if(s === ""){
				return false;
			}
			else{
				return true;
			}
		}
	}
});
</script>
</body>
</html>
