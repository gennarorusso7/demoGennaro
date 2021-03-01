'use strict';

var demoApp = angular.module('demoApp', ['ngRoute', 'ui.bootstrap', 'ngResource']);

demoApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html'
        })
        .when('/demo', {
            templateUrl: 'views/demo.html',
            controller: 'demoCtrl',
            controllerAs: 'demoController'
        });
});