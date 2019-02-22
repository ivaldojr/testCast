(function () {
  'use strict';

  angular.module('BlurAdmin.pages.user')
      .controller('UserCtrl', UserCtrl);

  /** @ngInject */
  function UserCtrl($scope, $uibModal, $http) {
   var vm = this;
   
   //Função para abri modal usado para criação e edição de clientes
    $scope.showUserModal = function (page, size) {
    	
      $uibModal.open({
        animation: true,
        templateUrl: page,
        size: size,
        scope: $scope,
        resolve: {
          items: function () {
            return $scope.items;
          }
        }
      });
    };

    //Abre o modal para inserir um novo cliente
    $scope.showModalToCreateUser = function(){
    	
    	$scope.updateUserData = undefined;
    	$scope.showUserModal('app/pages/user/userModal.html', 'lg');
    }
   
    $scope.getPersonById = function(){
    	
    	if($scope.personSearch.id == undefined){
    		return;
    	}
    	
    	$http({
      		method : 'POST',
              url: '/person/getPersonById',
              data: $scope.personSearch.id
      	})
      	.success(
      		function(data) {
      			$scope.listUsers = []
      			$scope.listUsers[0] = data;
  		
      	})
          .error(function(result) {
        	  $scope.listUsers = []
          });
    }
    
    // Lista todos os clientes
    $scope.getAllUsers = function () {
        
  		$http({
      		method : 'GET',
              url: '/person/getAllPersons',
      	})
      	.success(
      		function(data) {
      			$scope.listUsers = data;
  		
      	})
          .error(function(result) {
          	alert("Falha ao listar Pessoas!")
          });
      };
      $scope.getAllUsers();
      
      //Remove um cliente
      $scope.deleteUser = function (data) {
          
          if (confirm("Deseja deletar o cliente "+data.name+" ?")) {
        	  $http({
          		method : 'POST',
                  url: '/person/deletePerson',
                  data: {data: data}
          	})
          	.success(
          		function(data) {
          			$scope.getAllUsers();
          	})
              .error(function(result) {
              	alert("Falha ao remover pessoa!");
              });
        	} 
    		
        };
        
        //Exibe o modal para editar um cliente
        $scope.showModalToEditUser = function (data) {
            
            $scope.updateUserData = angular.copy(data);            
            $scope.showUserModal('app/pages/user/userModal.html', 'lg');
          };
          
      // Exibe o modal para realizar um asimulação    
      $scope.showModalToSimulate = function (data) {
          
          $scope.updateUserData = angular.copy(data);
          $scope.showUserModal('app/pages/user/userSimulateModal.html', 'md');
        };
  }
})();

