(function () {
    'use strict';

    angular
        .module('myApp', ['ui.router', 'ngResource', 'notifySrv', 'itemListAdm'])
        .run(['$rootScope', '$state', '$stateParams',
            function ($rootScope, $state, $stateParams) {
                $rootScope.$state = $state;
                $rootScope.$stateParams = $stateParams;
            }]);

})();

