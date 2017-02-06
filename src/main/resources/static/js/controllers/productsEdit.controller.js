(function () {
	     'use strict';
	     angular
   .module('myApp')
   .controller('ProductsEditController' , ProductsEditController);

ProductsEditController.$inject = ['notifyService',  'DataService'];
                    
function ProductsEditController(notifyService, DataService) { 

 
	var vm = this;


	vm.sortField = 'name';
	vm.reverse = true;

	vm.item = {};

	vm.showError = false;

	
	vm.load=load;

	vm.saveProduct = saveProduct;

	//vm.updateProduct

	vm.removeProduct = removeProduct;

	vm.updateForm = updateForm;
	vm.cleanForm = cleanForm;

	vm.getIndex = getIndex;
	vm.getError = getError;
	vm.sort = sort;

	//загрузка данных с сервреа
	
	function load() {
		DataService.query(function(products) {
			vm.items = products;
		}, function(error) {
			notifyService.notify(error.data.message);
		});
	};

	

	vm.load();



	 //NOTES
	 //можно полностью обновлять состояние или массив
	 //$state.go($state.current, {}, {reload: true});
	 //можно только одну запись
	 //vm.items.push({
	 //id:product.id,
	 //name:product.name,
	 //description:product.description,
	 //price:product.price,
	 //status:0});
	 //BP: в котроллерах не должно быть управления DOM, это происхоит в директивах



	function cleanForm(form) {
		vm.item.name = "";
		vm.item.description = "";
		vm.item.price = "";
		//BUG #001: FIXED
		form.$setPristine();
		vm.mode = 'Добавить';
	};

	function saveProduct(item, isValid, form) {

		if (isValid) {
			
			if (angular.isDefined(vm.item) && angular.isDefined(vm.item.name) && angular.isDefined(vm.item.description) && angular.isDefined(vm.item.price)) {
			
				DataService.save(vm.item, function(product) {
					vm.cleanForm(form);
					vm.load();
				}, function(error) {
					notifyService.notify(error.data.message);
				});


			} else {

				return false;
			}
		} else {

			return false;
		}

	};
	function updateForm(item) {

		vm.item.price = item.price;
		vm.item.name = item.name;
		vm.item.description = item.description;
		vm.item.id = item.id;
	};

	 function getIndex(id) {
		for (var i = 0; i < vm.items.length; i++) {

			if (vm.items[i].id == id) {
				break;
			}

		}
		return i;
	};

	 function removeProduct(item) {

		DataService.delete({
			id : item.id
		}, item, function() {

			vm.load();
		}, function(error) {
			notifyService.notify(error.data.message);
		});

	};

	function sort(direction) {
		vm.sortFiled = 'name';
		vm.reverse = direction;
	};

	 function getError(error) {

		if (angular.isDefined(error)) {
			if (error.required) {
				return "Поле не должно быть пустым";
			} else if (error.pattern) {
				return "Введите правильное значение цены";
			}
		}
	};

}

  })();