'use strict';

angular.module("demoApp")
    .controller('ngTableDemoCtrl', ['$uibModal', '$filter', 'NgTableParams', 'NgTableDemoService', function ($uibModal, $filter, NgTableParams, NgTableDemoService) {
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

        self.createNoteWithModal = function () {
            var modalInstance = $uibModal.open({
                templateUrl: "views/partials/demoModal/viewModal.html",
                controller: "ModalDemoCtrl",
                controllerAs: "modal",
                size: "lg",
                backdrop: "static",
            });

            modalInstance.result
                .then(function (data) {
                    self.reason = 'closed';
                    NgTableDemoService.createNote(data).then(
                        function (response) {
                            self.response = response;
                            self.tableParams.reload();
                        }
                    );
                }, function () {
                    self.reason = 'dismissed';
                });
        };
    }]);

angular.module("demoApp")
    .controller("ModalDemoCtrl", ["$uibModalInstance",
        function ($uibModalInstance) {
            var modal = this;

            modal.ok = function () {
                var data = {
                    title: modal.title,
                    content: modal.content
                };
                $uibModalInstance.close(data);
            };

            modal.cancel = function () {
                $uibModalInstance.dismiss('cancel');
            };
        }]);