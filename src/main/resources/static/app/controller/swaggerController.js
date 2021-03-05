'use strict';

angular.module("demoApp")
	.controller('swaggerCtrl', ['$scope', function ($scope) {
		$scope.url = 'http://localhost:8080/v2/api-docs?group=noteController-api-server';

		$scope.myErrorHandler = function (data, status) {
			alert('failed to load swagger: ' + status);
			console.log(data);
		};
	}]);