(function () {
    'use strict';
    angular
        .module('myApp')
        .config(function ($stateProvider, $urlRouterProvider, $locationProvider) {

            $urlRouterProvider.otherwise('/view');

            $stateProvider.//редактирование
            //NOTES: resolve не используем для загрузки больших массивов данных
            state('edit', {
                url: '/edit',
                template: '<item-list-adm></item-list-adm>'


            }).// просмотр
            state('view', {
                url: '/view',
                templateUrl: 'views/view.html',
                controller: ['$scope', '$state',
                    function ($scope, $state) {

                    }]

            }).// о программе
            state('about', {
                url: '/about',
                templateUrl: 'views/about.html',
                controller: ['$scope', '$state',
                    function ($scope, $state) {

                    }]

            }).//ошибка
            state('errForNg', {
                url: '/errForNg',
                templateUrl: 'views/err.html',
                controller: ['$scope', '$state',
                    function ($scope, $state) {

                    }]

            });
            $locationProvider.html5Mode(true);
        });


    angular
        .module('myApp')
        .config(['$httpProvider',
            function ($httpProvider) {
//TODO add interceptors for global notifying
            }]);

})();


