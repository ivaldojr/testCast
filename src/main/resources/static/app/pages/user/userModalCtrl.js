(function () {
  'use strict';

  angular.module('BlurAdmin.pages.user')
      .controller('UserModalCtrl', UserModalCtrl);

  /** @ngInject */
  function UserModalCtrl($scope, $uibModal,$http) {
   var vm = this;
   
   	//trata alguns elementos de tela ao abrir o modal
    $scope.modalOpen = function(){    	
    	
    	if($scope.updateUserData != undefined){
    		$scope.person = angular.copy($scope.updateUserData);
    		
    	}
    }
    
    //trata alguns elementos de tela ao abrir o modal
    $scope.modalOpen();
    
    // Verifica se deve criar ou atualizar um usuário
    $scope.createOrUpdateUser = function () {
    	
    	if($scope.person.id == undefined || $scope.person.id == null){
    		$scope.createUser();
    	}else{
    		$scope.updateUser();
    		$scope.setEnabledFields();
    	}
    };
    
    //Cria usuário
    $scope.createUser = function () {
      // alert("cadastrar usuário");
      
		$http({
    		method : 'POST',
            url: '/person/createPerson',
            data: {data: $scope.person}
    	})
    	.success(
    		function(data) {
    			$scope.getAllUsers();
    			alert("Pessoa criada com sucesso!")
    			$scope.$dismiss();
    	})
        .error(function(result) {
        	("Falha ao inserir pessoa!");
        });
    };
    
    //Atualiza usuário
    $scope.updateUser = function () {
        
        
  		$http({
      		method : 'POST',
              url: '/person/updatePerson',
              data: {data: $scope.person}
      	})
      	.success(
      		function(data) {
      			$scope.getAllUsers();
      			alert("Cliente atualizado com sucesso!");
      			$scope.$dismiss();
      	})
          .error(function(result) {
        	  alert("Falha ao editar daos do cliente!");
          });
      };
      // seta o valor com campo risco de acordo com o valor informado no rendimento
      $scope.setRisco = function () {
    	  
    	  if($scope.user.rendimento <= 2000){
    		  $scope.user.risco = "A";
    	  }else if ($scope.user.rendimento <= 8000){
    		  $scope.user.risco = "B";
    	  }else if ($scope.user.rendimento > 8000){
    		  $scope.user.risco = "C";
    	  }
      }
      
      $scope.disabledPatrimonio = true;
	  $scope.disabledDivida = true;
	  $scope.disabledEmpregado = true;

	  // habilita ou desabilita campos de acordo com regra de selação do tipo de cliente
      $scope.setEnabledFields = function () {
    	  
    	  if($scope.user != undefined){
	    	  if($scope.user.tipo == "Comum"){
	    		  $scope.disabledPatrimonio = true;
	    		  $scope.disabledDivida = true;
	    		  $scope.disabledEmpregado = false;
	  		  
	    	  }else if ($scope.user.tipo == "Potencial"){
	    		  $scope.disabledPatrimonio = true;
	    		  $scope.disabledDivida = false;
	    		  $scope.disabledEmpregado = true;
	    	  }else if ($scope.user.tipo == "Especial"){
	    		  $scope.disabledPatrimonio = false;
	    		  $scope.disabledDivida = true;
	    		  $scope.disabledEmpregado = true;
	    	  }
    	  }    	  
      }
      
      /*
       * Funções do modal de simulação
       * Obs. Transferir para um controler do modal de Simulação
       */
      $scope.simulate = function () {

			$http({
	    		method : 'POST',
	            url: '/user/simulate',
	            data: {data: $scope.user}
	    	})
	    	.success(
	    		function(data) {
	    			$scope.resultSimulation = data;
			
	    	})
	        .error(function(result) {
	        	alert("Falha ao realizar simulação!");
	        });
      }  
      /*
       * Fim das funções do modal de simulação
       */
      
  }
})();

