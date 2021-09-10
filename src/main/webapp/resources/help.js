var appModule = angular.module("HelpApp", []);
appModule.value('urlBase', 'http://localhost:8080/projeto-chamados-javaee/rest');

appModule.controller("ChamadoController", function ($scope, $http, urlBase) {
    $scope.usuario = 'Thiago Piffer';

    $scope.chamados = [];
    $scope.chamado = undefined;

    $scope.novo = function () {
        $scope.chamado = {};
    };

    $scope.salvar = function () {
        var metodo = 'POST';
        if ($scope.chamado.id) {
            metodo = 'PUT';
        }

        $http({
            method: metodo,
            url: urlBase + '/chamados',
            data: $scope.chamado
        }).then(function successCallback(response) {
            $scope.atualizarTabela();
        }, function errorCallback(response) {
            $scope.ocorreuErro(response.statusText);
        });
    };

    $scope.alterar = function (chamado) {
        $scope.chamado = chamado;
    };

    $scope.deletar = function (chamado) {
        $scope.chamado = chamado;

        $http({
            method: 'DELETE',
            url: urlBase + '/chamados/' + $scope.chamado.id + '/'
        }).then(function successCallback(response) {
            $scope.atualizarTabela();
        }, function errorCallback(response) {
            $scope.ocorreuErro(response.statusText);
        });
    };

    $scope.concluir = function (chamado) {
        chamado.status = "FECHADO";
        console.log(chamado);

        $http({
            method: 'PUT',
            url: urlBase + '/chamados',
            data: chamado
        }).then(function successCallback(response) {
            console.log(response);
            $scope.atualizarTabela();
        }, function errorCallback(response) {
            $scope.ocorreuErro(response.statusText);
        });
    };

    $scope.ocorreuErro = function (errorMessage) {
        alert("Ocorreu um erro inesperado: " + errorMessage);
    };

    $scope.atualizarTabela = function () {
        $http({
            method: 'GET',
            url: urlBase + '/chamados'
        }).then(function successCallback(response) {
            $scope.chamados = response.data;
            $scope.chamado = undefined;
        }, function errorCallback(response) {
            $scope.ocorreuErro(response.statusText);
        });
    };

    $scope.activate = function (){
        $scope.atualizarTabela();
    };
    $scope.activate();
});