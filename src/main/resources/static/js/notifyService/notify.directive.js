(function () {
    'use strict';
    angular.module('notifySrv').directive('notifyDirective', function () {
        return {
            link: function (scope, element, attrs) {
                console.log('scope', scope);
            },

            restrict: 'E',
            template: '<div class="modal-header bg-warning">' +
            '<h3 class="modal-title">Ошибка</h3>' +
            '</div>' +
            '<div class="modal-body">' +
            '{{msg}}' +
            '</div>' +
            ' <div class="modal-footer">' +
            '<button class="btn btn-primary" type="button" ng-click="ok();">OK</button>'


        };
    });
})();