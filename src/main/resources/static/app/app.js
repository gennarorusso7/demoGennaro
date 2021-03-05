'use strict';

var demoApp = angular.module('demoApp', ['ngRoute', 'ui.bootstrap', 'ngResource', 'ngTable', 'ngSanitize', 'swaggerUi']);

demoApp.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/main.html',
            controller: 'mainCtrl',
            controllerAS: 'mainCotroller'
        })
        .when('/demo', {
            templateUrl: 'views/demo.html',
            controller: 'demoCtrl',
            controllerAs: 'demoController'
        })
        .when('/swagger', {
            templateUrl: 'views/swaggerUi.html',
            controller: 'swaggerCtrl',
            controllerAS: 'swaggerCotroller'
        })
        .when('/ngTable', {
            templateUrl: 'views/ngTable-demo.html',
            controller: 'ngTableDemoCtrl',
            controllerAs: 'ngTableDemoController'
        })
        .when('/form', {
            templateUrl: 'views/form.html',
            controller: 'ngTableDemoCtrl',
            controllerAs: 'ngTableDemoController'
        });
});