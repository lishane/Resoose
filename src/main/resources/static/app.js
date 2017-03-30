angular.module('formApp', ['ngAnimate', 'ui.router'])

    .config(function ($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('form', {
                url: '',
                templateUrl: 'form.html',
                controller: 'formController'
            })
            .state('form.home', {
                url: '/home',
                templateUrl: 'form-home.html'
            })

            .state('form.options', {
                url: '/options',
                templateUrl: 'form-options.html'
            })

            .state('form.results', {
                url: '/results',
                templateUrl: 'form-results.html'
            });

        $urlRouterProvider.otherwise('/home');
    })

    .controller('formController', function ($scope, $http) {

        $scope.formData = {};

        $http.get('/business/random')
            .then(function(response) {
                $scope.data = response.data;
            });

    });

