'use strict';

angular.module("demoApp")
    .controller('ngTableDemoCtrl', ['$filter', 'NgTableParams', 'NgTableDemoService', function ($filter, NgTableParams, NgTableDemoService) {
        var self = this;

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

        self.createNote = function () {

            var newNote = {
                title: self.title,
                content: self.content
            };

            NgTableDemoService.createNote(newNote).then(
                function (response) {
                    self.response = response;
                }
            );
        };
    }]);