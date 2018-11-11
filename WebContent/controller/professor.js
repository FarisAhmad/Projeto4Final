var professoresModulo = angular.module('professoresModulo', []);

professoresModulo.controller("professoresController",function( $http){
	vm = this;
	urlProfessor = 'http://localhost:8080/Projeto4Final/rest/professores';

	vm.listarProfessores = function() {
		
		$http({
			url : urlProfessor,
			method : "GET"
				
		}).then(function onSuccess(response){
			vm.professores = response.data;
	
		}).catch(function onError(response){
			console.info(response);
			
		});		
		
	}
	
	vm.listarProfessores();
	
	vm.selecionaProfessor = function(professorSelecioando){
		vm.professor = professorSelecioando;
		
	}
	
	vm.limparListarCampos = function(){
		vm.professor = null;
		vm.listarProfessores();// para resolver problema na lista na exibição
	} 
	
	 vm.salvar = function(){
		 if(vm.professor == undefined){
			 alert("Preencha os Campos");
			 return 0;
		 }
			if(vm.professor.codigo == null){
				$http({
					url : urlProfessor,
					method : "POST",//Novo registro
					data : vm.professor
					
				}).then(function onSuccess(response){
					
					vm.limparListarCampos();
				}).catch(function onError(response){
					console.info(response);//alert
				});
			}else{
				$http({
					url : urlProfessor,
					method : "PUT",//Atualizar registro//mudar o hash code pra achar pelo codigo
					data : vm.professor//n tem como enviar mais de um valor aqui,criar objeto pra enviar os 2
					
				}).then(function onSuccess(response){
										 
					vm.limparListarCampos();
				}).catch(function onError(response){
					console.info(response);//alert
				});
				
			}
		 }
	 
	 vm.excluir = function(){
//		 if (vm.professor.codigo == null){
//			 alert("Selecione um registro para ser excluído !"); se codigo vazio alerta usuário
//		 }
		 $http({
			 url : urlProfessor+"/"+vm.professor.codigo,
			 method : "DELETE"
		 }).then(function onSucces(response){
			 vm.limparListarCampos();
			 
		 }).catch(function onError(response){
			 console.info(response);
		 });
		 
	 }	
});

