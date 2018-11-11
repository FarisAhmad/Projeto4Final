var cursosModulo = angular.module('cursosModulo', []);

cursosModulo.controller("cursosController",function( $http){
	vm = this;
	urlCurso = 'http://localhost:8080/Projeto4Final/rest/cursos';
	urlProfessor = 'http://localhost:8080/Projeto4Final/rest/professores';

	vm.listar = function(){
		console.log("sadadsa");
	};
	
	vm.listarCursos = function() {
		
		$http({
			url : urlCurso,
			method : "GET"
				
		}).then(function onSuccess(response){
			vm.cursos = response.data;
	
		}).catch(function onError(response){
			console.info(response);
			
		});		
	}
	
	vm.listarProfessores = function() {
		$http({
			url: urlProfessor,
			method : "GET"
			
		}).then(function onSuccess(response){
			vm.professores = response.data;
	
		}).catch(function onError(response){
			console.info(response);
			
		});
		
		
	}
	// executa
	vm.listarCursos();
	vm.listarProfessores();
	
	vm.selecionaCurso = function(cursoSelecioando){
		vm.curso = cursoSelecioando;
		
	}
	
	vm.limparCampos = function(){
		vm.curso = null;
		vm.listarCursos();//para resolver problema na lista na exibição
	} 
	
	 vm.salvar = function(){
			if(vm.curso.codigo == null){
				$http({
					url : urlCurso,
					method : "POST",// Novo registro
					data : vm.curso
					
				}).then(function onSuccess(response){		
					// limpar
					vm.limparCampos();
				}).catch(function onError(response){
					console.info(response);// alert
				});
			}else{
				$http({
					url : urlCurso,
					method : "PUT",// Atualizar registro//mudar o hash code pra
									// achar pelo codigo
					data : vm.curso// n tem como enviar mais de um valor
									// aqui,criar objeto pra enviar os 2
					
				}).then(function onSuccess(response){
					vm.limparCampos();
					
				}).catch(function onError(response){
					console.info(response);// alert
				});
				
			}
		 }
	 
	 vm.excluir = function(){
// if (vm.curso.codigo == null){
// alert("Selecione um registro para ser excluído !"); se codigo vazio alerta
// usuário
// }
		 $http({
			 url : urlCurso+"/"+vm.curso.codigo,
			 method : "DELETE"
		 }).then(function onSucces(response){
			 	vm.limparCampos();
			 	
		 }).catch(function onError(response){
			 console.info(response);
		 });
		 
	 }

});

