
(function () {
    'use strict';
    angular
        .module('notifySrv')
        .service('notifyService', notifyService);

    notifyService.$inject = ['$uibModal'];

    function notifyService($uibModal) {
        this.notify = function (msg) {

            var modal = $uibModal.open({
                template: '<notify-directive></notify-directive>',

                size: 'sm',

                controller: 'notifyCtrl',
                resolve: {
                    msg: function () {
                        return msg;
                    }
                }

            });
        }
        return this;
    }

})();