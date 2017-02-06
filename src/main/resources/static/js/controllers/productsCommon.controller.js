(function () {
    'use strict';
    angular
        .module('myApp')
        .controller('ProductsCommonController' , ProductsCommonController);
    ProductsCommonController.$inject = ['notifyService',  'DataService'];
    function ProductsCommonController(notifyService,  DataService) {
        var vm = this;

        function load () {
            DataService.query(function(products) {
                vm.items = products;
            }, function(error) {
                //notifyService.notify(error.message);
            });
        };

        load();
    }



})();