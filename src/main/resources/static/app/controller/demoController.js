'use strict';

angular.module("demoApp")
    .controller('demoCtrl', ['$http', 'DemoService', function ($http, DemoService) {
        var self = this;

        self.buttonMessage = "Qual e' il titolo della nota?";
        self.tooltip = 'Click per avere il titolo della nota';

        self.get = function () {
            DemoService.getDemo().then(
                function (response) {
                    self.response = response;
                }
            );
        };
    }]);