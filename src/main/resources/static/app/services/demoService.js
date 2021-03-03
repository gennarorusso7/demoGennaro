(function () {
    'use strict';

    angular.module('demoApp')
        .service('DemoService', DemoService);

    DemoService.$inject = ['$http'];

    function DemoService($http) {
        var service = this;

        service.getDemo = function () {
            return $http.get('/api/string').then(function (response) {
                return response.data;
            });
        };

        service.deleteDemo = function (id) {
            return $http.delete('/demo/' + id)
                .then(function (response) {
                    return response.status;
                });
        };

        service.addDemo = function (id, requestBody) {
            return $http.post('/demo', requestBody)
                .then(function (response) {
                    return response;
                });
        };

        service.updateDemo = function (id) {
            return $http.put('/demo',
                { params: { id: id } })
                .then(function (response) {
                    return response;
                });
        };
    };
})();