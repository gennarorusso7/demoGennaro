'use strict';

angular.module("demoApp")
    .controller('ngTableDemoCtrl', ['$filter', 'NgTableParams', 'NgTableDemoService', function ($filter, NgTableParams, NgTableDemoService) {
        var self = this;

        self.buttonMessage = "Get";
        self.tooltip = 'Call back-end';

        self.getAll = function (params) {
            return NgTableDemoService.getAll().then(
                function (response) {
                    response = $filter("filter")(response, params.filter());
                    return $filter("orderBy")(response, params.orderBy());
                }
            );
        };

        self.tableParams = new NgTableParams({}, {
            getData: self.getAll
        });
    }]);