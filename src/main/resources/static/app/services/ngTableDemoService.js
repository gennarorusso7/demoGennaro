'use strict';

angular.module('demoApp')
	.service('NgTableDemoService', NgTableDemoService);

NgTableDemoService.$inject = ['$http'];

function NgTableDemoService($http) {
	var service = this;

	service.getPerson = function (id) {
		return $http.get('/demo/person', { params: { 'id': id } })
			.then(function (response) {
				return response.data;
			});
	};

	service.getAll = function () {
		return $http.get('/demo/all')
			.then(function (response) {
				return response.data;
			});
	};
};