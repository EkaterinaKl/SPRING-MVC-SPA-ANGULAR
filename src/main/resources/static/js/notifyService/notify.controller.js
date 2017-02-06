(function () {
    'use strict';
    angular
        .module('notifySrv')
        .controller('notifyCtrl', notifyCtrl);


    function notifyCtrl($scope, $uibModalInstance, msg) {

        $scope.msg = msg;

        $scope.ok = function () {
            $uibModalInstance.close();
        };

    };

})();