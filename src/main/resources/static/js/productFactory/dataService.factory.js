// myApp.factory('Products', function ($resource) {
// return $resource (
// 'http://localhost\\:8080/product/:id',
// {
// id:'@_id'
// }, {
// update: {method: "PUT"}
// }
// );
// });
//
//
//
//
// myApp.factory('Products',['$resource', function ($resource) {
// return function (url, params,methods) {
//
// var defaults= {
// update: {method: "PUT"},
// insert: {method: "POST"}
// };
// methods =angular.extend (defaults,methods);
// var resource=	  $resource (url,params,method);
// resource.prototype.$save=function (){
//
// if (!this.id) {
// return this.$insert();
// }
// else {
// return this.$update();
// }
//
// };
// return resource;
//
//
// };
//
//
// }]);
//
//
//
//
//
//

( function () {
    'use strict';

    angular
        .module('myApp')
        .factory('DataService', DataService);

    DataService.$inject = ['$resource'];

    function DataService($resource) {
        var PATH = 'product';
        var service = $resource('http://localhost\\:8080/' + PATH + '/:id', {
            id: '@_id'
        }, {
            update: {
                method: "PUT"
            },
            insert: {
                method: "POST"
            }
        });
        service.prototype.$save = save(this);
        return service;

        function save(item) {


        };
    }

}());